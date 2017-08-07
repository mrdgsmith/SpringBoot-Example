package com.akross.gateway;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;

public interface EnquiryClient {
    void sendRentalEvaluationEnquiry(final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest);
}
