package com.akross.gateway.enquiry.entity;

import java.util.Objects;

public class RentalEvaluationEnquiresRequest {

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

    private RentalEvaluationEnquiresRequest(final String firstName
            , final String lastName
            , final String addressLine1
            , final String addressLine2
            , final String city
            , final String country
            , final String postcode
            , final String telephone
            , final String emailAddress
            , final Boolean telephonePreference
            , final Boolean emailPreference
            , final String additionalComments
            , final Boolean propertyOwned
            , final Boolean keepUpdatedOnMortgage) {
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
        if (!(o instanceof RentalEvaluationEnquiresRequest)) return false;
        RentalEvaluationEnquiresRequest that = (RentalEvaluationEnquiresRequest) o;
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

    public static final class HttpRentalEvaluationEnquiresRequestBuilder {
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

        private HttpRentalEvaluationEnquiresRequestBuilder() {
        }

        public static HttpRentalEvaluationEnquiresRequestBuilder aRentalEvaluationEnquiresRequest() {
            return new HttpRentalEvaluationEnquiresRequestBuilder();
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withAddressLine1(final String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withAddressLine2(final String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withCity(final String city) {
            this.city = city;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withCountry(final String country) {
            this.country = country;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withPostcode(final String postcode) {
            this.postcode = postcode;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withTelephone(final String telephone) {
            this.telephone = telephone;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withEmailAddress(final String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withTelephonePreference(final Boolean telephonePreference) {
            this.telephonePreference = telephonePreference;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withEmailPreference(final Boolean emailPreference) {
            this.emailPreference = emailPreference;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withAdditionalComments(final String additionalComments) {
            this.additionalComments = additionalComments;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withPropertyOwned(final Boolean propertyOwned) {
            this.propertyOwned = propertyOwned;
            return this;
        }

        public HttpRentalEvaluationEnquiresRequestBuilder withKeepUpdatedOnMortgage(final Boolean keepUpdatedOnMortgage) {
            this.keepUpdatedOnMortgage = keepUpdatedOnMortgage;
            return this;
        }

        public RentalEvaluationEnquiresRequest build() {
            return new RentalEvaluationEnquiresRequest(firstName, lastName, addressLine1, addressLine2, city, country
                    , postcode, telephone, emailAddress, telephonePreference, emailPreference, additionalComments
                    , propertyOwned, keepUpdatedOnMortgage);
        }
    }
}