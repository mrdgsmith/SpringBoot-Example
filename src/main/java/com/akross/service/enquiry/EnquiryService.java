package com.akross.service.enquiry;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;
import com.akross.gateway.EnquiryClient;
import com.akross.gateway.enquiry.exception.RentalEvaluationEnquiryException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;
import static java.util.Objects.isNull;

public class EnquiryService implements com.akross.service.EnquiryService {

    private final EnquiryClient enquiryClient;

    public EnquiryService(final EnquiryClient enquiryClient) {
        this.enquiryClient = enquiryClient;
    }

    private static void checkMandatoryFields(final String firstName
            , final String lastName
            , final String addressLine1
            , final String postcode
            , final String telephone
            , final String emailAddress) {
        final List<String> messageList = new ArrayList<>();
        if (isNull(firstName)) {
            messageList.add("firstName");
        }
        if (isNull(lastName)) {
            messageList.add("lastName");
        }
        if (isNull(addressLine1)) {
            messageList.add("addressLine1");
        }
        if (isNull(postcode)) {
            messageList.add("postcode");
        }
        if (isNull(telephone)) {
            messageList.add("telephone");
        }
        if (isNull(emailAddress)) {
            messageList.add("emailAddress");
        }
        if (!messageList.isEmpty()) {
            throw new RentalEvaluationEnquiryException(format("Mandatory fields missing are: {0}"
                    , messageList.stream().collect(Collectors.joining(", "))));
        }
    }

    @Override
    public void sendRentalEvaluationEnquiry(final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest) {
        checkMandatoryFields(rentalEvaluationEnquiryRequest.getFirstName()
                , rentalEvaluationEnquiryRequest.getLastName()
                , rentalEvaluationEnquiryRequest.getAddressLine1()
                , rentalEvaluationEnquiryRequest.getPostcode()
                , rentalEvaluationEnquiryRequest.getTelephone()
                , rentalEvaluationEnquiryRequest.getEmailAddress()
        );
        enquiryClient.sendRentalEvaluationEnquiry(rentalEvaluationEnquiryRequest);
    }
}