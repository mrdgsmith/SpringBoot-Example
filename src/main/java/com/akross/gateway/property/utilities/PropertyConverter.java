package com.akross.gateway.property.utilities;


import com.akross.domain.*;
import com.akross.domain.residentialsalesandletting.FloorAreaUnit;
import com.akross.domain.residentialsalesandletting.PropertyAge;
import com.akross.domain.residentialsalesandletting.PropertyStyle;
import com.akross.domain.residentialsalesandletting.PropertyType;
import com.akross.domain.residentialsalesandletting.residentialletting.Availability;
import com.akross.domain.residentialsalesandletting.residentialletting.RentFrequency;
import com.akross.gateway.property.entity.Flag;

import java.util.List;

import static com.akross.domain.Brochure.BrochureBuilder.aBrochure;
import static com.akross.domain.Department.LETTINGS;
import static com.akross.domain.EpcFrontPage.EpcFrontPageBuilder.anEpcFrontPage;
import static com.akross.domain.EpcGraph.EpcGraphBuilder.anEpcGraph;
import static com.akross.domain.ExternalLink.ExternalLinkBuilder.anExternalLink;
import static com.akross.domain.Floorplan.FloorplansBuilder.aFloorplan;
import static com.akross.domain.Image.ImageBuilder.anImage;
import static com.akross.domain.VirtualTour.VirtualTourBuilder.aVirtualTour;
import static com.akross.domain.residentialsalesandletting.PropertyAge.getMap;
import static com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.util.stream.Collectors.toList;

public class PropertyConverter {
    public static Property convert(final com.akross.gateway.property.entity.Property property) {
        final String department = property.getDepartment();
        if (LETTINGS.getDescription().equals(department)) {
            return aResidentialLetting()
                    .withPropertyId(property.getPropertyId())
                    .withBranchId(property.getBranchId())
                    .withClientName(property.getClientName())
                    .withBranchName(property.getBranchName())
                    .withDepartment(LETTINGS)
                    .withReferenceNumber(property.getReferenceNumber())
                    .withAddressName(property.getAddressName())
                    .withAddressNumber(property.getAddressNumber())
                    .withAddressStreet(property.getAddressStreet())
                    .withAddress2(property.getAddress2())
                    .withAddress3(property.getAddress3())
                    .withAddress4(property.getAddress4())
                    .withAddressPostcode(property.getAddressPostcode())
                    .withCountry(property.getCountry())
                    .withDisplayAddress(property.getDisplayAddress())
                    .withPropertyFeature1(property.getPropertyFeature1())
                    .withPropertyFeature2(property.getPropertyFeature2())
                    .withPropertyFeature3(property.getPropertyFeature3())
                    .withPropertyFeature4(property.getPropertyFeature4())
                    .withPropertyFeature5(property.getPropertyFeature5())
                    .withPropertyFeature6(property.getPropertyFeature6())
                    .withPropertyFeature7(property.getPropertyFeature7())
                    .withPropertyFeature8(property.getPropertyFeature8())
                    .withPropertyFeature9(property.getPropertyFeature9())
                    .withPropertyFeature10(property.getPropertyFeature10())
                    .withDateLastModified(property.getDateLastModified())
                    .withTimeLastModified(property.getTimeLastModified())
                    .withIsFeaturedProperty(property.getFeaturedProperty() == 1)
                    .withRegionId(property.getRegionId())
                    .withLatitude(property.getLatitude())
                    .withLongitude(property.getLongitude())
                    .withFlags(getFlags(property))
                    .withMainSummary(property.getMainSummary())
                    .withFullDescription(property.getFullDescription())
                    .withImages(getImages(property))
                    .withFloorplans(getFloorplans(property))
                    .withBrochures(getBrochures(property))
                    .withVirtualTours(getVirtualTours(property))
                    .withEpcGraphs(getEpcGraphs(property))
                    .withEpcFrontPages(getEpcFrontPages(property))
                    .withExternalLinks(getExternalLinks(property))
                    .withPropertyBedrooms(property.getPropertyBedrooms())
                    .withPropertyEnsuites(property.getPropertyEnsuites())
                    .withPropertyBathrooms(property.getPropertyBathrooms())
                    .withPropertyReceptionRooms(property.getPropertyReceptionRooms())
                    .withPropertyKitchens(property.getPropertyKitchens())
                    .withPropertyAge(getPropertyAge(property))
                    .withFloorArea(property.getFloorArea())
                    .withFloorAreaUnit(getFloorAreaUnit(property))
                    .withDisplayPropertyType(property.getDisplayPropertyType())
                    .withPropertyType(getPropertyType(property))
                    .withPropertyStyle(getPropertyStyle(property))
                    .withAvailability(getAvailability(property))
                    .withRent(property.getRent())
                    .withRentFrequency(getRentFrequency(property))
                    .withIsLetPOA(property.getToLetPOA() == 1)
                    .withIsStudentProperty(property.getStudentProperty() == 1)
                    .withLettingFeePolicyHeadline(property.getLettingFeePolicyHeadline())
                    .withLettingFeePolicyDetails(property.getLettingFeePolicyDetails())
                    .build();
        }
        return null;
    }

