package com.akross.web.property.enitity;

import com.akross.domain.property.Department;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.nonNull;

public abstract class Property {
    private final Long propertyId;
    private final Integer branchId;
    private final String clientName;
    private final String branchName;
    private final Department department;
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
    private final Boolean isFeaturedProperty;
    private final Integer regionId;
    private final Double latitude;
    private final Double longitude;
    private final List<String> flags;
    private final String mainSummary;
    private final String fullDescription;
    private final List<Image> images;
    private final List<Floorplan> floorplans;
    private final List<Brochure> brochures;
    private final List<VirtualTour> virtualTours;
    private final List<EpcGraph> epcGraphs;
    private final List<EpcFrontPage> epcFrontPages;
    private final List<ExternalLink> externalLinks;

    public Property(final Long propertyId
            , final Integer branchId
            , final String clientName
            , final String branchName
            , final Department department
            , final String referenceNumber
            , final String addressName
            , final Integer addressNumber
            , final String addressStreet
            , final String address2
            , final String address3
            , final String address4
            , final String addressPostcode
            , final String country
            , final String displayAddress
            , final String propertyFeature1
            , final String propertyFeature2
            , final String propertyFeature3
            , final String propertyFeature4
            , final String propertyFeature5
            , final String propertyFeature6
            , final String propertyFeature7
            , final String propertyFeature8
            , final String propertyFeature9
            , final String propertyFeature10
            , final LocalDate dateLastModified
            , final LocalTime timeLastModified
            , final Boolean isFeaturedProperty
            , final Integer regionId
            , final Double latitude
            , final Double longitude
            , final List<String> flags
            , final String mainSummary
            , final String fullDescription
            , final List<Image> images
            , final List<Floorplan> floorplans
            , final List<Brochure> brochures
            , final List<VirtualTour> virtualTours
            , final List<EpcGraph> epcGraphs
            , final List<EpcFrontPage> epcFrontPages
            , final List<ExternalLink> externalLinks) {
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
        this.dateLastModified = LocalDate.of(dateLastModified.getYear(), dateLastModified.getMonth()
                , dateLastModified.getDayOfMonth());
        this.timeLastModified = LocalTime.of(timeLastModified.getHour(), timeLastModified.getMinute()
                , timeLastModified.getSecond());
        this.isFeaturedProperty = isFeaturedProperty;
        this.regionId = regionId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.flags = nonNull(flags) ? unmodifiableList(flags) : emptyList();
        this.mainSummary = mainSummary;
        this.fullDescription = fullDescription;
        this.images = nonNull(images) ? unmodifiableList(images) : emptyList();
        this.floorplans = nonNull(floorplans) ? unmodifiableList(floorplans) : emptyList();
        this.brochures = nonNull(brochures) ? unmodifiableList(brochures) : emptyList();
        this.virtualTours = nonNull(virtualTours) ? unmodifiableList(virtualTours) : emptyList();
        this.epcGraphs = nonNull(epcGraphs) ? unmodifiableList(epcGraphs) : emptyList();
        this.epcFrontPages = nonNull(epcFrontPages) ? unmodifiableList(epcFrontPages) : emptyList();
        this.externalLinks = nonNull(externalLinks) ? unmodifiableList(externalLinks) : emptyList();
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

    public Department getDepartment() {
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
        return LocalDate.of(dateLastModified.getYear(), dateLastModified.getMonth(), dateLastModified.getDayOfMonth());
    }

    public LocalTime getTimeLastModified() {
        return LocalTime.of(timeLastModified.getHour(), timeLastModified.getMinute(), timeLastModified.getSecond());
    }

    public boolean isFeaturedProperty() {
        return isFeaturedProperty;
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

    public List<String> getFlags() {
        return unmodifiableList(flags);
    }

    public String getMainSummary() {
        return mainSummary;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public List<Image> getImages() {
        return unmodifiableList(images);
    }

    public List<Floorplan> getFloorplans() {
        return unmodifiableList(floorplans);
    }

    public List<Brochure> getBrochures() {
        return unmodifiableList(brochures);
    }

    public List<VirtualTour> getVirtualTours() {
        return unmodifiableList(virtualTours);
    }

    public List<EpcGraph> getEpcGraphs() {
        return unmodifiableList(epcGraphs);
    }

    public List<EpcFrontPage> getEpcFrontPages() {
        return unmodifiableList(epcFrontPages);
    }

    public List<ExternalLink> getExternalLinks() {
        return unmodifiableList(externalLinks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return isFeaturedProperty == property.isFeaturedProperty &&
                Objects.equals(propertyId, property.propertyId) &&
                Objects.equals(branchId, property.branchId) &&
                Objects.equals(clientName, property.clientName) &&
                Objects.equals(branchName, property.branchName) &&
                department == property.department &&
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
                Objects.equals(regionId, property.regionId) &&
                Objects.equals(latitude, property.latitude) &&
                Objects.equals(longitude, property.longitude) &&
                Objects.equals(flags, property.flags) &&
                Objects.equals(mainSummary, property.mainSummary) &&
                Objects.equals(fullDescription, property.fullDescription) &&
                Objects.equals(images, property.images) &&
                Objects.equals(floorplans, property.floorplans) &&
                Objects.equals(brochures, property.brochures) &&
                Objects.equals(virtualTours, property.virtualTours) &&
                Objects.equals(epcGraphs, property.epcGraphs) &&
                Objects.equals(epcFrontPages, property.epcFrontPages) &&
                Objects.equals(externalLinks, property.externalLinks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, branchId, clientName, branchName, department, referenceNumber, addressName
                , addressNumber, addressStreet, address2, address3, address4, addressPostcode, country, displayAddress
                , propertyFeature1, propertyFeature2, propertyFeature3, propertyFeature4, propertyFeature5
                , propertyFeature6, propertyFeature7, propertyFeature8, propertyFeature9, propertyFeature10
                , dateLastModified, timeLastModified, isFeaturedProperty, regionId, latitude, longitude, flags
                , mainSummary, fullDescription, images, floorplans, brochures, virtualTours, epcGraphs, epcFrontPages
                , externalLinks);
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", branchId=" + branchId +
                ", clientName='" + clientName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", department=" + department +
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
                ", isFeaturedProperty=" + isFeaturedProperty +
                ", regionId=" + regionId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", flags=" + flags +
                ", mainSummary='" + mainSummary + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", images=" + images +
                ", floorplans=" + floorplans +
                ", brochures=" + brochures +
                ", virtualTours=" + virtualTours +
                ", epcGraphs=" + epcGraphs +
                ", epcFrontPages=" + epcFrontPages +
                ", externalLinks=" + externalLinks +
                '}';
    }
}