package com.akross.gateway.property.entity;

import com.akross.gateway.utilities.adaptors.LocalDateAdapter;
import com.akross.gateway.utilities.adaptors.LocalTimeAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Property {

    @XmlElement(name = "propertyID")
    private final Long propertyId;
    @XmlElement(name = "branchID")
    private final Integer branchId;
    @XmlElement(name = "clientName")
    private final String clientName;
    @XmlElement(name = "branchName")
    private final String branchName;
    @XmlElement(name = "department")
    private final String department;
    @XmlElement(name = "referenceNumber")
    private final String referenceNumber;
    @XmlElement(name = "addressName")
    private final String addressName;
    @XmlElement(name = "addressNumber")
    private final String addressNumber;
    @XmlElement(name = "addressStreet")
    private final String addressStreet;
    @XmlElement(name = "address2")
    private final String address2;
    @XmlElement(name = "address3")
    private final String address3;
    @XmlElement(name = "address4")
    private final String address4;
    @XmlElement(name = "addressPostcode")
    private final String addressPostcode;
    @XmlElement(name = "country")
    private final String country;
    @XmlElement(name = "displayAddress")
    private final String displayAddress;
    @XmlElement(name = "propertyFeature1")
    private final String propertyFeature1;
    @XmlElement(name = "propertyFeature2")
    private final String propertyFeature2;
    @XmlElement(name = "propertyFeature3")
    private final String propertyFeature3;
    @XmlElement(name = "propertyFeature4")
    private final String propertyFeature4;
    @XmlElement(name = "propertyFeature5")
    private final String propertyFeature5;
    @XmlElement(name = "propertyFeature6")
    private final String propertyFeature6;
    @XmlElement(name = "propertyFeature7")
    private final String propertyFeature7;
    @XmlElement(name = "propertyFeature8")
    private final String propertyFeature8;
    @XmlElement(name = "propertyFeature9")
    private final String propertyFeature9;
    @XmlElement(name = "propertyFeature10")
    private final String propertyFeature10;
    @XmlElement(name = "dateLastModified")
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private final LocalDate dateLastModified;
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    @XmlElement(name = "timeLastModified")
    private final LocalTime timeLastModified;
    @XmlElement(name = "featuredProperty")
    private final Integer featuredProperty;
    @XmlElement(name = "regionID")
    private final Integer regionId;
    @XmlElement(name = "latitude")
    private final Double latitude;
    @XmlElement(name = "longitude")
    private final Double longitude;
    @XmlElementWrapper(name = "flags")
    @XmlElement(name = "flag")
    private final List<String> flags;
    @XmlElement(name = "mainSummary")
    private final String mainSummary;
    @XmlElement(name = "fullDescription")
    private final String fullDescription;
    @XmlElement(name = "propertyBedrooms")
    private final Integer propertyBedrooms;
    @XmlElement(name = "propertyBathrooms")
    private final Integer propertyBathrooms;
    @XmlElement(name = "propertyEnsuites")
    private final Integer propertyEnsuites;
    @XmlElement(name = "propertyReceptionRooms")
    private final Integer propertyReceptionRooms;
    @XmlElement(name = "propertyKitchens")
    private final Integer propertyKitchens;
    @XmlElement(name = "propertyAge")
    private final Integer propertyAge;
    @XmlElement(name = "floorArea")
    private final Double floorArea;
    @XmlElement(name = "floorAreaUnits")
    private final String floorAreaUnits;
    @XmlElement(name = "displayPropertyType")
    private final String displayPropertyType;
    @XmlElement(name = "propertyType")
    private final Integer propertyType;
    @XmlElement(name = "propertyStyle")
    private final Integer propertyStyle;
    @XmlElement(name = "availability")
    private final Integer availability;
    @XmlElement(name = "price")
    private final BigDecimal price;
    @XmlElement(name = "priceQualifier")
    private final Integer priceQualifier;
    @XmlElement(name = "forSalePOA")
    private final Integer forSalePOA;
    @XmlElement(name = "propertyTenure")
    private final Integer propertyTenure;
    @XmlElement(name = "saleBy")
    private final Integer saleBy;
    @XmlElement(name = "developmentOpportunity")
    private final Integer developmentOpportunity;
    @XmlElement(name = "investmentOpportunity")
    private final Integer investmentOpportunity;
    @XmlElement(name = "estimatedRentalIncome")
    private final BigDecimal estimatedRentalIncome;
    @XmlElement(name = "rent")
    private final BigDecimal rent;
    @XmlElement(name = "rentFrequency")
    private final Integer rentFrequency;
    @XmlElement(name = "toLetPOA")
    private final Integer toLetPOA;
    @XmlElement(name = "studentProperty")
    private final Integer studentProperty;
    @XmlElement(name = "lettingFeePolicyHeadline")
    private final String lettingFeePolicyHeadline;
    @XmlElement(name = "lettingFeePolicyDetails")
    private final String lettingFeePolicyDetails;
    @XmlElement(name = "forSale")
    private final Integer forSale;
    @XmlElement(name = "toLet")
    private final Integer toLet;
    @XmlElement(name = "priceTo")
    private final BigDecimal priceTo;
    @XmlElement(name = "priceFrom")
    private final BigDecimal priceFrom;
    @XmlElement(name = "rentTo")
    private final BigDecimal rentTo;
    @XmlElement(name = "rentFrom")
    private final BigDecimal rentFrom;
    @XmlElement(name = "floorAreaTo")
    private final Double floorAreaTo;
    @XmlElement(name = "floorAreaFrom")
    private final Double floorAreaFrom;
    @XmlElement(name = "siteArea")
    private final Double siteArea;
    @XmlElement(name = "siteAreaUnits")
    private final String siteAreaUnits;
    @XmlElement(name = "strapLine")
    private final String strapLine;
    @XmlElementWrapper(name = "propertyTypes")
    @XmlElement(name = "propertyType")
    private final List<Integer> propertyTypes;
    @XmlElement(name = "landAreaTo")
    private final Double landAreaTo;
    @XmlElement(name = "landAreaFrom")
    private final Double landAreaFrom;
    @XmlElement(name = "landAreaUnits")
    private final String landAreaUnits;
    @XmlElement(name = "forSaleLeaseLength")
    private final Integer forSaleLeaseLength;
    @XmlElementWrapper(name = "images")
    @XmlElement(name = "image")
    private final List<Image> images;
    @XmlElementWrapper(name = "floorplans")
    @XmlElement(name = "floorplan")
    private final List<Floorplan> floorplans;
    @XmlElementWrapper(name = "epcGraphs")
    @XmlElement(name = "epcGraph")
    private final List<EpcGraph> epcGraphs;
    @XmlElementWrapper(name = "epcFrontPages")
    @XmlElement(name = "epcFrontPage")
    private final List<EpcFrontPage> epcFrontPages;
    @XmlElementWrapper(name = "brochures")
    @XmlElement(name = "brochure")
    private final List<Brochure> brochures;
    @XmlElementWrapper(name = "virtualTours")
    @XmlElement(name = "virtualTour")
    private final List<VirtualTour> virtualTours;
    @XmlElementWrapper(name = "externalLinks")
    @XmlElement(name = "externalLink")
    private final List<ExternalLink> externalLinks;

    private Property() {
        this(null, null, null, null, null
                , null, null, null, null
                , null, null, null, null, null
                , null, null, null, null
                , null, null, null, null
                , null, null, null, null
                , null, null, null, null, null
                , new ArrayList<>(), null, null, null, null
                , null, null, null, null, null
                , null, null, null, null, null
                , null, null, null, null, null
                , null, null, null, null
                , null, null, null, null
                , null, null, null, null, null, null
                , null, null, null, null, null, null
                , new ArrayList<>(), null, null, null, null
                , new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
                , new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Property(final Long propertyId
            , final Integer branchId
            , final String clientName
            , final String branchName
            , final String department
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
            , final Integer featuredProperty
            , final Integer regionId
            , final Double latitude
            , final Double longitude
            , final List<String> flags
            , final String mainSummary
            , final String fullDescription
            , final Integer propertyBedrooms
            , final Integer propertyBathrooms
            , final Integer propertyEnsuites
            , final Integer propertyReceptionRooms
            , final Integer propertyKitchens
            , final Integer propertyAge
            , final Double floorArea
            , final String floorAreaUnits
            , final String displayPropertyType
            , final Integer propertyType
            , final Integer propertyStyle
            , final Integer availability
            , final BigDecimal price
            , final Integer priceQualifier
            , final Integer forSalePOA
            , final Integer propertyTenure
            , final Integer saleBy
            , final Integer developmentOpportunity
            , final Integer investmentOpportunity
            , final BigDecimal estimatedRentalIncome
            , final BigDecimal rent
            , final Integer rentFrequency
            , final Integer toLetPOA
            , final Integer studentProperty
            , final String lettingFeePolicyHeadline
            , final String lettingFeePolicyDetails
            , final Integer forSale
            , final Integer toLet
            , final BigDecimal priceTo
            , final BigDecimal priceFrom
            , final BigDecimal rentTo
            , final BigDecimal rentFrom
            , final Double floorAreaTo
            , final Double floorAreaFrom
            , final Double siteArea
            , final String siteAreaUnits
            , final String strapLine
            , final List<Integer> propertyTypes
            , final Double landAreaTo
            , final Double landAreaFrom
            , final String landAreaUnits
            , final Integer forSaleLeaseLength
            , final List<Image> images
            , final List<Floorplan> floorplans
            , final List<EpcGraph> epcGraphs
            , final List<EpcFrontPage> epcFrontPages
            , final List<Brochure> brochures
            , final List<VirtualTour> virtualTours
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

    public List<String> getFlags() {
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

    public Integer getPriceQualifier() {
        return priceQualifier;
    }

    public Integer getForSalePOA() {
        return forSalePOA;
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

    public List<Integer> getPropertyTypes() {
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

    public List<Image> getImages() {
        return images;
    }

    public List<Floorplan> getFloorplans() {
        return floorplans;
    }

    public List<EpcGraph> getEpcGraphs() {
        return epcGraphs;
    }

    public List<EpcFrontPage> getEpcFrontPages() {
        return epcFrontPages;
    }

    public List<Brochure> getBrochures() {
        return brochures;
    }

    public List<VirtualTour> getVirtualTours() {
        return virtualTours;
    }

    public List<ExternalLink> getExternalLinks() {
        return externalLinks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;
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
                ", addressNumber='" + addressNumber + '\'' +
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