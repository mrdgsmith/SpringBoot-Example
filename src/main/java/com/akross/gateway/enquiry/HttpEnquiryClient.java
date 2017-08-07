package com.akross.gateway.enquiry;

import com.akross.gateway.enquiry.entity.RentalEvaluationEnquiryResponse;
import com.akross.gateway.enquiry.exception.RentalEvaluationEnquiryException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.TEXT_PLAIN;

public class HttpEnquiryClient {

    private static final String SUCCESS_RESPONSE_MESSAGE = "Enquiry added successfully";
    private static final String FAILED_MESSAGE = "Failed to successfully send rental Evaluation enquiry";
    private final RestTemplate jupixEnquiryRestClient;
    private final String path;

    public HttpEnquiryClient(final RestTemplate jupixEnquiryRestClient
            , final String path) {

        this.jupixEnquiryRestClient = jupixEnquiryRestClient;
        this.path = path;
    }

    private static void checkResponseEntityRentalEvaluationEnquiryResponseIsSuccessful(
            final ResponseEntity<RentalEvaluationEnquiryResponse> responseEntityRentalEvaluationEnquiryResponse) {
        if (!OK.equals(responseEntityRentalEvaluationEnquiryResponse.getStatusCode())
                || !nonNull(responseEntityRentalEvaluationEnquiryResponse.getBody())
                || responseEntityRentalEvaluationEnquiryResponse.getBody().getSuccess() != 1
                || !SUCCESS_RESPONSE_MESSAGE.equals(responseEntityRentalEvaluationEnquiryResponse.getBody()
                .getResponse())) {
            throw new RentalEvaluationEnquiryException(FAILED_MESSAGE);
        }
    }

    public void sendRentalEvaluationEnquiry(final String httpRentalEvaluationEnquiryRequest) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(TEXT_PLAIN);
        final ResponseEntity<RentalEvaluationEnquiryResponse> responseEntityRentalEvaluationEnquiryResponse
                = jupixEnquiryRestClient.postForEntity(path
                , new HttpEntity<>(httpRentalEvaluationEnquiryRequest, headers)
                , RentalEvaluationEnquiryResponse.class);
        checkResponseEntityRentalEvaluationEnquiryResponseIsSuccessful(responseEntityRentalEvaluationEnquiryResponse);
    }
}