package com.akross.gateway.enquiry;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;
import com.akross.gateway.enquiry.configuration.JupixEnquiryRestClientProperties;
import com.akross.gateway.enquiry.utilities.EnquiryConverter;

public class EnquiryClient implements com.akross.gateway.EnquiryClient {

    private final HttpEnquiryClient httpEnquiryClient;
    private final EnquiryConverter enquiryConverter;
    private final JupixEnquiryRestClientProperties jupixEnquiryRestClientProperties;

    public EnquiryClient(final HttpEnquiryClient httpEnquiryClient
            , final EnquiryConverter enquiryConverter
            , final JupixEnquiryRestClientProperties jupixEnquiryRestClientProperties) {
        this.httpEnquiryClient = httpEnquiryClient;
        this.enquiryConverter = enquiryConverter;
        this.jupixEnquiryRestClientProperties = jupixEnquiryRestClientProperties;
    }

    @Override
    public void sendRentalEvaluationEnquiry(final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest) {
        final String httpRentalEvaluationEnquiresRequest
                = enquiryConverter
                .convertToHttpRentalEvaluationEnquiryRequest(rentalEvaluationEnquiryRequest
                        , jupixEnquiryRestClientProperties.getApiKey()
                        , jupixEnquiryRestClientProperties.getAgentCode()
                        , jupixEnquiryRestClientProperties.getBranchCode()
                        , jupixEnquiryRestClientProperties.getVersion()
                        , jupixEnquiryRestClientProperties.getEnquirerEmail());
        httpEnquiryClient.sendRentalEvaluationEnquiry(httpRentalEvaluationEnquiresRequest);
    }
}