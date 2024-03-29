package com.akross.web.property;

import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.service.PropertyService;
import com.akross.web.property.enitity.*;
import com.akross.web.property.enitity.container.Property;
import com.akross.web.property.exception.InvalidPropertyTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

import static com.akross.domain.property.residentialsalesandletting.PropertyType.*;
import static com.akross.web.property.enitity.Brochure.BrochureBuilder.aBrochure;
import static com.akross.web.property.enitity.EpcFrontPage.EpcFrontPageBuilder.anEpcFrontPage;
import static com.akross.web.property.enitity.EpcGraph.EpcGraphBuilder.anEpcGraph;
import static com.akross.web.property.enitity.ExternalLink.ExternalLinkBuilder.anExternalLink;
import static com.akross.web.property.enitity.Floorplan.FloorplanBuilder.aFloorplan;
import static com.akross.web.property.enitity.Image.ImageBuilder.anImage;
import static com.akross.web.property.enitity.VirtualTour.VirtualTourBuilder.aVirtualTour;
import static com.akross.web.property.enitity.container.Property.PropertyBuilder.aProperty;
import static com.akross.web.property.enitity.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    private static List<com.akross.web.property.enitity.residentialsalesandletting.residentialletting
            .ResidentialLetting> getResidentialLettings(final List<ResidentialLetting> residentialLettings) {
        return residentialLettings.parallelStream()
                .map(getResidentialLettingResidentialLettingFunction())
                .collect(toList());
    }

    private static com.akross.web.property.enitity.residentialsalesandletting.residentialletting
            .ResidentialLetting getResidentialLetting(final ResidentialLetting residentialLetting) {
        return getResidentialLettingResidentialLettingFunction().apply(residentialLetting);
    }

    private static Function<ResidentialLetting, com.akross.web.property.enitity.residentialsalesandletting
            .residentialletting.ResidentialLetting> getResidentialLettingResidentialLettingFunction() {
        return residentialLetting -> aResidentialLetting()
                .withPropertyId(residentialLetting.getPropertyId())
                .withBranchId(residentialLetting.getBranchId())
                .withClientName(residentialLetting.getClientName())
                .withBranchName(residentialLetting.getBranchName())
                .withDepartment(residentialLetting.getDepartment())
                .withReferenceNumber(residentialLetting.getReferenceNumber())
                .withAddressName(residentialLetting.getAddressName())
                .withAddressNumber(residentialLetting.getAddressNumber())
                .withAddressStreet(residentialLetting.getAddressStreet())
                .withAddress2(residentialLetting.getAddress2())
                .withAddress3(residentialLetting.getAddress3())
                .withAddress4(residentialLetting.getAddress4())
                .withAddressPostcode(residentialLetting.getAddressPostcode())
                .withCountry(residentialLetting.getCountry())
                .withDisplayAddress(residentialLetting.getDisplayAddress())
                .withPropertyFeature1(residentialLetting.getPropertyFeature1())
                .withPropertyFeature2(residentialLetting.getPropertyFeature2())
                .withPropertyFeature3(residentialLetting.getPropertyFeature3())
                .withPropertyFeature4(residentialLetting.getPropertyFeature4())
                .withPropertyFeature5(residentialLetting.getPropertyFeature5())
                .withPropertyFeature6(residentialLetting.getPropertyFeature6())
                .withPropertyFeature7(residentialLetting.getPropertyFeature7())
                .withPropertyFeature8(residentialLetting.getPropertyFeature8())
                .withPropertyFeature9(residentialLetting.getPropertyFeature9())
                .withPropertyFeature10(residentialLetting.getPropertyFeature10())
                .withDateLastModified(residentialLetting.getDateLastModified())
                .withTimeLastModified(residentialLetting.getTimeLastModified())
                .withIsFeaturedProperty(residentialLetting.isFeaturedProperty())
                .withRegionId(residentialLetting.getRegionId())
                .withLatitude(residentialLetting.getLatitude())
                .withLongitude(residentialLetting.getLongitude())
                .withFlags(residentialLetting.getFlags())
                .withMainSummary(residentialLetting.getMainSummary())
                .withFullDescription(residentialLetting.getFullDescription())
                .withImages(getImages(residentialLetting.getImages()))
                .withFloorplans(getFloorplans(residentialLetting))
                .withBrochures(getBrochures(residentialLetting.getBrochures()))
                .withVirtualTours(getVirtualTours(residentialLetting.getVirtualTours()))
                .withEpcGraphs(getEpcGraphs(residentialLetting.getEpcGraphs()))
                .withEpcFrontPages(getEpcFrontPages(residentialLetting.getEpcFrontPages()))
                .withExternalLinks(getExternalLinks(residentialLetting.getExternalLinks()))
                .withPropertyBedrooms(residentialLetting.getPropertyBedrooms())
                .withPropertyEnsuites(residentialLetting.getPropertyEnsuites())
                .withPropertyBathrooms(residentialLetting.getPropertyBathrooms())
                .withPropertyReceptionRooms(residentialLetting.getPropertyReceptionRooms())
                .withPropertyKitchens(residentialLetting.getPropertyKitchens())
                .withPropertyAge(residentialLetting.getPropertyAge())
                .withFloorArea(residentialLetting.getFloorArea())
                .withFloorAreaUnit(residentialLetting.getFloorAreaUnit())
                .withDisplayPropertyType(residentialLetting.getDisplayPropertyType())
                .withPropertyType(residentialLetting.getPropertyType())
                .withPropertyStyle(residentialLetting.getPropertyStyle())
                .withAvailability(residentialLetting.getAvailability())
                .withRent(residentialLetting.getRent())
                .withRentFrequency(residentialLetting.getRentFrequency())
                .withIsLetPOA(residentialLetting.isLetPOA())
                .withIsStudentProperty(residentialLetting.isStudentProperty())
                .withLettingFeePolicyHeadline(residentialLetting.getLettingFeePolicyHeadline())
                .withLettingFeePolicyDetails(residentialLetting.getLettingFeePolicyDetails())
                .build();
    }

    private static List<Image> getImages(final List<com.akross.domain.property.Image> images) {
        return images.stream()
                .map(image -> anImage()
                        .withUrl(image.getUrl())
                        .withModified(image.getModified())
                        .build())
                .collect(toList());
    }

    private static List<Floorplan> getFloorplans(final ResidentialLetting residentialLetting) {
        return residentialLetting.getFloorplans().stream()
                .map(floorplan -> aFloorplan()
                        .withUrl(floorplan.getUrl())
                        .withModified(floorplan.getModified())
                        .build())
                .collect(toList());
    }

    private static List<Brochure> getBrochures(final List<com.akross.domain.property.Brochure> brochures) {
        return brochures.stream()
                .map(brochure -> aBrochure()
                        .withUrl(brochure.getUrl())
                        .withModified(brochure.getModified())
                        .build())
                .collect(toList());
    }

    private static List<VirtualTour> getVirtualTours(final List<com.akross.domain.property.VirtualTour> virtualTours) {
        return virtualTours.stream()
                .map(virtualTour -> aVirtualTour()
                        .withUrl(virtualTour.getUrl())
                        .withModified(virtualTour.getModified())
                        .build())
                .collect(toList());
    }

    private static List<EpcGraph> getEpcGraphs(final List<com.akross.domain.property.EpcGraph> epcGraphs) {
        return epcGraphs.stream()
                .map(epcGraph -> anEpcGraph()
                        .withUrl(epcGraph.getUrl())
                        .withModified(epcGraph.getModified())
                        .build())
                .collect(toList());
    }

    private static List<EpcFrontPage> getEpcFrontPages(final List<com.akross.domain.property.EpcFrontPage> epcFrontPages) {
        return epcFrontPages.stream()
                .map(epcFrontPage -> anEpcFrontPage()
                        .withUrl(epcFrontPage.getUrl())
                        .withModified(epcFrontPage.getModified())
                        .build())
                .collect(toList());
    }

    private static List<ExternalLink> getExternalLinks(final List<com.akross.domain.property.ExternalLink> externalLinks) {
        return externalLinks.stream()
                .map(externalLink -> anExternalLink()
                        .withUrl(externalLink.getUrl())
                        .withDescription(externalLink.getDescription())
                        .withModified(externalLink.getModified())
                        .build())
                .collect(toList());
    }

    private static List<PropertyType> getPropertyTypes(final String propertyType) {
        if ("House".equals(propertyType)) {
            return unmodifiableList(asList(HOUSE, BUNGALOWS));
        }
        if ("Flat".equals(propertyType)) {
            return singletonList(FLAT_APARTMENTS);
        }
        throw new InvalidPropertyTypeException(propertyType);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(path = {"/{propertyId}"}, method = GET, produces = {APPLICATION_JSON_VALUE})
    public <T extends com.akross.web.property.enitity.Property> T getProperty(
            @PathVariable(value = "propertyId") final Long propertyId) {
        final com.akross.domain.property.Property property = propertyService.getProperty(propertyId);
        if (property instanceof ResidentialLetting) {
            return (T) getResidentialLetting((ResidentialLetting) property);
        }
        return null;
    }

    @RequestMapping(method = GET, produces = {APPLICATION_JSON_VALUE}, params = {"featured"})
    public Property getPropertiesViaFeaturedFlag(@RequestParam(value = "featured") final Boolean featured) {
        final com.akross.domain.property.container.Property properties = propertyService.getProperties(featured);
        return aProperty()
                .withResidentialLettings(getResidentialLettings(properties.getResidentialLettings()))
                .build();
    }

    @RequestMapping(method = GET, produces = {APPLICATION_JSON_VALUE})
    public Property getProperties() {
        final com.akross.domain.property.container.Property properties = propertyService.getProperties();
        return aProperty()
                .withResidentialLettings(getResidentialLettings(properties.getResidentialLettings()))
                .build();
    }

    @RequestMapping(method = GET, produces = {APPLICATION_JSON_VALUE}
            , params = {"location", "minimumPrice", "maximumPrice", "propertyType", "bedroomAmount"})
    public Property getSearchedProperties(@RequestParam(value = "location") final String location
            , @RequestParam(value = "minimumPrice") final BigDecimal minimumPrice
            , @RequestParam(value = "maximumPrice") final BigDecimal maximumPrice
            , @RequestParam(value = "propertyType") final String propertyType
            , @RequestParam(value = "bedroomAmount") final Integer bedroomAmount) {
        final com.akross.domain.property.container.Property propertiesBySearchCriteria = propertyService
                .getPropertiesBySearchCriteria(location, minimumPrice, maximumPrice, getPropertyTypes(propertyType)
                        , bedroomAmount);
        return aProperty()
                .withResidentialLettings(getResidentialLettings(propertiesBySearchCriteria.getResidentialLettings()))
                .build();
    }
}