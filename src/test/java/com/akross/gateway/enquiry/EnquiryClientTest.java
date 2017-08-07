package com.akross.gateway.enquiry;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;
import com.akross.gateway.enquiry.configuration.JupixEnquiryRestClientProperties;
import com.akross.gateway.enquiry.exception.RentalEvaluationEnquiryException;
import com.akross.gateway.enquiry.utilities.EnquiryConverter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.akross.domain.enquiry.RentalEvaluationEnquiryRequest.RentalEvaluationEnquiryRequestBuilder.aRentalEvaluationEnquiryRequest;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EnquiryClientTest {

    @Rule
    public ExpectedException expectedException = none();

    @Mock
    private HttpEnquiryClient httpEnquiryClient;

    @Mock
    private EnquiryConverter enquiryConverter;

    @Mock
    private JupixEnquiryRestClientProperties jupixEnquiryRestClientProperties;

    @InjectMocks
    private EnquiryClient enquiryClient;

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

    private static String createHttpRentalEvaluationEnquiryRequest(
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

    @Test
    public void shouldSendRentalEvaluationEnquiry() {
        final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest = createRentalEvaluationEnquiryRequest();
        final String apiKey = "apiKey";
        final String agentCode = "agentCode";
        final int branchCode = 1;
        final double version = 2.0;
        final String emailAddress = "test@example.com";
        setupJupixEnquiryRestConfiguration(apiKey, agentCode, branchCode, version, emailAddress);

        final String httpRentalEvaluationEnquiryRequest
                = createHttpRentalEvaluationEnquiryRequest(rentalEvaluationEnquiryRequest, apiKey, agentCode
                , branchCode, version, emailAddress);

        setupEnquiryConverter(rentalEvaluationEnquiryRequest, apiKey, agentCode, branchCode
                , version, emailAddress, httpRentalEvaluationEnquiryRequest);

        doNothing().when(httpEnquiryClient).sendRentalEvaluationEnquiry(httpRentalEvaluationEnquiryRequest);

        enquiryClient.sendRentalEvaluationEnquiry(rentalEvaluationEnquiryRequest);

        assertWhatShouldHappen(rentalEvaluationEnquiryRequest, apiKey, agentCode, branchCode, version
                , emailAddress, httpRentalEvaluationEnquiryRequest);
    }

    @Test
    public void shouldThrowRentalEvaluationEnquiryException() {
        final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest = createRentalEvaluationEnquiryRequest();
        final String apiKey = "apiKey";
        final String agentCode = "agentCode";
        final int branchCode = 1;
        final double version = 2.0;
        final String emailAddress = "test@example.com";
        setupJupixEnquiryRestConfiguration(apiKey, agentCode, branchCode, version, emailAddress);
        final String httpRentalEvaluationEnquiryRequest
                = createHttpRentalEvaluationEnquiryRequest(rentalEvaluationEnquiryRequest, apiKey, agentCode
                , branchCode, version, emailAddress);

        setupEnquiryConverter(rentalEvaluationEnquiryRequest, apiKey, agentCode, branchCode
                , version, emailAddress, httpRentalEvaluationEnquiryRequest);

        doThrow(new RentalEvaluationEnquiryException("Failed to successfully send rental Evaluation enquiry"))
                .when(httpEnquiryClient).sendRentalEvaluationEnquiry(httpRentalEvaluationEnquiryRequest);
        try {
            enquiryClient.sendRentalEvaluationEnquiry(rentalEvaluationEnquiryRequest);
            fail("My method didn't throw when I expected it to");
        } catch (final RentalEvaluationEnquiryException rentalEvaluationEnquiryException) {
            assertThat(rentalEvaluationEnquiryException.getMessage()
                    , is("Failed to successfully send rental Evaluation enquiry"));
            assertWhatShouldHappen(rentalEvaluationEnquiryRequest, apiKey, agentCode, branchCode
                    , version, emailAddress, httpRentalEvaluationEnquiryRequest);
        }
    }

    private void assertWhatShouldHappen(final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest
            , final String apiKey, final String agentCode, final int branchCode, final double version
            , final String emailAddress, final String httpRentalEvaluationEnquiryRequest) {
        verify(enquiryConverter)
                .convertToHttpRentalEvaluationEnquiryRequest(rentalEvaluationEnquiryRequest
                        , apiKey, agentCode, branchCode, version, emailAddress);
        verify(httpEnquiryClient).sendRentalEvaluationEnquiry(httpRentalEvaluationEnquiryRequest);
        verifyNoMoreInteractions(enquiryConverter, httpEnquiryClient);
    }

    private void setupEnquiryConverter(final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest
            , final String apiKey, final String agentCode, final int branchCode, final double version
            , final String emailAddress, final String httpRentalEvaluationEnquiryRequest) {
        when(enquiryConverter.convertToHttpRentalEvaluationEnquiryRequest(rentalEvaluationEnquiryRequest
                , apiKey, agentCode, branchCode, version, emailAddress))
                .thenReturn(httpRentalEvaluationEnquiryRequest);
    }

    private void setupJupixEnquiryRestConfiguration(final String apiKey, final String agentCode
            , final int branchCode, final double version, final String emailAddress) {
        when(jupixEnquiryRestClientProperties.getApiKey()).thenReturn(apiKey);
        when(jupixEnquiryRestClientProperties.getAgentCode()).thenReturn(agentCode);
        when(jupixEnquiryRestClientProperties.getBranchCode()).thenReturn(branchCode);
        when(jupixEnquiryRestClientProperties.getVersion()).thenReturn(version);
        when(jupixEnquiryRestClientProperties.getEnquirerEmail()).thenReturn(emailAddress);
    }
}