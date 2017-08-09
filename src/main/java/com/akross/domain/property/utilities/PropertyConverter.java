package com.akross.domain.property.utilities;


import com.akross.domain.property.*;
import com.akross.domain.property.residentialsalesandletting.FloorAreaUnit;
import com.akross.domain.property.residentialsalesandletting.PropertyAge;
import com.akross.domain.property.residentialsalesandletting.PropertyStyle;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.Availability;
import com.akross.domain.property.residentialsalesandletting.residentialletting.RentFrequency;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.gateway.property.entity.Flag;

import java.util.List;
import java.util.Set;

import static com.akross.domain.property.Brochure.BrochureBuilder.aBrochure;
import static com.akross.domain.property.Department.LETTINGS;
import static com.akross.domain.property.EpcFrontPage.EpcFrontPageBuilder.anEpcFrontPage;
import static com.akross.domain.property.EpcGraph.EpcGraphBuilder.anEpcGraph;
import static com.akross.domain.property.ExternalLink.ExternalLinkBuilder.anExternalLink;
import static com.akross.domain.property.Floorplan.FloorplanBuilder.aFloorplan;
import static com.akross.domain.property.Image.ImageBuilder.anImage;
import static com.akross.domain.property.VirtualTour.VirtualTourBuilder.aVirtualTour;
import static com.akross.domain.property.residentialsalesandletting.PropertyAge.getMap;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.util.stream.Collectors.toList;

public class PropertyConverter {
    private static List<ExternalLink> getExternalLinks(final List<com.akross.gateway.property.entity.ExternalLink> externalLinks) {
        return externalLinks.stream().map(externalLink -> anExternalLink()
                .withModified(externalLink.getModified())
                .withUrl(externalLink.getUrl())
                .withDescription(externalLink.getDescription())
                .build())
                .collect(toList());
    }

    private static List<ExternalLink> getExternalLinks(final Set<com.akross.repository.property.entity.ExternalLink> externalLinks) {
        return externalLinks.stream().map(externalLink -> anExternalLink()
                .withModified(externalLink.getModified())
                .withUrl(externalLink.getUrl())
                .withDescription(externalLink.getDescription())
                .build())
                .collect(toList());
    }

    private static List<EpcFrontPage> getEpcFrontPages(final List<com.akross.gateway.property.entity.EpcFrontPage> epcFrontPages) {
        return epcFrontPages.stream().map(epcFrontPage -> anEpcFrontPage()
                .withModified(epcFrontPage.getModified())
                .withUrl(epcFrontPage.getUrl())
                .build())
                .collect(toList());
    }

    private static List<EpcFrontPage> getEpcFrontPages(final Set<com.akross.repository.property.entity.EpcFrontPage> epcFrontPages) {
        return epcFrontPages.stream().map(epcFrontPage -> anEpcFrontPage()
                .withModified(epcFrontPage.getModified())
                .withUrl(epcFrontPage.getUrl())
                .build())
                .collect(toList());
    }

    private static List<EpcGraph> getEpcGraphs(final List<com.akross.gateway.property.entity.EpcGraph> epcGraphs) {
        return epcGraphs.stream().map(epcGraph -> anEpcGraph()
                .withModified(epcGraph.getModified())
                .withUrl(epcGraph.getUrl())
                .build())
                .collect(toList());
    }

    private static List<EpcGraph> getEpcGraphs(final Set<com.akross.repository.property.entity.EpcGraph> epcGraphs) {
        return epcGraphs.stream().map(epcGraph -> anEpcGraph()
                .withModified(epcGraph.getModified())
                .withUrl(epcGraph.getUrl())
                .build())
                .collect(toList());
    }

    private static List<VirtualTour> getVirtualTours(final List<com.akross.gateway.property.entity.VirtualTour> virtualTours) {
        return virtualTours.stream().map(virtualTour -> aVirtualTour()
                .withModified(virtualTour.getModified())
                .withUrl(virtualTour.getUrl())
                .build())
                .collect(toList());
    }

    private static List<VirtualTour> getVirtualTours(final Set<com.akross.repository.property.entity.VirtualTour> virtualTours) {
        return virtualTours.stream().map(virtualTour -> aVirtualTour()
                .withModified(virtualTour.getModified())
                .withUrl(virtualTour.getUrl())
                .build())
                .collect(toList());
    }

    private static List<Brochure> getBrochures(final List<com.akross.gateway.property.entity.Brochure> brochures) {
        return brochures.stream().map(brochure -> aBrochure()
                .withModified(brochure.getModified())
                .withUrl(brochure.getUrl())
                .build())
                .collect(toList());
    }

