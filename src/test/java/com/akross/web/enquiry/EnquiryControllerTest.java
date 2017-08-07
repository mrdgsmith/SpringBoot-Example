package com.akross.web.enquiry;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest.RentalEvaluationEnquiryRequestBuilder;
import com.akross.gateway.enquiry.exception.RentalEvaluationEnquiryException;
import com.akross.service.EnquiryService;
import com.akross.web.enquiry.entity.RentalEvaluationEnquiryRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.akross.web.enquiry.entity.builders.TestRentalEvaluationEnquiryRequestBuilder.aRentalEvaluationEnquiryRequest;
import static com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EnquiryController.class)
@AutoConfigureWebClient
//@AutoConfigureRestDocs("target/generated-snippets")
public class EnquiryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnquiryService enquiryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnHttpStatus201WhenValidRentalEvaluationEnquiryRequestReceived() throws Exception {
        final com.akross.domain.enquiry.RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest
                = RentalEvaluationEnquiryRequestBuilder.aRentalEvaluationEnquiryRequest()
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
        doNothing().when(enquiryService).sendRentalEvaluationEnquiry(rentalEvaluationEnquiryRequest);

        mockMvc.perform(post("/enquiries")
                .content(createRentalEvaluationEnquiryRequestJsonBody(aRentalEvaluationEnquiryRequest()
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
                        .build()))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
        verify(enquiryService).sendRentalEvaluationEnquiry(rentalEvaluationEnquiryRequest);
        verifyNoMoreInteractions(enquiryService);
    }

    @Test
    public void shouldReturnHttpStatus400WhenMissingMandatoryFields() throws Exception {
        mockMvc.perform(post("/enquiries")
                .content(createRentalEvaluationEnquiryRequestJsonBody(aRentalEvaluationEnquiryRequest()
                                .withAddressLine2("Bar")
                                .withCity("Bar")
                                .withCountry("Bar")
                                .withTelephonePreference(true)
                                .withEmailPreference(true)
                                .withAdditionalComments("Bar")
                                .withPropertyOwned(true)
                                .withKeepUpdatedOnMortgage(true)
                                .build()
                        )
                )
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content()
                        .string("JSON parse error: Missing required creator property 'firstName'" +
                                " (index 0)")
                );
        verifyZeroInteractions(enquiryService);
    }

    @Test
    public void shouldReturnHttpStatus400WhenEnquiryRentalEvaluationEnquiryExceptionThrown() throws Exception {
        final String expectedExceptionMessage = "Mandatory fields missing are: firstName, lastName" +
                ", addressLine1, postcode, telephone, emailAddress";
        final com.akross.domain.enquiry.RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest
                = RentalEvaluationEnquiryRequestBuilder.aRentalEvaluationEnquiryRequest()
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
        willThrow(new RentalEvaluationEnquiryException(expectedExceptionMessage))
                .given(enquiryService)
                .sendRentalEvaluationEnquiry(rentalEvaluationEnquiryRequest);

        mockMvc.perform(post("/enquiries")
                .content(createRentalEvaluationEnquiryRequestJsonBody(aRentalEvaluationEnquiryRequest()
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
                        .build()))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(expectedExceptionMessage));
        verify(enquiryService).sendRentalEvaluationEnquiry(rentalEvaluationEnquiryRequest);
        verifyNoMoreInteractions(enquiryService);
    }

    private String createRentalEvaluationEnquiryRequestJsonBody(
            final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest) throws JsonProcessingException {
        objectMapper.disable(WRAP_ROOT_VALUE);
        return objectMapper.writeValueAsString(rentalEvaluationEnquiryRequest);
    }
}