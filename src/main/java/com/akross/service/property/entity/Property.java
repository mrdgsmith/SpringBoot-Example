package com.akross.service.property.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import java.math.BigDecimal;
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
    private final Integer propertyBedrooms;
    private final Integer propertyBathrooms;
    private final Integer propertyEnsuites;
    private final Integer propertyReceptionRooms;
    private final Integer propertyKitchens;
    private final Integer propertyAge;
    private final Double floorArea;
    private final String floorAreaUnits;
    private final String displayPropertyType;
    private final Integer propertyType;
    private final Integer propertyStyle;
    private final Integer availability;
    private final BigDecimal price;
    private final Integer priceQualifier;
    private final Integer forSalePOA;
    private final Integer propertyTenure;
    private final Integer saleBy;
    private final Integer developmentOpportunity;
    private final Integer investmentOpportunity;
    private final BigDecimal estimatedRentalIncome;
    private final BigDecimal rent;
    private final Integer rentFrequency;
    private final Integer toLetPOA;
    private final Integer studentProperty;
    private final String lettingFeePolicyHeadline;
    private final String lettingFeePolicyDetails;
    private final Integer forSale;
    private final Integer toLet;
    private final BigDecimal priceTo;
    private final BigDecimal priceFrom;
    private final BigDecimal rentTo;
    private final BigDecimal rentFrom;
    private final Double floorAreaTo;
    private final Double floorAreaFrom;
    private final Double siteArea;
    private final String siteAreaUnits;
    private final String strapLine;
    private final PropertyTypes propertyTypes;
    private final Double landAreaTo;
    private final Double landAreaFrom;
    private final String landAreaUnits;
    private final Integer forSaleLeaseLength;
    private final Images images;
    private final Floorplans floorplans;
    private final EpcGraphs epcGraphs;
    private final EpcFrontPages epcFrontPages;
    private final Brochures brochures;
    private final VirtualTours virtualTours;
    private final ExternalLinks externalLinks;

    public Property(
            @JacksonXmlProperty(localName = "propertyID") final Long propertyId
            , @JacksonXmlProperty(localName = "branchID") final Integer branchId
            , @JacksonXmlProperty(localName = "clientName") final String clientName
            , @JacksonXmlProperty(localName = "branchName") final String branchName
            , @JacksonXmlProperty(localName = "department") final String department
            , @JacksonXmlProperty(localName = "referenceNumber") final String referenceNumber
            , @JacksonXmlProperty(localName = "addressName") final String addressName
            , @JacksonXmlProperty(localName = "addressNumber") final Integer addressNumber
            , @JacksonXmlProperty(localName = "addressStreet") final String addressStreet
            , @JacksonXmlProperty(localName = "address2") final String address2
            , @JacksonXmlProperty(localName = "address3") final String address3
            , @JacksonXmlProperty(localName = "address4") final String address4
            , @JacksonXmlProperty(localName = "addressPostCode") final String addressPostcode
            , @JacksonXmlProperty(localName = "country") final String country
            , @JacksonXmlProperty(localName = "displayAddress") final String displayAddress
            , @JacksonXmlProperty(localName = "propertyFeature1") final String propertyFeature1
            , @JacksonXmlProperty(localName = "propertyFeature2") final String propertyFeature2
            , @JacksonXmlProperty(localName = "propertyFeature3") final String propertyFeature3
            , @JacksonXmlProperty(localName = "propertyFeature4") final String propertyFeature4
            , @JacksonXmlProperty(localName = "propertyFeature5") final String propertyFeature5
            , @JacksonXmlProperty(localName = "propertyFeature6") final String propertyFeature6
            , @JacksonXmlProperty(localName = "propertyFeature7") final String propertyFeature7
            , @JacksonXmlProperty(localName = "propertyFeature8") final String propertyFeature8
            , @JacksonXmlProperty(localName = "propertyFeature9") final String propertyFeature9
            , @JacksonXmlProperty(localName = "propertyFeature10") final String propertyFeature10
            , @JacksonXmlProperty(localName = "dateLastModified")
            @JsonDeserialize(using = LocalDateDeserializer.class) final LocalDate dateLastModified
            , @JacksonXmlProperty(localName = "timeLastModified")
            @JsonDeserialize(using = LocalTimeDeserializer.class) final LocalTime timeLastModified
            , @JacksonXmlProperty(localName = "featuredProperty") final Integer featuredProperty
            , @JacksonXmlProperty(localName = "regionID") final Integer regionId
            , @JacksonXmlProperty(localName = "latitude") final Double latitude
            , @JacksonXmlProperty(localName = "longitude") final Double longitude
            , @JacksonXmlProperty(localName = "flags") final Flags flags
            , @JacksonXmlProperty(localName = "mainSummary") final String mainSummary
            , @JacksonXmlProperty(localName = "fullDescription") final String fullDescription
            , @JacksonXmlProperty(localName = "propertyBedrooms") final Integer propertyBedrooms
            , @JacksonXmlProperty(localName = "propertyBathrooms") final Integer propertyBathrooms
            , @JacksonXmlProperty(localName = "propertyEnsuites") final Integer propertyEnsuites
            , @JacksonXmlProperty(localName = "propertyReceptionRooms") final Integer propertyReceptionRooms
            , @JacksonXmlProperty(localName = "propertyKitchens") final Integer propertyKitchens
            , @JacksonXmlProperty(localName = "propertyAge") final Integer propertyAge
            , @JacksonXmlProperty(localName = "floorArea") final Double floorArea
            , @JacksonXmlProperty(localName = "floorAreaUnits") final String floorAreaUnits
            , @JacksonXmlProperty(localName = "displayPropertyType") final String displayPropertyType
            , @JacksonXmlProperty(localName = "propertyType") final Integer propertyType
            , @JacksonXmlProperty(localName = "propertyStyle") final Integer propertyStyle
            , @JacksonXmlProperty(localName = "availability") final Integer availability
            , @JacksonXmlProperty(localName = "price") final BigDecimal price
            , @JacksonXmlProperty(localName = "priceQualifier") final Integer priceQualifier
            , @JacksonXmlProperty(localName = "forSalePOA") final Integer forSalePOA
            , @JacksonXmlProperty(localName = "propertyTenure") final Integer propertyTenure
            , @JacksonXmlProperty(localName = "saleBy") final Integer saleBy
            , @JacksonXmlProperty(localName = "developmentOpportunity") final Integer developmentOpportunity
            , @JacksonXmlProperty(localName = "investmentOpportunity") final Integer investmentOpportunity
            , @JacksonXmlProperty(localName = "estimatedRentalIncome") final BigDecimal estimatedRentalIncome
            , @JacksonXmlProperty(localName = "rent") final BigDecimal rent
            , @JacksonXmlProperty(localName = "rentFrequency") final Integer rentFrequency
            , @JacksonXmlProperty(localName = "toLetPOA") final Integer toLetPOA
            , @JacksonXmlProperty(localName = "studentProperty") final Integer studentProperty
            , @JacksonXmlProperty(localName = "lettingFeePolicyHeadline") final String lettingFeePolicyHeadline
            , @JacksonXmlProperty(localName = "lettingFeePolicyDetails") final String lettingFeePolicyDetails
            , @JacksonXmlProperty(localName = "forSale") final Integer forSale
            , @JacksonXmlProperty(localName = "toLet") final Integer toLet
            , @JacksonXmlProperty(localName = "priceTo") final BigDecimal priceTo
            , @JacksonXmlProperty(localName = "priceFrom") final BigDecimal priceFrom
            , @JacksonXmlProperty(localName = "rentTo") final BigDecimal rentTo
            , @JacksonXmlProperty(localName = "rentFrom") final BigDecimal rentFrom
            , @JacksonXmlProperty(localName = "floorAreaTo") final Double floorAreaTo
            , @JacksonXmlProperty(localName = "floorAreaFrom") final Double floorAreaFrom
            , @JacksonXmlProperty(localName = "siteArea") final Double siteArea
            , @JacksonXmlProperty(localName = "siteAreaUnits") final String siteAreaUnits
            , @JacksonXmlProperty(localName = "strapLine") final String strapLine
            , @JacksonXmlProperty(localName = "propertyTypes") final PropertyTypes propertyTypes
            , @JacksonXmlProperty(localName = "landAreaTo") final Double landAreaTo
            , @JacksonXmlProperty(localName = "landAreaFrom") final Double landAreaFrom
            , @JacksonXmlProperty(localName = "landAreaUnits") final String landAreaUnits
            , @JacksonXmlProperty(localName = "forSaleLeaseLength") final Integer forSaleLeaseLength
            , @JacksonXmlProperty(localName = "images") final Images images
            , @JacksonXmlProperty(localName = "floorplans") final Floorplans floorplans
            , @JacksonXmlProperty(localName = "epcGraphs") final EpcGraphs epcGraphs
            , @JacksonXmlProperty(localName = "epcFrontPages") final EpcFrontPages epcFrontPages
            , @JacksonXmlProperty(localName = "brochures") final Brochures brochures
            , @JacksonXmlProperty(localName = "virtualTours") final VirtualTours virtualTours
            , @JacksonXmlProperty(localName = "externalLinks") final ExternalLinks externalLinks) {
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
        this.propertyBedrooms = propertyBedrooms;
        this.propertyBathrooms = propertyBathrooms;
        this.propertyEnsuites = propertyEnsuites;
        this.propertyReceptionRooms = propertyReceptionRooms;
        this.propertyKitchens = propertyKitchens;
        this.propertyAge = propertyAge;
        this.floorArea = floorArea;
        this.floorAreaUnits = floorAreaUnits;
        this.displayPropertyType = displayPropertyType;
        this.propertyType = propertyType;
        this.propertyStyle = propertyStyle;
        this.availability = availability;
        this.price = price;
        this.priceQualifier = priceQualifier;
        this.forSalePOA = forSalePOA;
        this.propertyTenure = propertyTenure;
        this.saleBy = saleBy;
        this.developmentOpportunity = developmentOpportunity;
        this.investmentOpportunity = investmentOpportunity;
        this.estimatedRentalIncome = estimatedRentalIncome;
        this.rent = rent;
        this.rentFrequency = rentFrequency;
        this.toLetPOA = toLetPOA;
        this.studentProperty = studentProperty;
        this.lettingFeePolicyHeadline = lettingFeePolicyHeadline;
        this.lettingFeePolicyDetails = lettingFeePolicyDetails;
        this.forSale = forSale;
        this.toLet = toLet;
        this.priceTo = priceTo;
        this.priceFrom = priceFrom;
        this.rentTo = rentTo;
        this.rentFrom = rentFrom;
        this.floorAreaTo = floorAreaTo;
        this.floorAreaFrom = floorAreaFrom;
        this.siteArea = siteArea;
        this.siteAreaUnits = siteAreaUnits;
        this.strapLine = strapLine;
        this.propertyTypes = propertyTypes;
        this.landAreaTo = landAreaTo;
        this.landAreaFrom = landAreaFrom;
        this.landAreaUnits = landAreaUnits;
        this.forSaleLeaseLength = forSaleLeaseLength;
        this.images = images;
        this.floorplans = floorplans;
        this.epcGraphs = epcGraphs;
        this.epcFrontPages = epcFrontPages;
        this.brochures = brochures;
        this.virtualTours = virtualTours;
        this.externalLinks = externalLinks;
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

    public Integer getPropertyBedrooms() {
        return propertyBedrooms;
    }

    public Integer getPropertyBathrooms() {
        return propertyBathrooms;
    }

    public Integer getPropertyEnsuites() {
        return propertyEnsuites;
    }

    public Integer getPropertyReceptionRooms() {
        return propertyReceptionRooms;
    }

    public Integer getPropertyKitchens() {
        return propertyKitchens;
    }

    public Integer getPropertyAge() {
        return propertyAge;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public String getFloorAreaUnits() {
        return floorAreaUnits;
    }

    public String getDisplayPropertyType() {
        return displayPropertyType;
    }

    public Integer getPropertyType() {
        return propertyType;
    }

    public Integer getPropertyStyle() {
        return propertyStyle;
    }

    public Integer getAvailability() {
        return availability;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getForSalePOA() {
        return forSalePOA;
    }

    public Integer getPriceQualifier() {
        return priceQualifier;
    }

    public Integer getPropertyTenure() {
        return propertyTenure;
    }

    public Integer getSaleBy() {
        return saleBy;
    }

    public Integer getDevelopmentOpportunity() {
        return developmentOpportunity;
    }

    public Integer getInvestmentOpportunity() {
        return investmentOpportunity;
    }

    public BigDecimal getEstimatedRentalIncome() {
        return estimatedRentalIncome;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public Integer getRentFrequency() {
        return rentFrequency;
    }

    public Integer getToLetPOA() {
        return toLetPOA;
    }

    public Integer getStudentProperty() {
        return studentProperty;
    }

    public String getLettingFeePolicyHeadline() {
        return lettingFeePolicyHeadline;
    }

    public String getLettingFeePolicyDetails() {
        return lettingFeePolicyDetails;
    }

    public Integer getForSale() {
        return forSale;
    }

    public Integer getToLet() {
        return toLet;
    }

    public BigDecimal getPriceTo() {
        return priceTo;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public BigDecimal getRentTo() {
        return rentTo;
    }

    public BigDecimal getRentFrom() {
        return rentFrom;
    }

    public Double getFloorAreaTo() {
        return floorAreaTo;
    }

    public Double getFloorAreaFrom() {
        return floorAreaFrom;
    }

    public Double getSiteArea() {
        return siteArea;
    }

    public String getSiteAreaUnits() {
        return siteAreaUnits;
    }

    public String getStrapLine() {
        return strapLine;
    }

    public PropertyTypes getPropertyTypes() {
        return propertyTypes;
    }

    public Double getLandAreaTo() {
        return landAreaTo;
    }

    public Double getLandAreaFrom() {
        return landAreaFrom;
    }

    public String getLandAreaUnits() {
        return landAreaUnits;
    }

    public Integer getForSaleLeaseLength() {
        return forSaleLeaseLength;
    }

    public Images getImages() {
        return images;
    }

    public Floorplans getFloorplans() {
        return floorplans;
    }

    public EpcGraphs getEpcGraphs() {
        return epcGraphs;
    }

    public EpcFrontPages getEpcFrontPages() {
        return epcFrontPages;
    }

    public Brochures getBrochures() {
        return brochures;
    }

    public VirtualTours getVirtualTours() {
        return virtualTours;
    }

    public ExternalLinks getExternalLinks() {
        return externalLinks;
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
                Objects.equals(fullDescription, property.fullDescription) &&
                Objects.equals(propertyBedrooms, property.propertyBedrooms) &&
                Objects.equals(propertyBathrooms, property.propertyBathrooms) &&
                Objects.equals(propertyEnsuites, property.propertyEnsuites) &&
                Objects.equals(propertyReceptionRooms, property.propertyReceptionRooms) &&
                Objects.equals(propertyKitchens, property.propertyKitchens) &&
                Objects.equals(propertyAge, property.propertyAge) &&
                Objects.equals(floorArea, property.floorArea) &&
                Objects.equals(floorAreaUnits, property.floorAreaUnits) &&
                Objects.equals(displayPropertyType, property.displayPropertyType) &&
                Objects.equals(propertyType, property.propertyType) &&
                Objects.equals(propertyStyle, property.propertyStyle) &&
                Objects.equals(availability, property.availability) &&
                Objects.equals(price, property.price) &&
                Objects.equals(priceQualifier, property.priceQualifier) &&
                Objects.equals(forSalePOA, property.forSalePOA) &&
                Objects.equals(propertyTenure, property.propertyTenure) &&
                Objects.equals(saleBy, property.saleBy) &&
                Objects.equals(developmentOpportunity, property.developmentOpportunity) &&
                Objects.equals(investmentOpportunity, property.investmentOpportunity) &&
                Objects.equals(estimatedRentalIncome, property.estimatedRentalIncome) &&
                Objects.equals(rent, property.rent) &&
                Objects.equals(rentFrequency, property.rentFrequency) &&
                Objects.equals(toLetPOA, property.toLetPOA) &&
                Objects.equals(studentProperty, property.studentProperty) &&
                Objects.equals(lettingFeePolicyHeadline, property.lettingFeePolicyHeadline) &&
                Objects.equals(lettingFeePolicyDetails, property.lettingFeePolicyDetails) &&
                Objects.equals(forSale, property.forSale) &&
                Objects.equals(toLet, property.toLet) &&
                Objects.equals(priceTo, property.priceTo) &&
                Objects.equals(priceFrom, property.priceFrom) &&
                Objects.equals(rentTo, property.rentTo) &&
                Objects.equals(rentFrom, property.rentFrom) &&
                Objects.equals(floorAreaTo, property.floorAreaTo) &&
                Objects.equals(floorAreaFrom, property.floorAreaFrom) &&
                Objects.equals(siteArea, property.siteArea) &&
                Objects.equals(siteAreaUnits, property.siteAreaUnits) &&
                Objects.equals(strapLine, property.strapLine) &&
                Objects.equals(propertyTypes, property.propertyTypes) &&
                Objects.equals(landAreaTo, property.landAreaTo) &&
                Objects.equals(landAreaFrom, property.landAreaFrom) &&
                Objects.equals(landAreaUnits, property.landAreaUnits) &&
                Objects.equals(forSaleLeaseLength, property.forSaleLeaseLength) &&
                Objects.equals(images, property.images) &&
                Objects.equals(floorplans, property.floorplans) &&
                Objects.equals(epcGraphs, property.epcGraphs) &&
                Objects.equals(epcFrontPages, property.epcFrontPages) &&
                Objects.equals(brochures, property.brochures) &&
                Objects.equals(virtualTours, property.virtualTours) &&
                Objects.equals(externalLinks, property.externalLinks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, branchId, clientName, branchName, department, referenceNumber, addressName
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
                ", propertyBedrooms=" + propertyBedrooms +
                ", propertyBathrooms=" + propertyBathrooms +
                ", propertyEnsuites=" + propertyEnsuites +
                ", propertyReceptionRooms=" + propertyReceptionRooms +
                ", propertyKitchens=" + propertyKitchens +
                ", propertyAge=" + propertyAge +
                ", floorArea=" + floorArea +
                ", floorAreaUnits='" + floorAreaUnits + '\'' +
                ", displayPropertyType='" + displayPropertyType + '\'' +
                ", propertyType=" + propertyType +
                ", propertyStyle=" + propertyStyle +
                ", availability=" + availability +
                ", price=" + price +
                ", priceQualifier=" + priceQualifier +
                ", forSalePOA=" + forSalePOA +
                ", propertyTenure=" + propertyTenure +
                ", saleBy=" + saleBy +
                ", developmentOpportunity=" + developmentOpportunity +
                ", investmentOpportunity=" + investmentOpportunity +
                ", estimatedRentalIncome=" + estimatedRentalIncome +
                ", rent=" + rent +
                ", rentFrequency=" + rentFrequency +
                ", toLetPOA=" + toLetPOA +
                ", studentProperty=" + studentProperty +
                ", lettingFeePolicyHeadline='" + lettingFeePolicyHeadline + '\'' +
                ", lettingFeePolicyDetails='" + lettingFeePolicyDetails + '\'' +
                ", forSale=" + forSale +
                ", toLet=" + toLet +
                ", priceTo=" + priceTo +
                ", priceFrom=" + priceFrom +
                ", rentTo=" + rentTo +
                ", rentFrom=" + rentFrom +
                ", floorAreaTo=" + floorAreaTo +
                ", floorAreaFrom=" + floorAreaFrom +
                ", siteArea=" + siteArea +
                ", siteAreaUnits='" + siteAreaUnits + '\'' +
                ", strapLine='" + strapLine + '\'' +
                ", propertyTypes=" + propertyTypes +
                ", landAreaTo=" + landAreaTo +
                ", landAreaFrom=" + landAreaFrom +
                ", landAreaUnits='" + landAreaUnits + '\'' +
                ", forSaleLeaseLength=" + forSaleLeaseLength +
                ", images=" + images +
                ", floorplans=" + floorplans +
                ", epcGraphs=" + epcGraphs +
                ", epcFrontPages=" + epcFrontPages +
                ", brochures=" + brochures +
                ", virtualTours=" + virtualTours +
                ", externalLinks=" + externalLinks +
                '}';
    }
}