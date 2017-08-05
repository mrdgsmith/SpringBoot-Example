package com.akross.domain.property.residentialsalesandletting;

import com.akross.domain.property.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public abstract class ResidentialSalesAndLettings extends Property {

    private final Integer propertyBedrooms;
    private final Integer propertyEnsuites;
    private final Integer propertyBathrooms;
    private final Integer propertyReceptionRooms;
    private final Integer propertyKitchens;
    private final PropertyAge propertyAge;
    private final Double floorArea;
    private final FloorAreaUnit floorAreaUnit;
    private final String displayPropertyType;
    private final PropertyType propertyType;
    private final PropertyStyle propertyStyle;

    public ResidentialSalesAndLettings(
            final Long propertyId
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
            , final PropertyStyle propertyStyle) {
        super(propertyId, branchId, clientName, branchName, department, referenceNumber, addressName, addressNumber
                , addressStreet, address2, address3, address4, addressPostcode, country, displayAddress
                , propertyFeature1, propertyFeature2, propertyFeature3, propertyFeature4, propertyFeature5
                , propertyFeature6, propertyFeature7, propertyFeature8, propertyFeature9, propertyFeature10
                , dateLastModified, timeLastModified, isFeaturedProperty, regionId, latitude, longitude, flags
                , mainSummary, fullDescription, images, floorplans, brochures, virtualTours, epcGraphs, epcFrontPages
                , externalLinks);
        this.propertyBedrooms = propertyBedrooms;
        this.propertyEnsuites = propertyEnsuites;
        this.propertyBathrooms = propertyBathrooms;
        this.propertyReceptionRooms = propertyReceptionRooms;
        this.propertyKitchens = propertyKitchens;
        this.propertyAge = propertyAge;
        this.floorArea = floorArea;
        this.floorAreaUnit = floorAreaUnit;
        this.displayPropertyType = displayPropertyType;
        this.propertyType = propertyType;
        this.propertyStyle = propertyStyle;
    }

    public Integer getPropertyBedrooms() {
        return propertyBedrooms;
    }

    public Integer getPropertyEnsuites() {
        return propertyEnsuites;
    }

    public Integer getPropertyBathrooms() {
        return propertyBathrooms;
    }

    public Integer getPropertyReceptionRooms() {
        return propertyReceptionRooms;
    }

    public Integer getPropertyKitchens() {
        return propertyKitchens;
    }

    public PropertyAge getPropertyAge() {
        return propertyAge;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public FloorAreaUnit getFloorAreaUnit() {
        return floorAreaUnit;
    }

    public String getDisplayPropertyType() {
        return displayPropertyType;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public PropertyStyle getPropertyStyle() {
        return propertyStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResidentialSalesAndLettings)) return false;
        if (!super.equals(o)) return false;
        ResidentialSalesAndLettings that = (ResidentialSalesAndLettings) o;
        return Objects.equals(propertyBedrooms, that.propertyBedrooms) &&
                Objects.equals(propertyEnsuites, that.propertyEnsuites) &&
                Objects.equals(propertyBathrooms, that.propertyBathrooms) &&
                Objects.equals(propertyReceptionRooms, that.propertyReceptionRooms) &&
                Objects.equals(propertyKitchens, that.propertyKitchens) &&
                propertyAge == that.propertyAge &&
                Objects.equals(floorArea, that.floorArea) &&
                floorAreaUnit == that.floorAreaUnit &&
                Objects.equals(displayPropertyType, that.displayPropertyType) &&
                propertyType == that.propertyType &&
                propertyStyle == that.propertyStyle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), propertyBedrooms, propertyEnsuites, propertyBathrooms
                , propertyReceptionRooms, propertyKitchens, propertyAge, floorArea, floorAreaUnit
                , displayPropertyType, propertyType, propertyStyle);
    }

    @Override
    public String toString() {
        return "ResidentialSalesAndLettings{" +
                "propertyBedrooms=" + propertyBedrooms +
                ", propertyEnsuites=" + propertyEnsuites +
                ", propertyBathrooms=" + propertyBathrooms +
                ", propertyReceptionRooms=" + propertyReceptionRooms +
                ", propertyKitchens=" + propertyKitchens +
                ", propertyAge=" + propertyAge +
                ", floorArea=" + floorArea +
                ", floorAreaUnit=" + floorAreaUnit +
                ", displayPropertyType='" + displayPropertyType + '\'' +
                ", propertyType=" + propertyType +
                ", propertyStyle=" + propertyStyle +
                "} " + super.toString();
    }
}