package com.akross.gateway.enquiry;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;
import com.akross.gateway.enquiry.entity.RentalEvaluationEnquiryResponse;
import com.akross.gateway.enquiry.exception.RentalEvaluationEnquiryException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.akross.domain.enquiry.RentalEvaluationEnquiryRequest.RentalEvaluationEnquiryRequestBuilder.aRentalEvaluationEnquiryRequest;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@RunWith(MockitoJUnitRunner.class)
public class HttpEnquiryClientUnitTest {

    private static final String PATH = "api/example";

    @Rule
    public ExpectedException expectedException = none();

    @Mock
    private RestTemplate jupixEnquiryRestClient;

    @InjectMocks
    private HttpEnquiryClient httpEnquiryClient;

    private static String createExpectedHttpRentalEvaluationEnquiryRequest(
            final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest, final String apiKey
            , final String agentCode, final int branchCode, double version, final String emailAddress) {
        return "apiKey=" + apiKey +
                "&agentCode=" + agentCode +
                "&branchCode=" + branchCode +
                "&version=" + version +
                "&firstName=" + rentalEvaluationEnquiryRequest.getFirstName() +
                "&lastName=" + rentalEvaluationEnquiryRequest.getLastName() +
                "&From=" + emailAddress +
                "&to=" + rentalEvaluationEnquiryRequest.getEmailAddress() +
                "&address=" + rentalEvaluationEnquiryRequest.getAddressLine1() + " "
                + rentalEvaluationEnquiryRequest.getAddressLine2() + " "
                + rentalEvaluationEnquiryRequest.getCity() + " "
                + rentalEvaluationEnquiryRequest.getCountry() +
                "&postcode=" + rentalEvaluationEnquiryRequest.getPostcode() +
                "&phoneDay=" + rentalEvaluationEnquiryRequest.getTelephone() +
                "&requestMailingList=" + (rentalEvaluationEnquiryRequest.getKeepUpdatedOnMortgage() ? 1 : 0) +
                "&propToRent=1" +
                "&comment=" + rentalEvaluationEnquiryRequest.getAdditionalComments();
    }

    private static RentalEvaluationEnquiryRequest createRentalEvaluationEnquiryRequest() {
        return aRentalEvaluationEnquiryRequest()
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
    }

    private static ResponseEntity<RentalEvaluationEnquiryResponse>
    createResponseEntityRentalEvaluationEnquiryResponse(final HttpStatus httpStatus, final int success
            , final String response) {
        final RentalEvaluationEnquiryResponse rentalEvaluationEnquiryResponse
                = mock(RentalEvaluationEnquiryResponse.class);
        when(rentalEvaluationEnquiryResponse.getSuccess()).thenReturn(success);
        when(rentalEvaluationEnquiryResponse.getResponse()).thenReturn(response);
        return ResponseEntity
                .status(httpStatus)
                .body(rentalEvaluationEnquiryResponse);
    }

    @Before
    public void setUp() throws Exception {
        setField(httpEnquiryClient, "path", PATH);
    }

    @Test
    public void shouldSendRentalEvaluationEnquiresRequest() {
        final String expectedHttpRentalEvaluationEnquiryRequest
                = createExpectedHttpRentalEvaluationEnquiryRequest(createRentalEvaluationEnquiryRequest()
                , "apiKey", "agentCode", 1, 2.0, "test@example.com");

        final int success = 1;
        final String response = "Enquiry added successfully";

        setupJupixEnquiryRestClient(expectedHttpRentalEvaluationEnquiryRequest, success, response);

        httpEnquiryClient.sendRentalEvaluationEnquiry(expectedHttpRentalEvaluationEnquiryRequest);

        assertWhatShouldHappen(expectedHttpRentalEvaluationEnquiryRequest);
    }

    @Test
    public void shouldThrowRentalEvaluationEnquiryExceptionWhenUnsuccessful() {
        final String expectedHttpRentalEvaluationEnquiryRequest
                = createExpectedHttpRentalEvaluationEnquiryRequest(createRentalEvaluationEnquiryRequest()
                , "apiKey", "agentCode", 1, 2.0, "test@example.com");
        final int success = 0;
        final String response = "Invalid POST data";

        setupJupixEnquiryRestClient(expectedHttpRentalEvaluationEnquiryRequest, success, response);

        try {
            httpEnquiryClient.sendRentalEvaluationEnquiry(expectedHttpRentalEvaluationEnquiryRequest);
            fail("My method didn't throw when I expected it to");
        } catch (final RentalEvaluationEnquiryException rentalEvaluationEnquiryException) {
            assertThat(rentalEvaluationEnquiryException.getMessage()
                    , is("Failed to successfully send rental Evaluation enquiry"));
            assertWhatShouldHappen(expectedHttpRentalEvaluationEnquiryRequest);
        }
    }

    private void setupJupixEnquiryRestClient(final String httpRentalEvaluationEnquiryRequest
            , final int success
            , final String response) {

        final ResponseEntity<RentalEvaluationEnquiryResponse> responseEntityRentalEvaluationEnquiryResponse
                = createResponseEntityRentalEvaluationEnquiryResponse(OK, success, response);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(TEXT_PLAIN);

        when(jupixEnquiryRestClient.postForEntity(PATH, new HttpEntity<>(httpRentalEvaluationEnquiryRequest, headers)
                , RentalEvaluationEnquiryResponse.class))
                .thenReturn(responseEntityRentalEvaluationEnquiryResponse);
    }

    private void assertWhatShouldHappen(final String httpRentalEvaluationEnquiryRequest) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(TEXT_PLAIN);
        verify(jupixEnquiryRestClient).postForEntity(PATH
                , new HttpEntity<>(httpRentalEvaluationEnquiryRequest, headers)
                , RentalEvaluationEnquiryResponse.class
        );
        verifyNoMoreInteractions(jupixEnquiryRestClient);
    }
}