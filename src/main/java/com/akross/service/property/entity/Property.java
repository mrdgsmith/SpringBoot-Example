package com.akross.service.property.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Property {

    private final Long propertyId;
    private final Integer branchId;
    private final String clientName;
    private final String branchName;
    private final String department;
    private final String referenceNumber;
    private final String addressName;
    private final Integer addressNumber;
    private final String addressStreet;
    private final String address2;
    private final String address3;
    private final String address4;
    private final String addressPostcode;
    private final String country;
    private final String displayAddress;
    private final String propertyFeature1;
    private final String propertyFeature2;
    private final String propertyFeature3;
    private final String propertyFeature4;
    private final String propertyFeature5;
    private final String propertyFeature6;
    private final String propertyFeature7;
    private final String propertyFeature8;
    private final String propertyFeature9;
    private final String propertyFeature10;
    private final LocalDate dateLastModified;
    private final LocalTime timeLastModified;
    private final Integer featuredProperty;
    private final Integer regionId;
    private final Double latitude;
    private final Double longitude;
    private final Flags flags;
    private final String mainSummary;
    private final String fullDescription;

    public Property(
            final @JacksonXmlProperty(localName = "propertyID") Long propertyId
            , final @JacksonXmlProperty(localName = "branchID") Integer branchId
            , final @JacksonXmlProperty(localName = "clientName") String clientName
            , final @JacksonXmlProperty(localName = "branchName") String branchName
            , final @JacksonXmlProperty(localName = "department") String department
            , final @JacksonXmlProperty(localName = "referenceNumber") String referenceNumber
            , final @JacksonXmlProperty(localName = "addressName") String addressName
            , final @JacksonXmlProperty(localName = "addressNumber") Integer addressNumber
            , final @JacksonXmlProperty(localName = "addressStreet") String addressStreet
            , final @JacksonXmlProperty(localName = "address2") String address2
            , final @JacksonXmlProperty(localName = "address3") String address3
            , final @JacksonXmlProperty(localName = "address4") String address4
            , final @JacksonXmlProperty(localName = "addressPostCode") String addressPostcode
            , final @JacksonXmlProperty(localName = "country") String country
            , final @JacksonXmlProperty(localName = "displayAddress") String displayAddress
            , final @JacksonXmlProperty(localName = "propertyFeature1") String propertyFeature1
            , final @JacksonXmlProperty(localName = "propertyFeature2") String propertyFeature2
            , final @JacksonXmlProperty(localName = "propertyFeature3") String propertyFeature3
            , final @JacksonXmlProperty(localName = "propertyFeature4") String propertyFeature4
            , final @JacksonXmlProperty(localName = "propertyFeature5") String propertyFeature5
            , final @JacksonXmlProperty(localName = "propertyFeature6") String propertyFeature6
            , final @JacksonXmlProperty(localName = "propertyFeature7") String propertyFeature7
            , final @JacksonXmlProperty(localName = "propertyFeature8") String propertyFeature8
            , final @JacksonXmlProperty(localName = "propertyFeature9") String propertyFeature9
            , final @JacksonXmlProperty(localName = "propertyFeature10") String propertyFeature10
            , final @JacksonXmlProperty(localName = "dateLastModified")
            @JsonDeserialize(using = LocalDateDeserializer.class) LocalDate dateLastModified
            , final @JacksonXmlProperty(localName = "timeLastModified")
            @JsonDeserialize(using = LocalTimeDeserializer.class) LocalTime timeLastModified
            , final @JacksonXmlProperty(localName = "featuredProperty") Integer featuredProperty
            , final @JacksonXmlProperty(localName = "regionID") Integer regionId
            , final @JacksonXmlProperty(localName = "latitude") Double latitude
            , final @JacksonXmlProperty(localName = "longitude") Double longitude
            , final @JacksonXmlProperty(localName = "flags") Flags flags
            , final @JacksonXmlProperty(localName = "mainSummary") String mainSummary
            , final @JacksonXmlProperty(localName = "fullDescription") String fullDescription) {
        this.propertyId = propertyId;
        this.branchId = branchId;
        this.clientName = clientName;
        this.branchName = branchName;
        this.department = department;
        this.referenceNumber = referenceNumber;
        this.addressName = addressName;
        this.addressNumber = addressNumber;
        this.addressStreet = addressStreet;
        this.address2 = address2;
        this.address3 = address3;
        this.address4 = address4;
        this.addressPostcode = addressPostcode;
        this.country = country;
        this.displayAddress = displayAddress;
        this.propertyFeature1 = propertyFeature1;
        this.propertyFeature2 = propertyFeature2;
        this.propertyFeature3 = propertyFeature3;
        this.propertyFeature4 = propertyFeature4;
        this.propertyFeature5 = propertyFeature5;
        this.propertyFeature6 = propertyFeature6;
        this.propertyFeature7 = propertyFeature7;
        this.propertyFeature8 = propertyFeature8;
        this.propertyFeature9 = propertyFeature9;
        this.propertyFeature10 = propertyFeature10;
        this.dateLastModified = dateLastModified;
        this.timeLastModified = timeLastModified;
        this.featuredProperty = featuredProperty;
        this.regionId = regionId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.flags = flags;
        this.mainSummary = mainSummary;
        this.fullDescription = fullDescription;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getDepartment() {
        return department;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getAddressName() {
        return addressName;
    }

    public Integer getAddressNumber() {
        return addressNumber;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getAddress4() {
        return address4;
    }

    public String getAddressPostcode() {
        return addressPostcode;
    }

    public String getCountry() {
        return country;
    }

    public String getDisplayAddress() {
        return displayAddress;
    }

    public String getPropertyFeature1() {
        return propertyFeature1;
    }

    public String getPropertyFeature2() {
        return propertyFeature2;
    }

    public String getPropertyFeature3() {
        return propertyFeature3;
    }

    public String getPropertyFeature4() {
        return propertyFeature4;
    }

    public String getPropertyFeature5() {
        return propertyFeature5;
    }

    public String getPropertyFeature6() {
        return propertyFeature6;
    }

    public String getPropertyFeature7() {
        return propertyFeature7;
    }

    public String getPropertyFeature8() {
        return propertyFeature8;
    }

    public String getPropertyFeature9() {
        return propertyFeature9;
    }

    public String getPropertyFeature10() {
        return propertyFeature10;
    }

    public LocalDate getDateLastModified() {
        return dateLastModified;
    }

    public LocalTime getTimeLastModified() {
        return timeLastModified;
    }

    public Integer getFeaturedProperty() {
        return featuredProperty;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Flags getFlags() {
        return flags;
    }

    public String getMainSummary() {
        return mainSummary;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(propertyId, property.propertyId) &&
                Objects.equals(branchId, property.branchId) &&
                Objects.equals(clientName, property.clientName) &&
                Objects.equals(branchName, property.branchName) &&
                Objects.equals(department, property.department) &&
                Objects.equals(referenceNumber, property.referenceNumber) &&
                Objects.equals(addressName, property.addressName) &&
                Objects.equals(addressNumber, property.addressNumber) &&
                Objects.equals(addressStreet, property.addressStreet) &&
                Objects.equals(address2, property.address2) &&
                Objects.equals(address3, property.address3) &&
                Objects.equals(address4, property.address4) &&
                Objects.equals(addressPostcode, property.addressPostcode) &&
                Objects.equals(country, property.country) &&
                Objects.equals(displayAddress, property.displayAddress) &&
                Objects.equals(propertyFeature1, property.propertyFeature1) &&
                Objects.equals(propertyFeature2, property.propertyFeature2) &&
                Objects.equals(propertyFeature3, property.propertyFeature3) &&
                Objects.equals(propertyFeature4, property.propertyFeature4) &&
                Objects.equals(propertyFeature5, property.propertyFeature5) &&
                Objects.equals(propertyFeature6, property.propertyFeature6) &&
                Objects.equals(propertyFeature7, property.propertyFeature7) &&
                Objects.equals(propertyFeature8, property.propertyFeature8) &&
                Objects.equals(propertyFeature9, property.propertyFeature9) &&
                Objects.equals(propertyFeature10, property.propertyFeature10) &&
                Objects.equals(dateLastModified, property.dateLastModified) &&
                Objects.equals(timeLastModified, property.timeLastModified) &&
                Objects.equals(featuredProperty, property.featuredProperty) &&
                Objects.equals(regionId, property.regionId) &&
                Objects.equals(latitude, property.latitude) &&
                Objects.equals(longitude, property.longitude) &&
                Objects.equals(flags, property.flags) &&
                Objects.equals(mainSummary, property.mainSummary) &&
                Objects.equals(fullDescription, property.fullDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, branchId, clientName, branchName, department, referenceNumber, addressName
                , addressNumber, addressStreet, address2, address3, address4, addressPostcode, country, displayAddress
                , propertyFeature1, propertyFeature2, propertyFeature3, propertyFeature4, propertyFeature5
                , propertyFeature6, propertyFeature7, propertyFeature8, propertyFeature9, propertyFeature10
                , dateLastModified, timeLastModified, featuredProperty, regionId, latitude, longitude, flags
                , mainSummary, fullDescription);
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", branchId=" + branchId +
                ", clientName='" + clientName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", department='" + department + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", addressName='" + addressName + '\'' +
                ", addressNumber=" + addressNumber +
                ", addressStreet='" + addressStreet + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", address4='" + address4 + '\'' +
                ", addressPostcode='" + addressPostcode + '\'' +
                ", country='" + country + '\'' +
                ", displayAddress='" + displayAddress + '\'' +
                ", propertyFeature1='" + propertyFeature1 + '\'' +
                ", propertyFeature2='" + propertyFeature2 + '\'' +
                ", propertyFeature3='" + propertyFeature3 + '\'' +
                ", propertyFeature4='" + propertyFeature4 + '\'' +
                ", propertyFeature5='" + propertyFeature5 + '\'' +
                ", propertyFeature6='" + propertyFeature6 + '\'' +
                ", propertyFeature7='" + propertyFeature7 + '\'' +
                ", propertyFeature8='" + propertyFeature8 + '\'' +
                ", propertyFeature9='" + propertyFeature9 + '\'' +
                ", propertyFeature10='" + propertyFeature10 + '\'' +
                ", dateLastModified=" + dateLastModified +
                ", timeLastModified=" + timeLastModified +
                ", featuredProperty=" + featuredProperty +
                ", regionId=" + regionId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", flags=" + flags +
                ", mainSummary='" + mainSummary + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                '}';
    }
}