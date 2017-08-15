package com.akross.web.enquiry.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class RentalEvaluationEnquiryRequest {

    private final String firstName;
    private final String lastName;
    private final String addressLine1;
    private final String addressLine2;
    private final String city;
    private final String country;
    private final String postcode;
    private final String telephone;
    private final String emailAddress;
    private final Boolean telephonePreference;
    private final Boolean emailPreference;
    private final String additionalComments;
    private final Boolean propertyOwned;
    private final Boolean keepUpdatedOnMortgage;

    @JsonCreator
    public RentalEvaluationEnquiryRequest(@JsonProperty(value = "firstName", required = true) final String firstName
            , @JsonProperty(value = "lastName", required = true) final String lastName
            , @JsonProperty(value = "addressLine1", required = true) final String addressLine1
            , @JsonProperty(value = "addressLine2") final String addressLine2
            , @JsonProperty(value = "city") final String city
            , @JsonProperty(value = "country") final String country
            , @JsonProperty(value = "postcode", required = true) final String postcode
            , @JsonProperty(value = "telephone", required = true) final String telephone
            , @JsonProperty(value = "emailAddress", required = true) final String emailAddress
            , @JsonProperty(value = "telephonePreference") final Boolean telephonePreference
            , @JsonProperty(value = "emailPreference") final Boolean emailPreference
            , @JsonProperty(value = "additionalComments") final String additionalComments
            , @JsonProperty(value = "propertyOwned") final Boolean propertyOwned
            , @JsonProperty(value = "keepUpdatedOnMortgage") final Boolean keepUpdatedOnMortgage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.telephone = telephone;
        this.emailAddress = emailAddress;
        this.telephonePreference = telephonePreference;
        this.emailPreference = emailPreference;
        this.additionalComments = additionalComments;
        this.propertyOwned = propertyOwned;
        this.keepUpdatedOnMortgage = keepUpdatedOnMortgage;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Boolean getTelephonePreference() {
        return telephonePreference;
    }

    public Boolean getEmailPreference() {
        return emailPreference;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public Boolean getPropertyOwned() {
        return propertyOwned;
    }

    public Boolean getKeepUpdatedOnMortgage() {
        return keepUpdatedOnMortgage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalEvaluationEnquiryRequest)) return false;
        RentalEvaluationEnquiryRequest that = (RentalEvaluationEnquiryRequest) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(addressLine1, that.addressLine1) &&
                Objects.equals(addressLine2, that.addressLine2) &&
                Objects.equals(city, that.city) &&
                Objects.equals(country, that.country) &&
                Objects.equals(postcode, that.postcode) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(telephonePreference, that.telephonePreference) &&
                Objects.equals(emailPreference, that.emailPreference) &&
                Objects.equals(additionalComments, that.additionalComments) &&
                Objects.equals(propertyOwned, that.propertyOwned) &&
                Objects.equals(keepUpdatedOnMortgage, that.keepUpdatedOnMortgage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, addressLine1, addressLine2, city, country, postcode, telephone
                , emailAddress, telephonePreference, emailPreference, additionalComments, propertyOwned
                , keepUpdatedOnMortgage);
    }

    @Override
    public String toString() {
        return "RentalEvaluationEnquiryRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postcode='" + postcode + '\'' +
                ", telephone='" + telephone + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", telephonePreference=" + telephonePreference +
                ", emailPreference=" + emailPreference +
                ", additionalComments='" + additionalComments + '\'' +
                ", propertyOwned=" + propertyOwned +
                ", keepUpdatedOnMortgage=" + keepUpdatedOnMortgage +
                '}';
    }
}