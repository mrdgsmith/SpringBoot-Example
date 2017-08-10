package com.akross.repository.property.entity;

import com.akross.domain.property.Department;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.Collections.*;
import static java.util.Objects.nonNull;
import static javax.persistence.FetchType.EAGER;

@Entity
@Inheritance
public abstract class Property {

    @Id
    private Long propertyId;
    private Integer branchId;
    private String clientName;
    private String branchName;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String referenceNumber;
    private String addressName;
    private String addressNumber;
    private String addressStreet;
    private String address2;
    private String address3;
    private String address4;
    private String addressPostcode;
    private String country;
    private String displayAddress;
    private String propertyFeature1;
    private String propertyFeature2;
    private String propertyFeature3;
    private String propertyFeature4;
    private String propertyFeature5;
    private String propertyFeature6;
    private String propertyFeature7;
    private String propertyFeature8;
    private String propertyFeature9;
    private String propertyFeature10;
    private LocalDate dateLastModified;
    private LocalTime timeLastModified;
    private Boolean isFeaturedProperty;
    private Integer regionId;
    private Double latitude;
    private Double longitude;
    @ElementCollection
    private List<String> flags;
    private String mainSummary;
    private String fullDescription;
    @OneToMany(fetch = EAGER, cascade = {CascadeType.ALL})
    private Set<Image> images;
    @OneToMany(fetch = EAGER, cascade = {CascadeType.ALL})
    private Set<Floorplan> floorplans;
    @OneToMany(fetch = EAGER, cascade = {CascadeType.ALL})
    private Set<Brochure> brochures;
    @OneToMany(fetch = EAGER, cascade = {CascadeType.ALL})
    private Set<VirtualTour> virtualTours;
    @OneToMany(fetch = EAGER, cascade = {CascadeType.ALL})
    private Set<EpcGraph> epcGraphs;
    @OneToMany(fetch = EAGER, cascade = {CascadeType.ALL})
    private Set<EpcFrontPage> epcFrontPages;
    @OneToMany(fetch = EAGER, cascade = {CascadeType.ALL})
    private Set<ExternalLink> externalLinks;

    protected Property() {
    }

    public Property(Long propertyId
            , final Integer branchId
            , final String clientName
            , final String branchName
            , final Department department
            , final String referenceNumber
            , final String addressName
            , final String addressNumber
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
            , final Set<Image> images
            , final Set<Floorplan> floorplans
            , final Set<Brochure> brochures
            , final Set<VirtualTour> virtualTours
            , final Set<EpcGraph> epcGraphs
            , final Set<EpcFrontPage> epcFrontPages
            , final Set<ExternalLink> externalLinks) {
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
        this.dateLastModified = nonNull(dateLastModified) ? LocalDate.of(dateLastModified.getYear(), dateLastModified.getMonth()
                , dateLastModified.getDayOfMonth()) : null;
        this.timeLastModified = nonNull(timeLastModified) ? LocalTime.of(timeLastModified.getHour(), timeLastModified.getMinute()
                , timeLastModified.getSecond()) : null;
        this.isFeaturedProperty = isFeaturedProperty;
        this.regionId = regionId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.flags = nonNull(flags) ? unmodifiableList(flags) : emptyList();
        this.mainSummary = mainSummary;
        this.fullDescription = fullDescription;
        this.images = nonNull(images) ? unmodifiableSet(images) : emptySet();
        this.floorplans = nonNull(floorplans) ? unmodifiableSet(floorplans) : emptySet();
        this.brochures = nonNull(brochures) ? unmodifiableSet(brochures) : emptySet();
        this.virtualTours = nonNull(virtualTours) ? unmodifiableSet(virtualTours) : emptySet();
        this.epcGraphs = nonNull(epcGraphs) ? unmodifiableSet(epcGraphs) : emptySet();
        this.epcFrontPages = nonNull(epcFrontPages) ? unmodifiableSet(epcFrontPages) : emptySet();
        this.externalLinks = nonNull(externalLinks) ? unmodifiableSet(externalLinks) : emptySet();
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

    public String getAddressNumber() {
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

    public Boolean isFeaturedProperty() {
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

    public Set<Image> getImages() {
        return unmodifiableSet(images);
    }

    public Set<Floorplan> getFloorplans() {
        return unmodifiableSet(floorplans);
    }

    public Set<Brochure> getBrochures() {
        return unmodifiableSet(brochures);
    }

    public Set<VirtualTour> getVirtualTours() {
        return unmodifiableSet(virtualTours);
    }

    public Set<EpcGraph> getEpcGraphs() {
        return unmodifiableSet(epcGraphs);
    }

    public Set<EpcFrontPage> getEpcFrontPages() {
        return unmodifiableSet(epcFrontPages);
    }

    public Set<ExternalLink> getExternalLinks() {
        return unmodifiableSet(externalLinks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;
        Property property = (Property) o;
        return Objects.equals(propertyId, property.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId);
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