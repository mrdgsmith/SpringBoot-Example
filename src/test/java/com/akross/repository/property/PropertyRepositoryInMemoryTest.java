package com.akross.repository.property;

import com.akross.repository.PropertyRepositoryInMemory;
import com.akross.repository.property.entity.Property;
import com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.List;

import static com.akross.domain.property.Department.LETTINGS;
import static com.akross.domain.property.Department.SALES;
import static com.akross.domain.property.residentialsalesandletting.FloorAreaUnit.HECTARES;
import static com.akross.domain.property.residentialsalesandletting.PropertyAge.TWENTIES_THIRTIES;
import static com.akross.domain.property.residentialsalesandletting.PropertyStyle.DETACHED_HOUSE;
import static com.akross.domain.property.residentialsalesandletting.PropertyType.BUNGALOWS;
import static com.akross.domain.property.residentialsalesandletting.PropertyType.HOUSE;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.Availability.LET;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.Availability.WITHDRAWN;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.RentFrequency.PCM;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.RentFrequency.PW;
import static com.akross.repository.property.entity.Brochure.BrochureBuilder.aBrochure;
import static com.akross.repository.property.entity.EpcFrontPage.EpcFrontPageBuilder.anEpcFrontPage;
import static com.akross.repository.property.entity.EpcGraph.EpcGraphBuilder.anEpcGraph;
import static com.akross.repository.property.entity.ExternalLink.ExternalLinkBuilder.anExternalLink;
import static com.akross.repository.property.entity.Floorplan.FloorplanBuilder.aFloorplan;
import static com.akross.repository.property.entity.Image.ImageBuilder.anImage;
import static com.akross.repository.property.entity.VirtualTour.VirtualTourBuilder.aVirtualTour;
import static com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static java.time.LocalDateTime.of;
import static java.time.Month.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;

@RunWith(SpringRunner.class)
@AutoConfigureWebClient
@DataJpaTest
public class PropertyRepositoryInMemoryTest {

    @Rule
    public ExpectedException expectedException = none();

    @Autowired
    private PropertyRepositoryInMemory<Property> propertyRepositoryInMemory;

