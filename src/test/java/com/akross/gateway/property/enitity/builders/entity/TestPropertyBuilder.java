package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public final class TestPropertyBuilder {
    private Long propertyId;
    private Integer branchId;
    private String clientName;
    private String branchName;
    private String department;
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
    private Integer featuredProperty;
    private Integer regionId;
    private Double latitude;
    private Double longitude;
    private List<String> flags;
    private String mainSummary;
    private String fullDescription;
    private Integer propertyBedrooms;
    private Integer propertyBathrooms;
    private Integer propertyEnsuites;
    private Integer propertyReceptionRooms;
    private Integer propertyKitchens;
    private Integer propertyAge;
    private Double floorArea;
    private String floorAreaUnits;
    private String displayPropertyType;
    private Integer propertyType;
    private Integer propertyStyle;
    private Integer availability;
    private BigDecimal price;
    private Integer priceQualifier;
    private Integer forSalePOA;
    private Integer propertyTenure;
    private Integer saleBy;
    private Integer developmentOpportunity;
    private Integer investmentOpportunity;
    private BigDecimal estimatedRentalIncome;
    private BigDecimal rent;
    private Integer rentFrequency;
    private Integer toLetPOA;
    private Integer studentProperty;
    private String lettingFeePolicyHeadline;
    private String lettingFeePolicyDetails;
    private Integer forSale;
    private Integer toLet;
    private BigDecimal priceTo;
    private BigDecimal priceFrom;
    private BigDecimal rentTo;
    private BigDecimal rentFrom;
    private Double floorAreaTo;
    private Double floorAreaFrom;
    private Double siteArea;
    private String siteAreaUnits;
    private String strapLine;
    private List<Integer> propertyTypes;
    private Double landAreaTo;
    private Double landAreaFrom;
    private String landAreaUnits;
    private Integer forSaleLeaseLength;
    private List<Image> images;
    private List<Floorplan> floorplans;
    private List<EpcGraph> epcGraphs;
    private List<EpcFrontPage> epcFrontPages;
    private List<Brochure> brochures;
    private List<VirtualTour> virtualTours;
    private List<ExternalLink> externalLinks;

    private TestPropertyBuilder() {
    }

    public static TestPropertyBuilder aProperty() {
        return new TestPropertyBuilder();
    }

    public TestPropertyBuilder withPropertyId(final Long propertyId) {
        this.propertyId = propertyId;
        return this;
    }

    public TestPropertyBuilder withBranchId(final Integer branchId) {
        this.branchId = branchId;
        return this;
    }

    public TestPropertyBuilder withClientName(final String clientName) {
        this.clientName = clientName;
        return this;
    }

    public TestPropertyBuilder withBranchName(final String branchName) {
        this.branchName = branchName;
        return this;
    }

    public TestPropertyBuilder withDepartment(final String department) {
        this.department = department;
        return this;
    }

    public TestPropertyBuilder withReferenceNumber(final String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public TestPropertyBuilder withAddressName(final String addressName) {
        this.addressName = addressName;
        return this;
    }

    public TestPropertyBuilder withAddressNumber(final String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public TestPropertyBuilder withAddressStreet(final String addressStreet) {
        this.addressStreet = addressStreet;
        return this;
    }

    public TestPropertyBuilder withAddress2(final String address2) {
        this.address2 = address2;
        return this;
    }

    public TestPropertyBuilder withAddress3(final String address3) {
        this.address3 = address3;
        return this;
    }

    public TestPropertyBuilder withAddress4(final String address4) {
        this.address4 = address4;
        return this;
    }

    public TestPropertyBuilder withAddressPostcode(final String addressPostcode) {
        this.addressPostcode = addressPostcode;
        return this;
    }

    public TestPropertyBuilder withCountry(final String country) {
        this.country = country;
        return this;
    }

    public TestPropertyBuilder withDisplayAddress(final String displayAddress) {
        this.displayAddress = displayAddress;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature1(final String propertyFeature1) {
        this.propertyFeature1 = propertyFeature1;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature2(final String propertyFeature2) {
        this.propertyFeature2 = propertyFeature2;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature3(final String propertyFeature3) {
        this.propertyFeature3 = propertyFeature3;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature4(final String propertyFeature4) {
        this.propertyFeature4 = propertyFeature4;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature5(final String propertyFeature5) {
        this.propertyFeature5 = propertyFeature5;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature6(final String propertyFeature6) {
        this.propertyFeature6 = propertyFeature6;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature7(final String propertyFeature7) {
        this.propertyFeature7 = propertyFeature7;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature8(final String propertyFeature8) {
        this.propertyFeature8 = propertyFeature8;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature9(final String propertyFeature9) {
        this.propertyFeature9 = propertyFeature9;
        return this;
    }

    public TestPropertyBuilder withPropertyFeature10(final String propertyFeature10) {
        this.propertyFeature10 = propertyFeature10;
        return this;
    }

    public TestPropertyBuilder withDateLastModified(final LocalDate dateLastModified) {
        this.dateLastModified = dateLastModified;
        return this;
    }

    public TestPropertyBuilder withTimeLastModified(final LocalTime timeLastModified) {
        this.timeLastModified = timeLastModified;
        return this;
    }

    public TestPropertyBuilder withFeaturedProperty(final Integer featuredProperty) {
        this.featuredProperty = featuredProperty;
        return this;
    }

    public TestPropertyBuilder withRegionId(final Integer regionId) {
        this.regionId = regionId;
        return this;
    }

    public TestPropertyBuilder withLatitude(final Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public TestPropertyBuilder withLongitude(final Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public TestPropertyBuilder withFlags(final List<String> flags) {
        this.flags = flags;
        return this;
    }

    public TestPropertyBuilder withMainSummary(final String mainSummary) {
        this.mainSummary = mainSummary;
        return this;
    }

    public TestPropertyBuilder withFullDescription(final String fullDescription) {
        this.fullDescription = fullDescription;
        return this;
    }

    public TestPropertyBuilder withPropertyBedrooms(final Integer propertyBedrooms) {
        this.propertyBedrooms = propertyBedrooms;
        return this;
    }

    public TestPropertyBuilder withPropertyBathrooms(final Integer propertyBathrooms) {
        this.propertyBathrooms = propertyBathrooms;
        return this;
    }

    public TestPropertyBuilder withPropertyEnsuites(final Integer propertyEnsuites) {
        this.propertyEnsuites = propertyEnsuites;
        return this;
    }

    public TestPropertyBuilder withPropertyReceptionRooms(final Integer propertyReceptionRooms) {
        this.propertyReceptionRooms = propertyReceptionRooms;
        return this;
    }

    public TestPropertyBuilder withPropertyKitchens(final Integer propertyKitchens) {
        this.propertyKitchens = propertyKitchens;
        return this;
    }

    public TestPropertyBuilder withPropertyAge(final Integer propertyAge) {
        this.propertyAge = propertyAge;
        return this;
    }

    public TestPropertyBuilder withFloorArea(final Double floorArea) {
        this.floorArea = floorArea;
        return this;
    }

    public TestPropertyBuilder withFloorAreaUnits(final String floorAreaUnits) {
        this.floorAreaUnits = floorAreaUnits;
        return this;
    }

    public TestPropertyBuilder withDisplayPropertyType(final String displayPropertyType) {
        this.displayPropertyType = displayPropertyType;
        return this;
    }

    public TestPropertyBuilder withPropertyType(final Integer propertyType) {
        this.propertyType = propertyType;
        return this;
    }

    public TestPropertyBuilder withPropertyStyle(final Integer propertyStyle) {
        this.propertyStyle = propertyStyle;
        return this;
    }

    public TestPropertyBuilder withAvailability(final Integer availability) {
        this.availability = availability;
        return this;
    }

    public TestPropertyBuilder withPrice(final BigDecimal price) {
        this.price = price;
        return this;
    }

    public TestPropertyBuilder withPriceQualifier(final Integer priceQualifier) {
        this.priceQualifier = priceQualifier;
        return this;
    }

    public TestPropertyBuilder withForSalePOA(final Integer forSalePOA) {
        this.forSalePOA = forSalePOA;
        return this;
    }

    public TestPropertyBuilder withPropertyTenure(final Integer propertyTenure) {
        this.propertyTenure = propertyTenure;
        return this;
    }

    public TestPropertyBuilder withSaleBy(final Integer saleBy) {
        this.saleBy = saleBy;
        return this;
    }

    public TestPropertyBuilder withDevelopmentOpportunity(final Integer developmentOpportunity) {
        this.developmentOpportunity = developmentOpportunity;
        return this;
    }

    public TestPropertyBuilder withInvestmentOpportunity(final Integer investmentOpportunity) {
        this.investmentOpportunity = investmentOpportunity;
        return this;
    }

    public TestPropertyBuilder withEstimatedRentalIncome(final BigDecimal estimatedRentalIncome) {
        this.estimatedRentalIncome = estimatedRentalIncome;
        return this;
    }

    public TestPropertyBuilder withRent(final BigDecimal rent) {
        this.rent = rent;
        return this;
    }

    public TestPropertyBuilder withRentFrequency(final Integer rentFrequency) {
        this.rentFrequency = rentFrequency;
        return this;
    }

    public TestPropertyBuilder withToLetPOA(final Integer toLetPOA) {
        this.toLetPOA = toLetPOA;
        return this;
    }

    public TestPropertyBuilder withStudentProperty(final Integer studentProperty) {
        this.studentProperty = studentProperty;
        return this;
    }

    public TestPropertyBuilder withLettingFeePolicyHeadline(final String lettingFeePolicyHeadline) {
        this.lettingFeePolicyHeadline = lettingFeePolicyHeadline;
        return this;
    }

    public TestPropertyBuilder withLettingFeePolicyDetails(final String lettingFeePolicyDetails) {
        this.lettingFeePolicyDetails = lettingFeePolicyDetails;
        return this;
    }

    public TestPropertyBuilder withForSale(final Integer forSale) {
        this.forSale = forSale;
        return this;
    }

    public TestPropertyBuilder withToLet(final Integer toLet) {
        this.toLet = toLet;
        return this;
    }

    public TestPropertyBuilder withPriceTo(final BigDecimal priceTo) {
        this.priceTo = priceTo;
        return this;
    }

    public TestPropertyBuilder withPriceFrom(final BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
        return this;
    }

    public TestPropertyBuilder withRentTo(final BigDecimal rentTo) {
        this.rentTo = rentTo;
        return this;
    }

    public TestPropertyBuilder withRentFrom(final BigDecimal rentFrom) {
        this.rentFrom = rentFrom;
        return this;
    }

    public TestPropertyBuilder withFloorAreaTo(final Double floorAreaTo) {
        this.floorAreaTo = floorAreaTo;
        return this;
    }

    public TestPropertyBuilder withFloorAreaFrom(final Double floorAreaFrom) {
        this.floorAreaFrom = floorAreaFrom;
        return this;
    }

    public TestPropertyBuilder withSiteArea(final Double siteArea) {
        this.siteArea = siteArea;
        return this;
    }

    public TestPropertyBuilder withSiteAreaUnits(final String siteAreaUnits) {
        this.siteAreaUnits = siteAreaUnits;
        return this;
    }

    public TestPropertyBuilder withStrapLine(final String strapLine) {
        this.strapLine = strapLine;
        return this;
    }

    public TestPropertyBuilder withPropertyTypes(final List<Integer> propertyTypes) {
        this.propertyTypes = propertyTypes;
        return this;
    }

    public TestPropertyBuilder withLandAreaTo(final Double landAreaTo) {
        this.landAreaTo = landAreaTo;
        return this;
    }

    public TestPropertyBuilder withLandAreaFrom(final Double landAreaFrom) {
        this.landAreaFrom = landAreaFrom;
        return this;
    }

    public TestPropertyBuilder withLandAreaUnits(final String landAreaUnits) {
        this.landAreaUnits = landAreaUnits;
        return this;
    }

    public TestPropertyBuilder withForSaleLeaseLength(final Integer forSaleLeaseLength) {
        this.forSaleLeaseLength = forSaleLeaseLength;
        return this;
    }

    public TestPropertyBuilder withImages(final List<Image> images) {
        this.images = images;
        return this;
    }

    public TestPropertyBuilder withFloorplans(final List<Floorplan> floorplans) {
        this.floorplans = floorplans;
        return this;
    }

    public TestPropertyBuilder withEpcGraphs(final List<EpcGraph> epcGraphs) {
        this.epcGraphs = epcGraphs;
        return this;
    }

    public TestPropertyBuilder withEpcFrontPages(final List<EpcFrontPage> epcFrontPages) {
        this.epcFrontPages = epcFrontPages;
        return this;
    }

    public TestPropertyBuilder withBrochures(final List<Brochure> brochures) {
        this.brochures = brochures;
        return this;
    }

    public TestPropertyBuilder withVirtualTours(final List<VirtualTour> virtualTours) {
        this.virtualTours = virtualTours;
        return this;
    }

    public TestPropertyBuilder withExternalLinks(final List<ExternalLink> externalLinks) {
        this.externalLinks = externalLinks;
        return this;
    }

    public Property build() {
        return new Property(propertyId, branchId, clientName, branchName, department, referenceNumber, addressName
                , addressNumber, addressStreet, address2, address3, address4, addressPostcode, country, displayAddress
                , propertyFeature1, propertyFeature2, propertyFeature3, propertyFeature4, propertyFeature5
                , propertyFeature6, propertyFeature7, propertyFeature8, propertyFeature9, propertyFeature10
                , dateLastModified, timeLastModified, featuredProperty, regionId, latitude, longitude, flags
                , mainSummary, fullDescription, propertyBedrooms, propertyBathrooms, propertyEnsuites
                , propertyReceptionRooms, propertyKitchens, propertyAge, floorArea, floorAreaUnits, displayPropertyType
                , propertyType, propertyStyle, availability, price, priceQualifier, forSalePOA, propertyTenure, saleBy
                , developmentOpportunity, investmentOpportunity, estimatedRentalIncome, rent, rentFrequency, toLetPOA
                , studentProperty, lettingFeePolicyHeadline, lettingFeePolicyDetails, forSale, toLet, priceTo
                , priceFrom, rentTo, rentFrom, floorAreaTo, floorAreaFrom, siteArea, siteAreaUnits, strapLine
                , propertyTypes, landAreaTo, landAreaFrom, landAreaUnits, forSaleLeaseLength, images, floorplans
                , epcGraphs, epcFrontPages, brochures, virtualTours, externalLinks);
    }
}