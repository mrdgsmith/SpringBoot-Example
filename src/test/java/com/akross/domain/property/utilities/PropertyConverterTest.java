package com.akross.domain.property.utilities;

import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder;
import com.akross.gateway.property.enitity.builders.entity.*;
import com.akross.gateway.property.entity.Property;
import com.akross.repository.property.entity.Brochure.BrochureBuilder;
import com.akross.repository.property.entity.EpcFrontPage.EpcFrontPageBuilder;
import com.akross.repository.property.entity.EpcGraph.EpcGraphBuilder;
import com.akross.repository.property.entity.ExternalLink.ExternalLinkBuilder;
import com.akross.repository.property.entity.Floorplan.FloorplanBuilder;
import com.akross.repository.property.entity.Image.ImageBuilder;
import com.akross.repository.property.entity.VirtualTour.VirtualTourBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalTime;
import java.util.stream.Stream;

import static com.akross.domain.property.Brochure.BrochureBuilder.aBrochure;
import static com.akross.domain.property.Department.LETTINGS;
import static com.akross.domain.property.EpcFrontPage.EpcFrontPageBuilder.anEpcFrontPage;
import static com.akross.domain.property.EpcGraph.EpcGraphBuilder.anEpcGraph;
import static com.akross.domain.property.ExternalLink.ExternalLinkBuilder.anExternalLink;
import static com.akross.domain.property.Floorplan.FloorplanBuilder.aFloorplan;
import static com.akross.domain.property.Image.ImageBuilder.anImage;
import static com.akross.domain.property.VirtualTour.VirtualTourBuilder.aVirtualTour;
import static com.akross.domain.property.residentialsalesandletting.FloorAreaUnit.HECTARES;
import static com.akross.domain.property.residentialsalesandletting.PropertyAge.TWENTIES_THIRTIES;
import static com.akross.domain.property.residentialsalesandletting.PropertyStyle.DETACHED_HOUSE;
import static com.akross.domain.property.residentialsalesandletting.PropertyType.BUNGALOWS;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.Availability.LET;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.Availability.REFERENCES_PENDING;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.RentFrequency.PW;
import static com.akross.gateway.property.enitity.builders.entity.TestPropertyBuilder.aProperty;
import static com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static java.time.LocalDateTime.of;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;

@RunWith(MockitoJUnitRunner.class)
public class PropertyConverterTest {

    @Rule
    public ExpectedException expectedException = none();

    @InjectMocks
    private PropertyConverter propertyConverter;