    private static List<Brochure> getBrochures(final Set<com.akross.repository.property.entity.Brochure> brochures) {
        return brochures.stream().map(brochure -> aBrochure()
                .withModified(brochure.getModified())
                .withUrl(brochure.getUrl())
                .build())
                .collect(toList());
    }

    private static List<Floorplan> getFloorplans(final List<com.akross.gateway.property.entity.Floorplan> floorplans) {
        return floorplans.stream().map(floorplan -> aFloorplan()
                .withModified(floorplan.getModified())
                .withUrl(floorplan.getUrl())
                .build())
                .collect(toList());
    }

    private static List<Floorplan> getFloorplans(final Set<com.akross.repository.property.entity.Floorplan> floorplans) {
        return floorplans.stream().map(floorplan -> aFloorplan()
                .withModified(floorplan.getModified())
                .withUrl(floorplan.getUrl())
                .build())
                .collect(toList());
    }

    private static List<Image> getImages(final List<com.akross.gateway.property.entity.Image> images) {
        return images.stream().map(image -> anImage()
                .withModified(image.getModified())
                .withUrl(image.getUrl())
                .build())
                .collect(toList());
    }

    private static List<Image> getImages(final Set<com.akross.repository.property.entity.Image> images) {
        return images.stream().map(image -> anImage()
                .withModified(image.getModified())
                .withUrl(image.getUrl())
                .build())
                .collect(toList());
    }

    private static RentFrequency getRentFrequency(final Integer rentFrequency) {
        return RentFrequency.getMap().get(rentFrequency);
    }

    private static Availability getAvailability(final Integer availability) {
        return Availability.getMap().get(availability);
    }

    private static PropertyStyle getPropertyStyle(final Integer propertyStyle) {
        return PropertyStyle.getMap().get(propertyStyle);
    }

    private static PropertyType getPropertyType(final Integer propertyType) {
        return PropertyType.getMap().get(propertyType);
    }

    private static FloorAreaUnit getFloorAreaUnit(final String floorAreaUnit) {
        return FloorAreaUnit.getMap().get(floorAreaUnit);
    }

    private static PropertyAge getPropertyAge(final Integer propertyAge) {
        return getMap().get(propertyAge);
    }

    private static List<String> getFlags(final List<Flag> flags) {
        return flags.stream()
                .map(Flag::getFlag)
                .collect(toList());
    }

    public ResidentialLetting convertToResidentialLetting(final com.akross.gateway.property.entity.Property property) {
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
                .withFlags(getFlags(property.getFlags().getFlag()))
                .withMainSummary(property.getMainSummary())
                .withFullDescription(property.getFullDescription())
                .withImages(getImages(property.getImages().getImage()))
                .withFloorplans(getFloorplans(property.getFloorplans().getFloorPlan()))
                .withBrochures(getBrochures(property.getBrochures().getBrochure()))
                .withVirtualTours(getVirtualTours(property.getVirtualTours().getVirtualTour()))
                .withEpcGraphs(getEpcGraphs(property.getEpcGraphs().getEpcGraph()))
                .withEpcFrontPages(getEpcFrontPages(property.getEpcFrontPages().getEpcFrontPage()))
                .withExternalLinks(getExternalLinks(property.getExternalLinks().getExternalLink()))
                .withPropertyBedrooms(property.getPropertyBedrooms())
                .withPropertyEnsuites(property.getPropertyEnsuites())
                .withPropertyBathrooms(property.getPropertyBathrooms())
                .withPropertyReceptionRooms(property.getPropertyReceptionRooms())
                .withPropertyKitchens(property.getPropertyKitchens())
                .withPropertyAge(getPropertyAge(property.getPropertyAge()))
                .withFloorArea(property.getFloorArea())
                .withFloorAreaUnit(getFloorAreaUnit(property.getFloorAreaUnits()))
                .withDisplayPropertyType(property.getDisplayPropertyType())
                .withPropertyType(getPropertyType(property.getPropertyType()))
                .withPropertyStyle(getPropertyStyle(property.getPropertyStyle()))
                .withAvailability(getAvailability(property.getAvailability()))
                .withRent(property.getRent())
                .withRentFrequency(getRentFrequency(property.getRentFrequency()))
                .withIsLetPOA(property.getToLetPOA() == 1)
                .withIsStudentProperty(property.getStudentProperty() == 1)
                .withLettingFeePolicyHeadline(property.getLettingFeePolicyHeadline())
                .withLettingFeePolicyDetails(property.getLettingFeePolicyDetails())
                .build();
    }

