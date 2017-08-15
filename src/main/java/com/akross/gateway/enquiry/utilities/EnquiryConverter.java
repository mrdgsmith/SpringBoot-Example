package com.akross.gateway.enquiry.utilities;


import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;

import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.joining;
import static org.springframework.web.util.UriComponentsBuilder.newInstance;

public class EnquiryConverter {

    private static String buildAddress(final String... addressParts) {
        return Stream.of(addressParts)
                .filter(Objects::nonNull)
                .collect(joining(" "));
    }

    private static int isKeepUpdatedOnMortgage(final Boolean keepUpdatedOnMortgage) {
        return (nonNull(keepUpdatedOnMortgage) && keepUpdatedOnMortgage) ? 1 : 0;
    }

    public String convertToHttpRentalEvaluationEnquiryRequest(
            final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest, final String apiKey
            , final String agentCode, final int branchCode, double version, final String emailAddress) {
        return newInstance()
                .queryParam("apiKey", apiKey)
                .queryParam("agentCode", agentCode)
                .queryParam("branchCode", branchCode)
                .queryParam("version", version)
                .queryParam("firstName", rentalEvaluationEnquiryRequest.getFirstName())
                .queryParam("lastName", rentalEvaluationEnquiryRequest.getLastName())
                .queryParam("From", emailAddress)
                .queryParam("to", rentalEvaluationEnquiryRequest.getEmailAddress())
                .queryParam("address", buildAddress(rentalEvaluationEnquiryRequest.getAddressLine1()
                        , rentalEvaluationEnquiryRequest.getAddressLine2()
                        , rentalEvaluationEnquiryRequest.getCity()
                        , rentalEvaluationEnquiryRequest.getCountry())
                )
                .queryParam("postcode", rentalEvaluationEnquiryRequest.getPostcode())
                .queryParam("phoneDay", rentalEvaluationEnquiryRequest.getTelephone())
                .queryParam("requestMailingList", isKeepUpdatedOnMortgage(rentalEvaluationEnquiryRequest.getKeepUpdatedOnMortgage()))
                .queryParam("propToRent", 1)
                .queryParam("comment", rentalEvaluationEnquiryRequest.getAdditionalComments())
                .build()
                .encode()
                .toUri()
                .getQuery();
    }
}