    private static com.akross.repository.property.entity.residentialsalesandletting.residentialletting
            .ResidentialLetting createRepositoryResidentialLetting() {
        return aResidentialLetting()
                .withPropertyId(64634L)
                .withBranchId(7)
                .withClientName("JUPIX")
                .withBranchName("Cambridge Office")
                .withDepartment(LETTINGS)
                .withReferenceNumber("45435")
                .withAddressName("Bla")
                .withAddressNumber("1")
                .withAddressStreet("The Street")
                .withAddress2("address2")
                .withAddress3("address3")
                .withAddress4("address4")
                .withAddressPostcode("postcode")
                .withCountry("United Kingdom")
                .withDisplayAddress("1 Greenhill Street, Evesham")
                .withPropertyFeature1("Bedroom with views over garden1")
                .withPropertyFeature2("Bedroom with views over garden2")
                .withPropertyFeature3("Bedroom with views over garden3")
                .withPropertyFeature4("Bedroom with views over garden4")
                .withPropertyFeature5("Bedroom with views over garden5")
                .withPropertyFeature6("Bedroom with views over garden6")
                .withPropertyFeature7("Bedroom with views over garden7")
                .withPropertyFeature8("Bedroom with views over garden8")
                .withPropertyFeature9("Bedroom with views over garden9")
                .withPropertyFeature10("Bedroom with views over garden10")
                .withDateLastModified(of(2016, 3, 1))
                .withTimeLastModified(LocalTime.of(22, 50, 34))
                .withIsFeaturedProperty(true)
                .withRegionId(38)
                .withLatitude(53.800651)
                .withLongitude(-4.064941)
                .withFlags(asList("flag1", "flag2"))
                .withMainSummary("mainSummary")
                .withFullDescription("fullDescription")
                .withPropertyBedrooms(5)
                .withPropertyBathrooms(3)
                .withPropertyEnsuites(6)
                .withPropertyReceptionRooms(3)
                .withPropertyKitchens(5)
                .withPropertyAge(TWENTIES_THIRTIES)
                .withFloorArea(190.0)
                .withFloorAreaUnit(HECTARES)
                .withDisplayPropertyType("Modern Detached House")
                .withPropertyType(BUNGALOWS)
                .withPropertyStyle(DETACHED_HOUSE)
                .withAvailability(LET)
                .withRent(valueOf(4534))
                .withRentFrequency(PW)
                .withIsLetPOA(false)
                .withIsStudentProperty(true)
                .withLettingFeePolicyHeadline("Fees Apply")
                .withLettingFeePolicyDetails("bla")
                .withImages(Stream.of(ImageBuilder.anImage()
                                .withUrl("url1")
                                .withModified(of(2005, 8, 11, 11, 44))
                                .build()
                        , ImageBuilder.anImage()
                                .withUrl("url2")
                                .withModified(of(2006, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withFloorplans(Stream.of(FloorplanBuilder.aFloorplan()
                                .withUrl("url3")
                                .withModified(of(2007, 1, 1, 2, 3))
                                .build()
                        , FloorplanBuilder.aFloorplan()
                                .withUrl("url4")
                                .withModified(of(2008, 1, 2, 3, 5))
                                .build()
                ).collect(toSet()))
                .withBrochures(Stream.of(BrochureBuilder.aBrochure()
                                .withUrl("url5")
                                .withModified(of(2009, 8, 11, 11, 44))
                                .build()
                        , BrochureBuilder.aBrochure()
                                .withUrl("url6")
                                .withModified(of(2010, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withVirtualTours(Stream.of(VirtualTourBuilder.aVirtualTour()
                                .withUrl("url7")
                                .withModified(of(2011, 8, 11, 11, 44))
                                .build()
                        , VirtualTourBuilder.aVirtualTour()
                                .withUrl("url8")
                                .withModified(of(2012, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withEpcGraphs(Stream.of(EpcGraphBuilder.anEpcGraph()
                                .withUrl("url9")
                                .withModified(of(2013, 8, 11, 11, 44))
                                .build()
                        , EpcGraphBuilder.anEpcGraph()
                                .withUrl("url10")
                                .withModified(of(2014, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withEpcFrontPages(Stream.of(EpcFrontPageBuilder.anEpcFrontPage()
                                .withUrl("url11")
                                .withModified(of(2016, 8, 11, 11, 44))
                                .build()
                        , EpcFrontPageBuilder.anEpcFrontPage()
                                .withUrl("url12")
                                .withModified(of(2017, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withExternalLinks(Stream.of(ExternalLinkBuilder.anExternalLink()
                                .withUrl("url12")
                                .withModified(of(2018, 8, 11, 11, 44))
                                .withDescription("a")
                                .build()
                        , ExternalLinkBuilder.anExternalLink()
                                .withUrl("url13")
                                .withModified(of(2019, 5, 9, 12, 44))
                                .withDescription("b")
                                .build()
                ).collect(toSet()))
                .build();
    }

    @Test
    public void shouldConvertGatewayPropertyToRepositoryProperty() {
        Property property = aProperty()
                .withPropertyId(64634L)
                .withBranchId(7)
                .withClientName("JUPIX")
                .withBranchName("Cambridge Office")
                .withDepartment("Lettings")
                .withReferenceNumber("45435")
                .withAddressName("Bla")
                .withAddressNumber("1")
                .withAddressStreet("The Street")
                .withAddress2("address2")
                .withAddress3("address3")
                .withAddress4("address4")
                .withAddressPostcode("postcode")
                .withCountry("United Kingdom")
                .withDisplayAddress("1 Greenhill Street, Evesham")
                .withPropertyFeature1("Bedroom with views over garden1")
                .withPropertyFeature2("Bedroom with views over garden2")
                .withPropertyFeature3("Bedroom with views over garden3")
                .withPropertyFeature4("Bedroom with views over garden4")
                .withPropertyFeature5("Bedroom with views over garden5")
                .withPropertyFeature6("Bedroom with views over garden6")
                .withPropertyFeature7("Bedroom with views over garden7")
                .withPropertyFeature8("Bedroom with views over garden8")
                .withPropertyFeature9("Bedroom with views over garden9")
                .withPropertyFeature10("Bedroom with views over garden10")
                .withDateLastModified(of(2016, 3, 1))
                .withTimeLastModified(LocalTime.of(22, 50, 34))
                .withFeaturedProperty(1)
                .withRegionId(38)
                .withLatitude(53.800651)
                .withLongitude(-4.064941)
                .withFlags(asList("flag1", "flag2"))
                .withMainSummary("mainSummary")
                .withFullDescription("fullDescription")
                .withImages(asList(TestImageBuilder.anImage()
                                .withUrl("url1")
                                .withModified(of(2014, 8, 11, 11, 44))
                                .build()
                        , TestImageBuilder.anImage()
                                .withUrl("url2")
                                .withModified(of(2015, 8, 11, 11, 44))
                                .build()))
                .withFloorplans(asList(
                        (TestFloorplanBuilder.anFloorplan()
                                .withUrl("url1")
                                .withModified(of(2014, 8, 11, 11, 44))
                                .build())
                        , TestFloorplanBuilder.anFloorplan()
                                .withUrl("url2")
                                .withModified(of(2015, 8, 11, 11, 44))
                                .build()))
                .withBrochures((asList(TestBrochureBuilder.anBrochure()
                                .withUrl("url1")
                                .withModified(of(2014, 8, 11, 11, 44))
                                .build()
                        , TestBrochureBuilder.anBrochure()
                                .withUrl("url2")
                                .withModified(of(2015, 8, 11, 11, 44))
                                .build())))
                .withVirtualTours(asList(TestVirtualTourBuilder.anVirtualTour()
                                .withUrl("url1")
                                .withModified(of(2014, 8, 11, 11, 44))
                                .build()
                        , TestVirtualTourBuilder.anVirtualTour()
                                .withUrl("url2")
                                .withModified(of(2015, 8, 11, 11, 44))
                                .build()))
                .withEpcGraphs(asList(TestEpcGraphBuilder.anEpcGraph()
                                .withUrl("url1")
                                .withModified(of(2014, 8, 11, 11, 44))
                                .build()
                        , TestEpcGraphBuilder.anEpcGraph()
                                .withUrl("url2")
                                .withModified(of(2015, 8, 11, 11, 44))
                                .build()))
                .withEpcFrontPages(asList(TestEpcFrontPageBuilder.anEpcFrontPage()
                                .withUrl("url1")
                                .withModified(of(2014, 8, 11, 11, 44))
                                .build()
                        , TestEpcFrontPageBuilder.anEpcFrontPage()
                                .withUrl("url2")
                                .withModified(of(2015, 8, 11, 11, 44))
                                .build()))
                .withExternalLinks(asList(TestExternalLinkBuilder.anExternalLink()
                                .withUrl("url1")
                                .withModified(of(2014, 8, 11, 11, 44))
                                .withDescription("a")
                                .build()
                        , TestExternalLinkBuilder.anExternalLink()
                                .withUrl("url2")
                                .withModified(of(2015, 8, 11, 11, 44))
                                .withDescription("b")
                                .build()))
                .withPropertyBedrooms(5)
                .withPropertyBathrooms(3)
                .withPropertyEnsuites(6)
                .withPropertyReceptionRooms(3)
                .withPropertyKitchens(5)
                .withPropertyAge(6)
                .withFloorArea(190.0)
                .withFloorAreaUnits("hectares")
                .withDisplayPropertyType("Modern Detached House")
                .withPropertyType(3)
                .withPropertyStyle(4)
                .withAvailability(3)
                .withRent(valueOf(4534))
                .withRentFrequency(2)
                .withToLetPOA(0)
                .withStudentProperty(1)
                .withLettingFeePolicyHeadline("Fees Apply")
                .withLettingFeePolicyDetails("bla")
                .build();

        final com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting
                actualResidentialLetting =
                (com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting)
                        propertyConverter.convertToResidentialLetting(property);

        assertThat(actualResidentialLetting,
                instanceOf(com.akross.repository.property.entity.residentialsalesandletting.residentialletting
                        .ResidentialLetting.class));
        assertThat(actualResidentialLetting.getPropertyId(), is(64634L));
        assertThat(actualResidentialLetting.getBranchId(), is(7));
        assertThat(actualResidentialLetting.getClientName(), is("JUPIX"));
        assertThat(actualResidentialLetting.getBranchName(), is("Cambridge Office"));
        assertThat(actualResidentialLetting.getDepartment(), is(LETTINGS));
        assertThat(actualResidentialLetting.getReferenceNumber(), is("45435"));
        assertThat(actualResidentialLetting.getAddressName(), is("Bla"));
        assertThat(actualResidentialLetting.getAddressNumber(), is("1"));
        assertThat(actualResidentialLetting.getAddressStreet(), is("The Street"));
        assertThat(actualResidentialLetting.getAddress2(), is("address2"));
        assertThat(actualResidentialLetting.getAddress3(), is("address3"));
        assertThat(actualResidentialLetting.getAddress4(), is("address4"));
        assertThat(actualResidentialLetting.getAddressPostcode(), is("postcode"));
        assertThat(actualResidentialLetting.getCountry(), is("United Kingdom"));
        assertThat(actualResidentialLetting.getDisplayAddress(), is("1 Greenhill Street, Evesham"));
        assertThat(actualResidentialLetting.getPropertyFeature1(), is("Bedroom with views over garden1"));
        assertThat(actualResidentialLetting.getPropertyFeature2(), is("Bedroom with views over garden2"));
        assertThat(actualResidentialLetting.getPropertyFeature3(), is("Bedroom with views over garden3"));
        assertThat(actualResidentialLetting.getPropertyFeature4(), is("Bedroom with views over garden4"));
        assertThat(actualResidentialLetting.getPropertyFeature5(), is("Bedroom with views over garden5"));
        assertThat(actualResidentialLetting.getPropertyFeature6(), is("Bedroom with views over garden6"));
        assertThat(actualResidentialLetting.getPropertyFeature7(), is("Bedroom with views over garden7"));
        assertThat(actualResidentialLetting.getPropertyFeature8(), is("Bedroom with views over garden8"));
        assertThat(actualResidentialLetting.getPropertyFeature9(), is("Bedroom with views over garden9"));
        assertThat(actualResidentialLetting.getPropertyFeature10(), is("Bedroom with views over garden10"));
        assertThat(actualResidentialLetting.getDateLastModified(), is(of(2016, 3, 1)));
        assertThat(actualResidentialLetting.getTimeLastModified(), is(LocalTime.of(22, 50, 34)));
        assertThat(actualResidentialLetting.isFeaturedProperty(), is(true));
        assertThat(actualResidentialLetting.getRegionId(), is(38));
        assertThat(actualResidentialLetting.getLatitude(), is(53.800651));
        assertThat(actualResidentialLetting.getLongitude(), is(-4.064941));
        assertThat(actualResidentialLetting.getFlags(), hasItems("flag1", "flag2"));
        assertThat(actualResidentialLetting.getMainSummary(), is("mainSummary"));
        assertThat(actualResidentialLetting.getFullDescription(), is("fullDescription"));
        assertThat(actualResidentialLetting.getPropertyBedrooms(), is(5));
        assertThat(actualResidentialLetting.getPropertyBathrooms(), is(3));
        assertThat(actualResidentialLetting.getPropertyEnsuites(), is(6));
        assertThat(actualResidentialLetting.getPropertyReceptionRooms(), is(3));
        assertThat(actualResidentialLetting.getPropertyKitchens(), is(5));
        assertThat(actualResidentialLetting.getPropertyAge(), is(TWENTIES_THIRTIES));
        assertThat(actualResidentialLetting.getFloorArea(), is(190.0));
        assertThat(actualResidentialLetting.getFloorAreaUnit(), is(HECTARES));
        assertThat(actualResidentialLetting.getDisplayPropertyType(), is("Modern Detached House"));
        assertThat(actualResidentialLetting.getPropertyType(), is(BUNGALOWS));
        assertThat(actualResidentialLetting.getPropertyStyle(), is(DETACHED_HOUSE));
        assertThat(actualResidentialLetting.getAvailability(), is(REFERENCES_PENDING));
        assertThat(actualResidentialLetting.getRent(), is(valueOf(4534)));
        assertThat(actualResidentialLetting.getRentFrequency(), is(PW));
        assertThat(actualResidentialLetting.isLetPOA(), is(false));
        assertThat(actualResidentialLetting.isStudentProperty(), is(true));
        assertThat(actualResidentialLetting.getLettingFeePolicyHeadline(), is("Fees Apply"));
        assertThat(actualResidentialLetting.getLettingFeePolicyDetails(), is("bla"));
        assertThat(actualResidentialLetting.getImages(), contains(ImageBuilder.anImage()
                        .withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , ImageBuilder.anImage()
                        .withUrl("url2")
                        .withModified(of(2015, 8, 11, 11, 44))
                        .build()));
        assertThat(actualResidentialLetting.getFloorplans(), contains(FloorplanBuilder.aFloorplan()
                        .withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , FloorplanBuilder.aFloorplan()
                        .withUrl("url2")
                        .withModified(of(2015, 8, 11, 11, 44))
                        .build()));
        assertThat(actualResidentialLetting.getBrochures(), contains(BrochureBuilder.aBrochure()
                        .withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , BrochureBuilder.aBrochure()
                        .withUrl("url2")
                        .withModified(of(2015, 8, 11, 11, 44))
                        .build()));
        assertThat(actualResidentialLetting.getVirtualTours(), contains(VirtualTourBuilder.aVirtualTour()
                        .withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , VirtualTourBuilder.aVirtualTour()
                        .withUrl("url2")
                        .withModified(of(2015, 8, 11, 11, 44))
                        .build()));
        assertThat(actualResidentialLetting.getEpcGraphs(), contains(EpcGraphBuilder.anEpcGraph()
                        .withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , EpcGraphBuilder.anEpcGraph()
                        .withUrl("url2")
                        .withModified(of(2015, 8, 11, 11, 44))
                        .build()));
        assertThat(actualResidentialLetting.getEpcFrontPages(), contains(EpcFrontPageBuilder.anEpcFrontPage()
                        .withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , EpcFrontPageBuilder.anEpcFrontPage()
                        .withUrl("url2")
                        .withModified(of(2015, 8, 11, 11, 44))
                        .build()));
        assertThat(actualResidentialLetting.getExternalLinks(), contains(ExternalLinkBuilder.anExternalLink()
                        .withUrl("url2")
                        .withModified(of(2015, 8, 11, 11, 44))
                        .withDescription("b")
                        .build()
                , ExternalLinkBuilder.anExternalLink()
                        .withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .withDescription("a")
                        .build()));
    }

    @Test
    public void shouldConvertRepositoryResidentialLettingToDomainResidentialLetting() {
        final ResidentialLetting actualResidentialLetting =
                propertyConverter.convertToResidentialLetting(createRepositoryResidentialLetting());

        assertThat(actualResidentialLetting, is(ResidentialLettingBuilder.aResidentialLetting()
                        .withPropertyId(64634L)
                        .withBranchId(7)
                        .withClientName("JUPIX")
                        .withBranchName("Cambridge Office")
                        .withDepartment(LETTINGS)
                        .withReferenceNumber("45435")
                        .withAddressName("Bla")
                        .withAddressNumber("1")
                        .withAddressStreet("The Street")
                        .withAddress2("address2")
                        .withAddress3("address3")
                        .withAddress4("address4")
                        .withAddressPostcode("postcode")
                        .withCountry("United Kingdom")
                        .withDisplayAddress("1 Greenhill Street, Evesham")
                        .withPropertyFeature1("Bedroom with views over garden1")
                        .withPropertyFeature2("Bedroom with views over garden2")
                        .withPropertyFeature3("Bedroom with views over garden3")
                        .withPropertyFeature4("Bedroom with views over garden4")
                        .withPropertyFeature5("Bedroom with views over garden5")
                        .withPropertyFeature6("Bedroom with views over garden6")
                        .withPropertyFeature7("Bedroom with views over garden7")
                        .withPropertyFeature8("Bedroom with views over garden8")
                        .withPropertyFeature9("Bedroom with views over garden9")
                        .withPropertyFeature10("Bedroom with views over garden10")
                        .withDateLastModified(of(2016, 3, 1))
                        .withTimeLastModified(LocalTime.of(22, 50, 34))
                        .withIsFeaturedProperty(true)
                        .withRegionId(38)
                        .withLatitude(53.800651)
                        .withLongitude(-4.064941)
                        .withFlags(asList("flag1", "flag2"))
                        .withMainSummary("mainSummary")
                        .withFullDescription("fullDescription")
                        .withPropertyBedrooms(5)
                        .withPropertyBathrooms(3)
                        .withPropertyEnsuites(6)
                        .withPropertyReceptionRooms(3)
                        .withPropertyKitchens(5)
                        .withPropertyAge(TWENTIES_THIRTIES)
                        .withFloorArea(190.0)
                        .withFloorAreaUnit(HECTARES)
                        .withDisplayPropertyType("Modern Detached House")
                        .withPropertyType(BUNGALOWS)
                        .withPropertyStyle(DETACHED_HOUSE)
                        .withAvailability(LET)
                        .withRent(valueOf(4534))
                        .withRentFrequency(PW)
                        .withIsLetPOA(false)
                        .withIsStudentProperty(true)
                        .withLettingFeePolicyHeadline("Fees Apply")
                        .withLettingFeePolicyDetails("bla")
                        .withImages(asList(anImage()
                                        .withUrl("url2")
                                        .withModified(of(2006, 5, 9, 12, 44))
                                        .build()
                                , anImage()
                                        .withUrl("url1")
                                        .withModified(of(2005, 8, 11, 11, 44))
                                        .build()
                        ))
                        .withFloorplans(asList(aFloorplan()
                                        .withUrl("url3")
                                        .withModified(of(2007, 1, 1, 2, 3))
                                        .build()
                                , aFloorplan()
                                        .withUrl("url4")
                                        .withModified(of(2008, 1, 2, 3, 5))
                                        .build()
                        ))
                        .withBrochures(asList(aBrochure()
                                        .withUrl("url5")
                                        .withModified(of(2009, 8, 11, 11, 44))
                                        .build()
                                , aBrochure()
                                        .withUrl("url6")
                                        .withModified(of(2010, 5, 9, 12, 44))
                                        .build()
                        ))
                        .withVirtualTours(asList(aVirtualTour()
                                        .withUrl("url7")
                                        .withModified(of(2011, 8, 11, 11, 44))
                                        .build()
                                , aVirtualTour()
                                        .withUrl("url8")
                                        .withModified(of(2012, 5, 9, 12, 44))
                                        .build()
                        ))
                        .withEpcGraphs(asList(anEpcGraph()
                                        .withUrl("url10")
                                        .withModified(of(2014, 5, 9, 12, 44))
                                        .build()
                                , anEpcGraph()
                                        .withUrl("url9")
                                        .withModified(of(2013, 8, 11, 11, 44))
                                        .build()
                        ))
                        .withEpcFrontPages(asList(anEpcFrontPage()
                                        .withUrl("url11")
                                        .withModified(of(2016, 8, 11, 11, 44))
                                        .build()
                                , anEpcFrontPage()
                                        .withUrl("url12")
                                        .withModified(of(2017, 5, 9, 12, 44))
                                        .build()
                        ))
                        .withExternalLinks(asList(anExternalLink()
                                        .withUrl("url13")
                                        .withModified(of(2019, 5, 9, 12, 44))
                                        .withDescription("b")
                                        .build()
                                , anExternalLink()
                                        .withUrl("url12")
                                        .withModified(of(2018, 8, 11, 11, 44))
                                        .withDescription("a")
                                        .build()
                        ))
                        .build()
                )
        );
    }
}