    public ResidentialLetting convertToResidentialLetting(final com.akross.repository.property.entity
            .residentialsalesandletting.residentialletting
            .ResidentialLetting repositoryResidentialLetting) {
        return aResidentialLetting()
                .withPropertyId(repositoryResidentialLetting.getPropertyId())
                .withBranchId(repositoryResidentialLetting.getBranchId())
                .withClientName(repositoryResidentialLetting.getClientName())
                .withBranchName(repositoryResidentialLetting.getBranchName())
                .withDepartment(repositoryResidentialLetting.getDepartment())
                .withReferenceNumber(repositoryResidentialLetting.getReferenceNumber())
                .withAddressName(repositoryResidentialLetting.getAddressName())
                .withAddressNumber(repositoryResidentialLetting.getAddressNumber())
                .withAddressStreet(repositoryResidentialLetting.getAddressStreet())
                .withAddress2(repositoryResidentialLetting.getAddress2())
                .withAddress3(repositoryResidentialLetting.getAddress3())
                .withAddress4(repositoryResidentialLetting.getAddress4())
                .withAddressPostcode(repositoryResidentialLetting.getAddressPostcode())
                .withCountry(repositoryResidentialLetting.getCountry())
                .withDisplayAddress(repositoryResidentialLetting.getDisplayAddress())
                .withPropertyFeature1(repositoryResidentialLetting.getPropertyFeature1())
                .withPropertyFeature2(repositoryResidentialLetting.getPropertyFeature2())
                .withPropertyFeature3(repositoryResidentialLetting.getPropertyFeature3())
                .withPropertyFeature4(repositoryResidentialLetting.getPropertyFeature4())
                .withPropertyFeature5(repositoryResidentialLetting.getPropertyFeature5())
                .withPropertyFeature6(repositoryResidentialLetting.getPropertyFeature6())
                .withPropertyFeature7(repositoryResidentialLetting.getPropertyFeature7())
                .withPropertyFeature8(repositoryResidentialLetting.getPropertyFeature8())
                .withPropertyFeature9(repositoryResidentialLetting.getPropertyFeature9())
                .withPropertyFeature10(repositoryResidentialLetting.getPropertyFeature10())
                .withDateLastModified(repositoryResidentialLetting.getDateLastModified())
                .withTimeLastModified(repositoryResidentialLetting.getTimeLastModified())
                .withIsFeaturedProperty(repositoryResidentialLetting.isFeaturedProperty())
                .withRegionId(repositoryResidentialLetting.getRegionId())
                .withLatitude(repositoryResidentialLetting.getLatitude())
                .withLongitude(repositoryResidentialLetting.getLongitude())
                .withFlags(repositoryResidentialLetting.getFlags())
                .withMainSummary(repositoryResidentialLetting.getMainSummary())
                .withFullDescription(repositoryResidentialLetting.getFullDescription())
                .withImages(getImages(repositoryResidentialLetting.getImages()))
                .withFloorplans(getFloorplans(repositoryResidentialLetting.getFloorplans()))
                .withBrochures(getBrochures(repositoryResidentialLetting.getBrochures()))
                .withVirtualTours(getVirtualTours(repositoryResidentialLetting.getVirtualTours()))
                .withEpcGraphs(getEpcGraphs(repositoryResidentialLetting.getEpcGraphs()))
                .withEpcFrontPages(getEpcFrontPages(repositoryResidentialLetting.getEpcFrontPages()))
                .withExternalLinks(getExternalLinks(repositoryResidentialLetting.getExternalLinks()))
                .withPropertyBedrooms(repositoryResidentialLetting.getPropertyBedrooms())
                .withPropertyEnsuites(repositoryResidentialLetting.getPropertyEnsuites())
                .withPropertyBathrooms(repositoryResidentialLetting.getPropertyBathrooms())
                .withPropertyReceptionRooms(repositoryResidentialLetting.getPropertyReceptionRooms())
                .withPropertyKitchens(repositoryResidentialLetting.getPropertyKitchens())
                .withPropertyAge(repositoryResidentialLetting.getPropertyAge())
                .withFloorArea(repositoryResidentialLetting.getFloorArea())
                .withFloorAreaUnit(repositoryResidentialLetting.getFloorAreaUnit())
                .withDisplayPropertyType(repositoryResidentialLetting.getDisplayPropertyType())
                .withPropertyType(repositoryResidentialLetting.getPropertyType())
                .withPropertyStyle(repositoryResidentialLetting.getPropertyStyle())
                .withAvailability(repositoryResidentialLetting.getAvailability())
                .withRent(repositoryResidentialLetting.getRent())
                .withRentFrequency(repositoryResidentialLetting.getRentFrequency())
                .withIsLetPOA(repositoryResidentialLetting.isLetPOA())
                .withIsStudentProperty(repositoryResidentialLetting.isStudentProperty())
                .withLettingFeePolicyHeadline(repositoryResidentialLetting.getLettingFeePolicyHeadline())
                .withLettingFeePolicyDetails(repositoryResidentialLetting.getLettingFeePolicyDetails())
                .build();
    }
}