package com.akross.web.property.enitity.residentialsalesandletting.residentialletting;


import com.akross.domain.property.Department;
import com.akross.domain.property.residentialsalesandletting.FloorAreaUnit;
import com.akross.domain.property.residentialsalesandletting.PropertyAge;
import com.akross.domain.property.residentialsalesandletting.PropertyStyle;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.Availability;
import com.akross.domain.property.residentialsalesandletting.residentialletting.RentFrequency;
import com.akross.web.property.enitity.*;
import com.akross.web.property.enitity.residentialsalesandletting.ResidentialSalesAndLettings;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class ResidentialLetting extends ResidentialSalesAndLettings {

    private final Availability availability;
    private final BigDecimal rent;
    private final RentFrequency rentFrequency;
    private final Boolean isLetPOA;
    private final Boolean isStudentProperty;
    private final String lettingFeePolicyHeadline;
    private final String lettingFeePolicyDetails;

    private ResidentialLetting(final Long propertyId
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
            , final List<Image> images
            , final List<Floorplan> floorplans
            , final List<Brochure> brochures
            , final List<VirtualTour> virtualTours
            , final List<EpcGraph> epcGraphs
            , final List<EpcFrontPage> epcFrontPages
            , final List<ExternalLink> externalLinks
            , final Integer propertyBedrooms
            , final Integer propertyEnsuites
            , final Integer propertyBathrooms
            , final Integer propertyReceptionRooms
            , final Integer propertyKitchens
            , final PropertyAge propertyAge
            , final Double floorArea
            , final FloorAreaUnit floorAreaUnit
            , final String displayPropertyType
            , final PropertyType propertyType
            , final PropertyStyle propertyStyle
            , final Availability availability
            , final BigDecimal rent
            , final RentFrequency rentFrequency
            , final Boolean isLetPOA
            , final Boolean isStudentProperty
            , final String lettingFeePolicyHeadline
            , final String lettingFeePolicyDetails) {
        super(propertyId, branchId, clientName, branchName, department, referenceNumber, addressName, addressNumber
                , addressStreet, address2, address3, address4, addressPostcode, country, displayAddress
                , propertyFeature1, propertyFeature2, propertyFeature3, propertyFeature4, propertyFeature5
                , propertyFeature6, propertyFeature7, propertyFeature8, propertyFeature9, propertyFeature10
                , dateLastModified, timeLastModified, isFeaturedProperty, regionId, latitude, longitude, flags
                , mainSummary, fullDescription, images, floorplans, brochures, virtualTours, epcGraphs, epcFrontPages
                , externalLinks, propertyBedrooms, propertyEnsuites, propertyBathrooms, propertyReceptionRooms
                , propertyKitchens, propertyAge, floorArea, floorAreaUnit, displayPropertyType, propertyType
                , propertyStyle);
        this.availability = availability;
        this.rent = rent;
        this.rentFrequency = rentFrequency;
        this.isLetPOA = isLetPOA;
        this.isStudentProperty = isStudentProperty;
        this.lettingFeePolicyHeadline = lettingFeePolicyHeadline;
        this.lettingFeePolicyDetails = lettingFeePolicyDetails;
    }

    public Availability getAvailability() {
        return availability;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public RentFrequency getRentFrequency() {
        return rentFrequency;
    }

    public Boolean isLetPOA() {
        return isLetPOA;
    }

    public Boolean isStudentProperty() {
        return isStudentProperty;
    }

    public String getLettingFeePolicyHeadline() {
        return lettingFeePolicyHeadline;
    }

    public String getLettingFeePolicyDetails() {
        return lettingFeePolicyDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResidentialLetting)) return false;
        if (!super.equals(o)) return false;
        ResidentialLetting that = (ResidentialLetting) o;
        return isLetPOA == that.isLetPOA &&
                isStudentProperty == that.isStudentProperty &&
                availability == that.availability &&
                Objects.equals(rent, that.rent) &&
                rentFrequency == that.rentFrequency &&
                Objects.equals(lettingFeePolicyHeadline, that.lettingFeePolicyHeadline) &&
                Objects.equals(lettingFeePolicyDetails, that.lettingFeePolicyDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), availability, rent, rentFrequency, isLetPOA, isStudentProperty
                , lettingFeePolicyHeadline, lettingFeePolicyDetails);
    }

    @Override
    public String toString() {
        return "ResidentialLetting{" +
                "availability=" + availability +
                ", rent=" + rent +
                ", rentFrequency=" + rentFrequency +
                ", isLetPOA=" + isLetPOA +
                ", isStudentProperty=" + isStudentProperty +
                ", lettingFeePolicyHeadline='" + lettingFeePolicyHeadline + '\'' +
                ", lettingFeePolicyDetails='" + lettingFeePolicyDetails + '\'' +
                "} " + super.toString();
    }

    public static final class ResidentialLettingBuilder {
        private Integer propertyBedrooms;
        private Integer propertyEnsuites;
        private Long propertyId;
        private Integer branchId;
        private Integer propertyBathrooms;
        private Availability availability;
        private String clientName;
        private Integer propertyReceptionRooms;
        private String branchName;
        private BigDecimal rent;
        private Integer propertyKitchens;
        private RentFrequency rentFrequency;
        private Department department;
        private PropertyAge propertyAge;
        private String referenceNumber;
        private boolean isLetPOA;
        private Double floorArea;
        private boolean isStudentProperty;
        private String addressName;
        private FloorAreaUnit floorAreaUnit;
        private String addressNumber;
        private String lettingFeePolicyHeadline;
        private String displayPropertyType;
        private String addressStreet;
        private String lettingFeePolicyDetails;
        private String address2;
        private PropertyType propertyType;
        private String address3;
        private PropertyStyle propertyStyle;
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
        private boolean isFeaturedProperty;
        private Integer regionId;
        private Double latitude;
        private Double longitude;
        private List<String> flags;
        private String mainSummary;
        private String fullDescription;
        private List<Image> images;
        private List<Floorplan> floorplans;
        private List<Brochure> brochures;
        private List<VirtualTour> virtualTours;
        private List<EpcGraph> epcGraphs;
        private List<EpcFrontPage> epcFrontPages;
        private List<ExternalLink> externalLinks;

        private ResidentialLettingBuilder() {
        }

        public static ResidentialLettingBuilder aResidentialLetting() {
            return new ResidentialLettingBuilder();
        }

        public ResidentialLettingBuilder withPropertyBedrooms(final Integer propertyBedrooms) {
            this.propertyBedrooms = propertyBedrooms;
            return this;
        }

        public ResidentialLettingBuilder withPropertyEnsuites(final Integer propertyEnsuites) {
            this.propertyEnsuites = propertyEnsuites;
            return this;
        }

        public ResidentialLettingBuilder withPropertyId(final Long propertyId) {
            this.propertyId = propertyId;
            return this;
        }

        public ResidentialLettingBuilder withBranchId(final Integer branchId) {
            this.branchId = branchId;
            return this;
        }

        public ResidentialLettingBuilder withPropertyBathrooms(final Integer propertyBathrooms) {
            this.propertyBathrooms = propertyBathrooms;
            return this;
        }

        public ResidentialLettingBuilder withAvailability(final Availability availability) {
            this.availability = availability;
            return this;
        }

        public ResidentialLettingBuilder withClientName(final String clientName) {
            this.clientName = clientName;
            return this;
        }

        public ResidentialLettingBuilder withPropertyReceptionRooms(final Integer propertyReceptionRooms) {
            this.propertyReceptionRooms = propertyReceptionRooms;
            return this;
        }

        public ResidentialLettingBuilder withBranchName(final String branchName) {
            this.branchName = branchName;
            return this;
        }

        public ResidentialLettingBuilder withRent(final BigDecimal rent) {
            this.rent = rent;
            return this;
        }

        public ResidentialLettingBuilder withPropertyKitchens(final Integer propertyKitchens) {
            this.propertyKitchens = propertyKitchens;
            return this;
        }

        public ResidentialLettingBuilder withRentFrequency(final RentFrequency rentFrequency) {
            this.rentFrequency = rentFrequency;
            return this;
        }

        public ResidentialLettingBuilder withDepartment(final Department department) {
            this.department = department;
            return this;
        }

        public ResidentialLettingBuilder withPropertyAge(final PropertyAge propertyAge) {
            this.propertyAge = propertyAge;
            return this;
        }

        public ResidentialLettingBuilder withReferenceNumber(final String referenceNumber) {
            this.referenceNumber = referenceNumber;
            return this;
        }

        public ResidentialLettingBuilder withIsLetPOA(final Boolean isLetPOA) {
            this.isLetPOA = isLetPOA;
            return this;
        }

        public ResidentialLettingBuilder withFloorArea(final Double floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public ResidentialLettingBuilder withIsStudentProperty(final Boolean isStudentProperty) {
            this.isStudentProperty = isStudentProperty;
            return this;
        }

        public ResidentialLettingBuilder withAddressName(final String addressName) {
            this.addressName = addressName;
            return this;
        }

        public ResidentialLettingBuilder withFloorAreaUnit(final FloorAreaUnit floorAreaUnit) {
            this.floorAreaUnit = floorAreaUnit;
            return this;
        }

        public ResidentialLettingBuilder withAddressNumber(final String addressNumber) {
            this.addressNumber = addressNumber;
            return this;
        }

        public ResidentialLettingBuilder withLettingFeePolicyHeadline(final String lettingFeePolicyHeadline) {
            this.lettingFeePolicyHeadline = lettingFeePolicyHeadline;
            return this;
        }

        public ResidentialLettingBuilder withDisplayPropertyType(final String displayPropertyType) {
            this.displayPropertyType = displayPropertyType;
            return this;
        }

        public ResidentialLettingBuilder withAddressStreet(final String addressStreet) {
            this.addressStreet = addressStreet;
            return this;
        }

        public ResidentialLettingBuilder withLettingFeePolicyDetails(final String lettingFeePolicyDetails) {
            this.lettingFeePolicyDetails = lettingFeePolicyDetails;
            return this;
        }

        public ResidentialLettingBuilder withAddress2(final String address2) {
            this.address2 = address2;
            return this;
        }

        public ResidentialLettingBuilder withPropertyType(final PropertyType propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public ResidentialLettingBuilder withAddress3(final String address3) {
            this.address3 = address3;
            return this;
        }

        public ResidentialLettingBuilder withPropertyStyle(final PropertyStyle propertyStyle) {
            this.propertyStyle = propertyStyle;
            return this;
        }

        public ResidentialLettingBuilder withAddress4(final String address4) {
            this.address4 = address4;
            return this;
        }

        public ResidentialLettingBuilder withAddressPostcode(final String addressPostcode) {
            this.addressPostcode = addressPostcode;
            return this;
        }

        public ResidentialLettingBuilder withCountry(final String country) {
            this.country = country;
            return this;
        }

        public ResidentialLettingBuilder withDisplayAddress(final String displayAddress) {
            this.displayAddress = displayAddress;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature1(final String propertyFeature1) {
            this.propertyFeature1 = propertyFeature1;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature2(final String propertyFeature2) {
            this.propertyFeature2 = propertyFeature2;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature3(final String propertyFeature3) {
            this.propertyFeature3 = propertyFeature3;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature4(final String propertyFeature4) {
            this.propertyFeature4 = propertyFeature4;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature5(final String propertyFeature5) {
            this.propertyFeature5 = propertyFeature5;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature6(final String propertyFeature6) {
            this.propertyFeature6 = propertyFeature6;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature7(final String propertyFeature7) {
            this.propertyFeature7 = propertyFeature7;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature8(final String propertyFeature8) {
            this.propertyFeature8 = propertyFeature8;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature9(final String propertyFeature9) {
            this.propertyFeature9 = propertyFeature9;
            return this;
        }

        public ResidentialLettingBuilder withPropertyFeature10(final String propertyFeature10) {
            this.propertyFeature10 = propertyFeature10;
            return this;
        }

        public ResidentialLettingBuilder withDateLastModified(final LocalDate dateLastModified) {
            this.dateLastModified = dateLastModified;
            return this;
        }

        public ResidentialLettingBuilder withTimeLastModified(final LocalTime timeLastModified) {
            this.timeLastModified = timeLastModified;
            return this;
        }

        public ResidentialLettingBuilder withIsFeaturedProperty(final Boolean isFeaturedProperty) {
            this.isFeaturedProperty = isFeaturedProperty;
            return this;
        }

        public ResidentialLettingBuilder withRegionId(final Integer regionId) {
            this.regionId = regionId;
            return this;
        }

        public ResidentialLettingBuilder withLatitude(final Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public ResidentialLettingBuilder withLongitude(final Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public ResidentialLettingBuilder withFlags(final List<String> flags) {
            this.flags = flags;
            return this;
        }

        public ResidentialLettingBuilder withMainSummary(final String mainSummary) {
            this.mainSummary = mainSummary;
            return this;
        }

        public ResidentialLettingBuilder withFullDescription(final String fullDescription) {
            this.fullDescription = fullDescription;
            return this;
        }

        public ResidentialLettingBuilder withImages(final List<Image> images) {
            this.images = images;
            return this;
        }

        public ResidentialLettingBuilder withFloorplans(final List<Floorplan> floorplans) {
            this.floorplans = floorplans;
            return this;
        }

        public ResidentialLettingBuilder withBrochures(final List<Brochure> brochures) {
            this.brochures = brochures;
            return this;
        }

        public ResidentialLettingBuilder withVirtualTours(final List<VirtualTour> virtualTours) {
            this.virtualTours = virtualTours;
            return this;
        }

        public ResidentialLettingBuilder withEpcGraphs(final List<EpcGraph> epcGraphs) {
            this.epcGraphs = epcGraphs;
            return this;
        }

        public ResidentialLettingBuilder withEpcFrontPages(final List<EpcFrontPage> epcFrontPages) {
            this.epcFrontPages = epcFrontPages;
            return this;
        }

        public ResidentialLettingBuilder withExternalLinks(final List<ExternalLink> externalLinks) {
            this.externalLinks = externalLinks;
            return this;
        }

        public ResidentialLetting build() {
            return new ResidentialLetting(propertyId, branchId, clientName, branchName, department, referenceNumber
                    , addressName, addressNumber, addressStreet, address2, address3, address4, addressPostcode
                    , country, displayAddress, propertyFeature1, propertyFeature2, propertyFeature3, propertyFeature4
                    , propertyFeature5, propertyFeature6, propertyFeature7, propertyFeature8, propertyFeature9
                    , propertyFeature10, dateLastModified, timeLastModified, isFeaturedProperty, regionId, latitude, longitude
                    , flags, mainSummary, fullDescription, images, floorplans, brochures, virtualTours, epcGraphs
                    , epcFrontPages, externalLinks, propertyBedrooms, propertyEnsuites, propertyBathrooms
                    , propertyReceptionRooms, propertyKitchens, propertyAge, floorArea, floorAreaUnit
                    , displayPropertyType, propertyType, propertyStyle, availability, rent, rentFrequency, isLetPOA
                    , isStudentProperty, lettingFeePolicyHeadline, lettingFeePolicyDetails);
        }
    }
}