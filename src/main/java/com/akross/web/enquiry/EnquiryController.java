package com.akross.web.enquiry;

import com.akross.service.EnquiryService;
import com.akross.web.enquiry.entity.RentalEvaluationEnquiryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import static com.akross.domain.enquiry.RentalEvaluationEnquiryRequest.RentalEvaluationEnquiryRequestBuilder.aRentalEvaluationEnquiryRequest;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/enquiries")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(value = BAD_REQUEST)
    private static String badRequest(final HttpMessageNotReadableException httpMessageNotReadableException) {
        return httpMessageNotReadableException.getMessage().split(";")[0];
    }

    @RequestMapping(method = POST, consumes = {APPLICATION_JSON_VALUE})
    @ResponseStatus(code = CREATED)
    public void createRentalEvaluationEnquires(
            @RequestBody final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest) {
        enquiryService.sendRentalEvaluationEnquiry(aRentalEvaluationEnquiryRequest()
                .withFirstName(rentalEvaluationEnquiryRequest.getFirstName())
                .withLastName(rentalEvaluationEnquiryRequest.getLastName())
                .withAddressLine1(rentalEvaluationEnquiryRequest.getAddressLine1())
                .withAddressLine2(rentalEvaluationEnquiryRequest.getAddressLine2())
                .withCity(rentalEvaluationEnquiryRequest.getCity())
                .withCountry(rentalEvaluationEnquiryRequest.getCountry())
                .withPostcode(rentalEvaluationEnquiryRequest.getPostcode())
                .withTelephone(rentalEvaluationEnquiryRequest.getTelephone())
                .withEmailAddress(rentalEvaluationEnquiryRequest.getEmailAddress())
                .withTelephonePreference(rentalEvaluationEnquiryRequest.getTelephonePreference())
                .withEmailPreference(rentalEvaluationEnquiryRequest.getEmailPreference())
                .withAdditionalComments(rentalEvaluationEnquiryRequest.getAdditionalComments())
                //  .withPropertyOwned(rentalEvaluationEnquiryRequest.getPropertyOwned())
                .withKeepUpdatedOnMortgage(rentalEvaluationEnquiryRequest.getKeepUpdatedOnMortgage())
                .build()
        );
    }
}