    private static List<ResidentialLetting> createValidFeaturedResidentialLettingProperties() {
        return asList(aResidentialLetting()
                        .withPropertyId(5L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo3")
                        .withMainSummary("mainSummary3")
                        .withAddress3("london")
                        .withPropertyType(HOUSE)
                        .withPropertyBedrooms(3)
                        .withRent(valueOf(3000))
                        .withPropertyBedrooms(3)
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 12))
                        .build()
                , aResidentialLetting()
                        .withPropertyId(4L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo2")
                        .withMainSummary("mainSummary2")
                        .withAddress3("London")
                        .withPropertyType(BUNGALOWS)
                        .withPropertyBedrooms(3)
                        .withRent(valueOf(2000))
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 13))
                        .build()
                , aResidentialLetting()
                        .withPropertyId(3L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo4")
                        .withMainSummary("mainSummary4")
                        .withRent(valueOf(4000))
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 10))
                        .build()
                , aResidentialLetting()
                        .withPropertyId(2L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo1")
                        .withMainSummary("mainSummary1")
                        .withRent(valueOf(1000))
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
        );
    }

    private static List<ResidentialLetting> createResidentialLettingProperties() {
        return concat(of(aResidentialLetting()
                        .withPropertyId(12L)
                        .withDepartment(SALES)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withIsLetPOA(true)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
                        .withPropertyId(13L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(false)
                        .withAvailability(LET)
                        .withIsLetPOA(true)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, SEPTEMBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
                        .withPropertyId(14L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withIsLetPOA(true)
                        .withAvailability(WITHDRAWN)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, NOVEMBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()), createValidFeaturedResidentialLettingProperties().stream())
                .collect(toList());
    }

    private static List<ResidentialLetting> createInvalidFeaturedResidentialLettingProperties() {
        return asList(aResidentialLetting()
                        .withPropertyId(100L)
                        .withDepartment(SALES)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
                        .withPropertyId(101L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(false)
                        .withAvailability(LET)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, SEPTEMBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
                        .withPropertyId(102L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(WITHDRAWN)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, NOVEMBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build());
    }

    @Test
    public void shouldSaveAndReadAllFields() {
        final ResidentialLetting residentialLetting = aResidentialLetting()
                .withPropertyId(64634L)
                .withBranchId(7)
                .withClientName("JUPIX")
                .withBranchName("Cambridge Office")
                .withDepartment(LETTINGS)
                .withReferenceNumber("45435")
                .withAddressName("Bla")
                .withAddressNumber(1)
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
                .withImages(of(anImage()
                                .withUrl("url1")
                                .withModified(of(2005, 8, 11, 11, 44))
                                .build()
                        , anImage()
                                .withUrl("url2")
                                .withModified(of(2006, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withFloorplans(of(aFloorplan()
                                .withUrl("url3")
                                .withModified(of(2007, 1, 1, 2, 3))
                                .build()
                        , aFloorplan()
                                .withUrl("url4")
                                .withModified(of(2008, 1, 2, 3, 5))
                                .build()
                ).collect(toSet()))
                .withBrochures(of(aBrochure()
                                .withUrl("url5")
                                .withModified(of(2009, 8, 11, 11, 44))
                                .build()
                        , aBrochure()
                                .withUrl("url6")
                                .withModified(of(2010, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withVirtualTours(of(aVirtualTour()
                                .withUrl("url7")
                                .withModified(of(2011, 8, 11, 11, 44))
                                .build()
                        , aVirtualTour()
                                .withUrl("url8")
                                .withModified(of(2012, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withEpcGraphs(of(anEpcGraph()
                                .withUrl("url9")
                                .withModified(of(2013, 8, 11, 11, 44))
                                .build()
                        , anEpcGraph()
                                .withUrl("url10")
                                .withModified(of(2014, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withEpcFrontPages(of(anEpcFrontPage()
                                .withUrl("url11")
                                .withModified(of(2016, 8, 11, 11, 44))
                                .build()
                        , anEpcFrontPage()
                                .withUrl("url12")
                                .withModified(of(2017, 5, 9, 12, 44))
                                .build()
                ).collect(toSet()))
                .withExternalLinks(of(anExternalLink()
                                .withUrl("url12")
                                .withModified(of(2018, 8, 11, 11, 44))
                                .withDescription("a")
                                .build()
                        , anExternalLink()
                                .withUrl("url13")
                                .withModified(of(2019, 5, 9, 12, 44))
                                .withDescription("b")
                                .build()
                ).collect(toSet()))
                .build();

        propertyRepositoryInMemory.save(residentialLetting);

        final ResidentialLetting actualResidentialLetting = (ResidentialLetting) propertyRepositoryInMemory
                .findOne(64634L);
        assertThat(actualResidentialLetting.getPropertyId(), is(64634L));
        assertThat(actualResidentialLetting.getBranchId(), is(7));
        assertThat(actualResidentialLetting.getClientName(), is("JUPIX"));
        assertThat(actualResidentialLetting.getBranchName(), is("Cambridge Office"));
        assertThat(actualResidentialLetting.getDepartment(), is(LETTINGS));
        assertThat(actualResidentialLetting.getReferenceNumber(), is("45435"));
        assertThat(actualResidentialLetting.getAddressName(), is("Bla"));
        assertThat(actualResidentialLetting.getAddressNumber(), is(1));
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
        assertThat(actualResidentialLetting.getAvailability(), is(LET));
        assertThat(actualResidentialLetting.getRent(), is(valueOf(4534)));
        assertThat(actualResidentialLetting.getRentFrequency(), is(PW));
        assertThat(actualResidentialLetting.isLetPOA(), is(false));
        assertThat(actualResidentialLetting.isStudentProperty(), is(true));
        assertThat(actualResidentialLetting.getLettingFeePolicyHeadline(), is("Fees Apply"));
        assertThat(actualResidentialLetting.getLettingFeePolicyDetails(), is("bla"));

        assertThat(actualResidentialLetting.getImages(), hasItems(anImage()
                        .withUrl("url1")
                        .withId(2L)
                        .withModified(of(2005, 8, 11, 11, 44))
                        .build()
                , anImage()
                        .withUrl("url2")
                        .withId(1L)
                        .withModified(of(2006, 5, 9, 12, 44))
                        .build())
        );

        assertThat(actualResidentialLetting.getFloorplans(), hasItems(aFloorplan()
                        .withUrl("url3")
                        .withId(1L)
                        .withModified(of(2007, 1, 1, 2, 3))
                        .build()
                , aFloorplan()
                        .withUrl("url4")
                        .withId(2L)
                        .withModified(of(2008, 1, 2, 3, 5))
                        .build())
        );

        assertThat(actualResidentialLetting.getBrochures(), hasItems(aBrochure()
                        .withUrl("url5")
                        .withId(1L)
                        .withModified(of(2009, 8, 11, 11, 44))
                        .build()
                , aBrochure()
                        .withUrl("url6")
                        .withId(2L)
                        .withModified(of(2010, 5, 9, 12, 44))
                        .build())
        );

        assertThat(actualResidentialLetting.getVirtualTours(), hasItems(aVirtualTour()
                        .withUrl("url7")
                        .withId(1L)
                        .withModified(of(2011, 8, 11, 11, 44))
                        .build()
                , aVirtualTour()
                        .withUrl("url8")
                        .withId(2L)
                        .withModified(of(2012, 5, 9, 12, 44))
                        .build())
        );

        assertThat(actualResidentialLetting.getEpcGraphs(), hasItems(anEpcGraph()
                        .withUrl("url9")
                        .withId(2L)
                        .withModified(of(2013, 8, 11, 11, 44))
                        .build()
                , anEpcGraph()
                        .withUrl("url10")
                        .withId(1L)
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build())
        );

        assertThat(actualResidentialLetting.getEpcFrontPages(), hasItems(anEpcFrontPage()
                        .withUrl("url11")
                        .withId(1L)
                        .withModified(of(2016, 8, 11, 11, 44))
                        .build()
                , anEpcFrontPage()
                        .withUrl("url12")
                        .withId(2L)
                        .withModified(of(2017, 5, 9, 12, 44))
                        .build())
        );

        assertThat(actualResidentialLetting.getExternalLinks(), hasItems(anExternalLink()
                        .withId(2L)
                        .withUrl("url12")
                        .withModified(of(2018, 8, 11, 11, 44))
                        .withDescription("a")
                        .build()
                , anExternalLink()
                        .withId(1L)
                        .withUrl("url13")
                        .withModified(of(2019, 5, 9, 12, 44))
                        .withDescription("b")
                        .build())
        );
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenPropertyNotFound() {
        propertyRepositoryInMemory.save(createResidentialLettingProperties());
        final Property actualResidentialLetting = propertyRepositoryInMemory.findOne(0L);
        assertThat(actualResidentialLetting, nullValue());
    }

    @Test
    public void shouldReturnResidentialLettingProperty() {
        final Long propertyId = 3L;
        propertyRepositoryInMemory.save(createResidentialLettingProperties());
        final Property actualResidentialLetting = propertyRepositoryInMemory.findOne(propertyId);
        assertThat(actualResidentialLetting, instanceOf(ResidentialLetting.class));
        assertThat(actualResidentialLetting, is(aResidentialLetting()
                .withPropertyId(3L)
                .withDepartment(LETTINGS)
                .withIsFeaturedProperty(true)
                .withAvailability(LET)
                .withDisplayAddress("foo4")
                .withMainSummary("mainSummary4")
                .withRent(valueOf(4000))
                .withIsLetPOA(true)
                .withRentFrequency(PCM)
                .withDateLastModified(of(2015, AUGUST, 21))
                .withTimeLastModified(LocalTime.of(21, 55, 10))
                .build()));
    }

    @Test
    public void shouldReturnAllProperties() {
        propertyRepositoryInMemory.save(createResidentialLettingProperties());
        final List<Property> actualProperties = propertyRepositoryInMemory.findAll();
        assertThat(actualProperties, contains(aResidentialLetting()
                        .withPropertyId(14L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(12L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(4L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(5L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(13L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(2L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(3L)
                        .build()
                )
        );
    }

    @Test
    public void shouldReturnAllPropertiesWithSearchCriteria() {
        propertyRepositoryInMemory.save(createResidentialLettingProperties());
        final List<Property> actualProperties = propertyRepositoryInMemory.getPropertiesBySearchCriteria(
                "london"
                , valueOf(2000)
                , valueOf(4000)
                , asList(HOUSE, BUNGALOWS), 3);
        assertThat(actualProperties, contains(aResidentialLetting()
                        .withPropertyId(4L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(5L)
                        .build())
        );
    }

    @Test
    public void shouldGetMostRecentFeaturedResidentialLettingProperties() {
        propertyRepositoryInMemory.save(concat(createInvalidFeaturedResidentialLettingProperties().stream()
                , createValidFeaturedResidentialLettingProperties().stream())
                .collect(toList())
        );
        final List<Property> actualFeaturedProperties = propertyRepositoryInMemory.getFeaturedProperties();
        assertThat(actualFeaturedProperties, contains(aResidentialLetting()
                        .withPropertyId(4L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(5L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(2L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(3L)
                        .build())
        );
    }
}