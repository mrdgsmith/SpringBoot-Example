package com.akross.repository.property.entity.residentialsalesandletting;

import com.akross.domain.property.Department;
import com.akross.domain.property.residentialsalesandletting.FloorAreaUnit;
import com.akross.domain.property.residentialsalesandletting.PropertyAge;
import com.akross.domain.property.residentialsalesandletting.PropertyStyle;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.repository.property.entity.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance
public abstract class ResidentialSalesAndLettings extends Property {

    private Integer propertyBedrooms;
    private Integer propertyEnsuites;
    private Integer propertyBathrooms;
    private Integer propertyReceptionRooms;
    private Integer propertyKitchens;
    private PropertyAge propertyAge;
    private Double floorArea;
    private FloorAreaUnit floorAreaUnit;
    private String displayPropertyType;
    private PropertyType propertyType;
    private PropertyStyle propertyStyle;

    protected ResidentialSalesAndLettings() {
    }

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
            , final Set<Image> images
            , final Set<Floorplan> floorplans
            , final Set<Brochure> brochures
            , final Set<VirtualTour> virtualTours
            , final Set<EpcGraph> epcGraphs
            , final Set<EpcFrontPage> epcFrontPages
            , final Set<ExternalLink> externalLinks
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
}