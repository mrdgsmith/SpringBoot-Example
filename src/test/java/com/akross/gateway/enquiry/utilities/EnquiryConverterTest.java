package com.akross.gateway.enquiry.utilities;

import com.akross.domain.enquiry.RentalEvaluationEnquiryRequest;
import org.junit.Before;
import org.junit.Test;

import static com.akross.domain.enquiry.RentalEvaluationEnquiryRequest.RentalEvaluationEnquiryRequestBuilder.aRentalEvaluationEnquiryRequest;
import static java.util.Objects.nonNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class EnquiryConverterTest {

    private EnquiryConverter enquiryConverter;

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
                "&requestMailingList=" + ((nonNull(rentalEvaluationEnquiryRequest.getKeepUpdatedOnMortgage()) &&
                rentalEvaluationEnquiryRequest.getKeepUpdatedOnMortgage() ? 1 : 0)) +
                "&propToRent=1" +
                "&comment=" + rentalEvaluationEnquiryRequest.getAdditionalComments();
    }

    @Before
    public void setUp() throws Exception {
        enquiryConverter = new EnquiryConverter();
    }

    @Test
    public void shouldConvertMandatoryRentalEvaluationEnquiryRequest() throws Exception {
        final RentalEvaluationEnquiryRequest rentalEvaluationEnquiryRequest = aRentalEvaluationEnquiryRequest()
                .withFirstName("Steve")
                .withLastName("Smith")
                .withAddressLine1("foo")
                .withAddressLine2("Bar")
                .withPostcode("nw10 4hk")
                .withTelephone("54748456356")
                .withEmailAddress("happy@msn.com")
                .build();

        final String apiKey = "apiKey";
        final String agentCode = "agentCode";
        final int branchCode = 1;
        final double version = 2.0;
        final String email = "email";

        final String actualHttpRentalEvaluationEnquiryRequest = enquiryConverter
                .convertToHttpRentalEvaluationEnquiryRequest(rentalEvaluationEnquiryRequest, apiKey, agentCode
                        , branchCode, version, email);

        assertThat(actualHttpRentalEvaluationEnquiryRequest
                , is("apiKey=apiKey" +
                        "&agentCode=agentCode" +
                        "&branchCode=1" +
                        "&version=2.0" +
                        "&firstName=Steve" +
                        "&lastName=Smith" +
                        "&From=email" +
                        "&to=happy@msn.com" +
                        "&address=foo Bar" +
                        "&postcode=nw10 4hk" +
                        "&phoneDay=54748456356" +
                        "&requestMailingList=0" +
                        "&propToRent=1" +
                        "&comment"));
    }

    @Test
    public void shouldConvertRentalEvaluationEnquiryRequest() throws Exception {
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

        final String apiKey = "apiKey";
        final String agentCode = "agentCode";
        final int branchCode = 1;
        final double version = 2.0;
        final String email = "email";

        final String actualHttpRentalEvaluationEnquiryRequest = enquiryConverter
                .convertToHttpRentalEvaluationEnquiryRequest(rentalEvaluationEnquiryRequest, apiKey, agentCode
                        , branchCode, version, email);

        assertThat(actualHttpRentalEvaluationEnquiryRequest
                , is(createExpectedHttpRentalEvaluationEnquiryRequest(rentalEvaluationEnquiryRequest, apiKey
                        , agentCode, branchCode, version, email)));
    }
}