package com.akross.web.enquiry.entity.builders;

import com.akross.web.enquiry.entity.RentalEvaluationEnquiryRequest;

public class TestRentalEvaluationEnquiryRequestBuilder {
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String postcode;
    private String telephone;
    private String emailAddress;
    private Boolean telephonePreference;
    private Boolean emailPreference;
    private String additionalComments;
    private Boolean propertyOwned;
    private Boolean keepUpdatedOnMortgage;

    private TestRentalEvaluationEnquiryRequestBuilder() {
    }

    public static TestRentalEvaluationEnquiryRequestBuilder aRentalEvaluationEnquiryRequest() {
        return new TestRentalEvaluationEnquiryRequestBuilder();
    }

    public TestRentalEvaluationEnquiryRequestBuilder withFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withCity(final String city) {
        this.city = city;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withCountry(final String country) {
        this.country = country;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withPostcode(final String postcode) {
        this.postcode = postcode;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withTelephone(final String telephone) {
        this.telephone = telephone;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withTelephonePreference(final Boolean telephonePreference) {
        this.telephonePreference = telephonePreference;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withEmailPreference(final Boolean emailPreference) {
        this.emailPreference = emailPreference;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withAdditionalComments(final String additionalComments) {
        this.additionalComments = additionalComments;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withPropertyOwned(final Boolean propertyOwned) {
        this.propertyOwned = propertyOwned;
        return this;
    }

    public TestRentalEvaluationEnquiryRequestBuilder withKeepUpdatedOnMortgage(final Boolean keepUpdatedOnMortgage) {
        this.keepUpdatedOnMortgage = keepUpdatedOnMortgage;
        return this;
    }

    public RentalEvaluationEnquiryRequest build() {
        return new RentalEvaluationEnquiryRequest(firstName, lastName, addressLine1, addressLine2, city, country
                , postcode, telephone, emailAddress, telephonePreference, emailPreference, additionalComments
                , propertyOwned, keepUpdatedOnMortgage);
    }
}