    private static List<ExternalLink> getExternalLinks(final com.akross.gateway.property.entity.Property property) {
        return property.getExternalLinks().getExternalLink().stream().map(externalLink -> anExternalLink()
                .withModified(externalLink.getModified())
                .withUrl(externalLink.getUrl())
                .withDescription(externalLink.getDescription())
                .build())
                .collect(toList());
    }

    private static List<EpcFrontPage> getEpcFrontPages(final com.akross.gateway.property.entity.Property property) {
        return property.getEpcFrontPages().getEpcFrontPage().stream().map(epcFrontPage -> anEpcFrontPage()
                .withModified(epcFrontPage.getModified())
                .withUrl(epcFrontPage.getUrl())
                .build())
                .collect(toList());
    }

    private static List<EpcGraph> getEpcGraphs(final com.akross.gateway.property.entity.Property property) {
        return property.getEpcGraphs().getEpcGraph().stream().map(epcGraph -> anEpcGraph()
                .withModified(epcGraph.getModified())
                .withUrl(epcGraph.getUrl())
                .build())
                .collect(toList());
    }

    private static List<VirtualTour> getVirtualTours(final com.akross.gateway.property.entity.Property property) {
        return property.getVirtualTours().getVirtualTour().stream().map(virtualTour -> aVirtualTour()
                .withModified(virtualTour.getModified())
                .withUrl(virtualTour.getUrl())
                .build())
                .collect(toList());
    }

    private static List<Brochure> getBrochures(final com.akross.gateway.property.entity.Property property) {
        return property.getBrochures().getBrochure().stream().map(brochure -> aBrochure()
                .withModified(brochure.getModified())
                .withUrl(brochure.getUrl())
                .build())
                .collect(toList());
    }

    private static List<Floorplan> getFloorplans(final com.akross.gateway.property.entity.Property property) {
        return property.getFloorplans().getFloorPlan().stream().map(floorplan -> aFloorplan()
                .withModified(floorplan.getModified())
                .withUrl(floorplan.getUrl())
                .build())
                .collect(toList());
    }

    private static List<Image> getImages(final com.akross.gateway.property.entity.Property property) {
        return property.getImages().getImage().stream().map(image -> anImage()
                .withModified(image.getModified())
                .withUrl(image.getUrl())
                .build())
                .collect(toList());
    }

    private static RentFrequency getRentFrequency(final com.akross.gateway.property.entity.Property property) {
        return RentFrequency.getMap().get(property.getRentFrequency());
    }

    private static Availability getAvailability(final com.akross.gateway.property.entity.Property property) {
        return Availability.getMap().get(property.getAvailability());
    }

    private static PropertyStyle getPropertyStyle(final com.akross.gateway.property.entity.Property property) {
        return PropertyStyle.getMap().get(property.getPropertyStyle());
    }

    private static PropertyType getPropertyType(final com.akross.gateway.property.entity.Property property) {
        return PropertyType.getMap().get(property.getPropertyType());
    }

    private static FloorAreaUnit getFloorAreaUnit(final com.akross.gateway.property.entity.Property property) {
        return FloorAreaUnit.getMap().get(property.getFloorAreaUnits());
    }

    private static PropertyAge getPropertyAge(final com.akross.gateway.property.entity.Property property) {
        return getMap().get(property.getPropertyAge());
    }

    private static List<String> getFlags(final com.akross.gateway.property.entity.Property property) {
        return property.getFlags().getFlag().stream()
                .map(Flag::getFlag)
                .collect(toList());
    }
}