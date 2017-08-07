package com.akross.service;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;

public interface EnquiryService {
    void sendRentalEvaluationEnquiry(final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest);
}
