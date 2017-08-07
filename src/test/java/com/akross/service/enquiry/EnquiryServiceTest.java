package com.akross.service.enquiry;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;
import com.akross.gateway.EnquiryClient;
import com.akross.gateway.enquiry.exception.RentalEvaluationEnquiryException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.akross.domain.enquiry.RentalEvaluationEnquiryRequest.RentalEvaluationEnquiryRequestBuilder.aRentalEvaluationEnquiryRequest;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EnquiryServiceTest {

    @Rule
    public ExpectedException expectedException = none();

    @Mock
    private EnquiryClient enquiryClient;

    @InjectMocks
    private EnquiryService enquiryService;

    @Test
    public void shouldSendRentalEvaluationEnquiresRequest() {
        final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest = aRentalEvaluationEnquiryRequest()
                .withFirstName("Steve")
                .withLastName("Smith")
                .withAddressLine1("foo")
                .withAddressLine2("Bar")
                .withCity("Bar")
                .withCountry("Bar")
                .withPostcode("nw10 4hk")
                .withTelephone("54748456356")
                .withEmailAddress("happy@msn.com")
                .withTelephonePreference(true)
                .withEmailPreference(true)
                .withAdditionalComments("Bar")
                .withPropertyOwned(true)
                .withKeepUpdatedOnMortgage(true)
                .build();
        enquiryService.sendRentalEvaluationEnquiry(rentalEvaluationEnquiryRequest);
        verify(enquiryClient).sendRentalEvaluationEnquiry(rentalEvaluationEnquiryRequest);
        verifyNoMoreInteractions(enquiryClient);
    }

    @Test
    public void shouldThrowRentalEvaluationEnquiryExceptionWhenMissingMandatoryField() {
        expectedException.expect(RentalEvaluationEnquiryException.class);
        expectedException.expectMessage("Mandatory fields missing are: firstName, lastName" +
                ", addressLine1, postcode, telephone, emailAddress");
        enquiryService.sendRentalEvaluationEnquiry(aRentalEvaluationEnquiryRequest()
                .withAddressLine2("Bar")
                .withCity("Bar")
                .withCountry("Bar")
                .withTelephonePreference(true)
                .withEmailPreference(true)
                .withAdditionalComments("Bar")
                .withPropertyOwned(true)
                .withKeepUpdatedOnMortgage(true)
                .build());
        verifyZeroInteractions(enquiryClient);
    }
}