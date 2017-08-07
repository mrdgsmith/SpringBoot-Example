package com.akross.gateway.enquiry;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;
import com.akross.gateway.enquiry.configuration.EnquiryGatewayConfiguration;
import com.akross.gateway.enquiry.exception.RentalEvaluationEnquiryException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static com.akross.domain.enquiry.RentalEvaluationEnquiryRequest.RentalEvaluationEnquiryRequestBuilder.aRentalEvaluationEnquiryRequest;
import static org.junit.rules.ExpectedException.none;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_XML;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(HttpEnquiryClient.class)
@ContextConfiguration(classes = {EnquiryGatewayConfiguration.class})
public class HttpEnquiryClientTest {

    @Rule
    public ExpectedException expectedException = none();

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private HttpEnquiryClient httpEnquiryClient;

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

    private static String getSuccessfullyRentalEvaluationEnquiryResponse() {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<data>\n" +
                "<success>1</success>\n" +
                "<response>Enquiry added successfully</response>\n" +
                "</data>";
    }

    private static String getFailureRentalEvaluationEnquiryResponse() {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<data>\n" +
                "<success>0</success>\n" +
                "<response>Invalid Post data</response>\n" +
                "</data>";
    }

    @Test
    public void shouldGetSuccessfullyRentalEvaluationEnquiryResponse() {
        final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest = createRentalEvaluationEnquiryRequest();
        final String expectedHttpRentalEvaluationEnquiryRequest = createExpectedHttpRentalEvaluationEnquiryRequest(
                rentalEvaluationEnquiryRequest
                , "apiKey", "agentCode", 1, 2.0, "test@example.com");
        mockRestServiceServer.expect(requestTo("/api/enquiries/post_enquiry.php"))
                .andExpect(method(POST))
                .andExpect(content().contentType(TEXT_PLAIN))
                .andExpect(content()
                        .string(expectedHttpRentalEvaluationEnquiryRequest))
                .andRespond(withSuccess(getSuccessfullyRentalEvaluationEnquiryResponse(), APPLICATION_XML));
        httpEnquiryClient.sendRentalEvaluationEnquiry(expectedHttpRentalEvaluationEnquiryRequest);
    }

    @Test
    public void shouldThrowRentalEvaluationEnquiryException() {
        final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest = createRentalEvaluationEnquiryRequest();
        final String expectedHttpRentalEvaluationEnquiryRequest = createExpectedHttpRentalEvaluationEnquiryRequest(
                rentalEvaluationEnquiryRequest
                , "apiKey", "agentCode", 1, 2.0, "test@example.com");
        mockRestServiceServer.expect(requestTo("/api/enquiries/post_enquiry.php"))
                .andExpect(method(POST))
                .andExpect(content().contentType(TEXT_PLAIN))
                .andExpect(content()
                        .string(expectedHttpRentalEvaluationEnquiryRequest))
                .andRespond(withSuccess(getFailureRentalEvaluationEnquiryResponse(), APPLICATION_XML));
        expectedException.expect(RentalEvaluationEnquiryException.class);
        expectedException.expectMessage("Failed to successfully send rental Evaluation enquiry");
        httpEnquiryClient.sendRentalEvaluationEnquiry(expectedHttpRentalEvaluationEnquiryRequest);
    }
}