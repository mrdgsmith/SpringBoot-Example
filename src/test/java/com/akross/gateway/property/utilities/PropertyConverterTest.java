package com.akross.gateway.property.utilities;

import com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.gateway.property.builders.entity.*;
import com.akross.gateway.property.entity.Property;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.akross.domain.Brochure.BrochureBuilder.aBrochure;
import static com.akross.domain.Department.LETTINGS;
import static com.akross.domain.EpcFrontPage.EpcFrontPageBuilder.anEpcFrontPage;
import static com.akross.domain.EpcGraph.EpcGraphBuilder.anEpcGraph;
import static com.akross.domain.ExternalLink.ExternalLinkBuilder.anExternalLink;
import static com.akross.domain.Floorplan.FloorplansBuilder.aFloorplan;
import static com.akross.domain.Image.ImageBuilder.anImage;
import static com.akross.domain.VirtualTour.VirtualTourBuilder.aVirtualTour;
import static com.akross.domain.residentialsalesandletting.FloorAreaUnit.HECTARES;
import static com.akross.domain.residentialsalesandletting.PropertyAge.TWENTIES_THIRTIES;
import static com.akross.domain.residentialsalesandletting.PropertyStyle.DETACHED_HOUSE;
import static com.akross.domain.residentialsalesandletting.PropertyType.BUNGALOWS;
import static com.akross.domain.residentialsalesandletting.residentialletting.Availability.REFERENCES_PENDING;
import static com.akross.domain.residentialsalesandletting.residentialletting.RentFrequency.PW;
import static com.akross.gateway.property.builders.entity.TestFlagBuilder.aFlag;
import static com.akross.gateway.property.builders.entity.TestFlagsBuilder.aFlags;
import static com.akross.gateway.property.builders.entity.TestPropertyBuilder.aProperty;
import static java.time.LocalDateTime.of;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PropertyConverterTest {

    private PropertyConverter propertyConverter;

    @Before
    public void setUp() throws Exception {
        propertyConverter = new PropertyConverter();
    }

    @Test
    public void shouldConvertPropertyToLettings() throws Exception {
        Property property = aProperty()
                .withPropertyId(64634L)
                .withBranchId(7)
                .withClientName("JUPIX")
                .withBranchName("Cambridge Office")
                .withDepartment("Lettings")
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
                .withDateLastModified(LocalDate.of(2016, 3, 1))
                .withTimeLastModified(LocalTime.of(22, 50, 34))
                .withFeaturedProperty(1)
                .withRegionId(38)
                .withLatitude(53.800651)
                .withLongitude(-4.064941)
                .withFlags(aFlags()
                        .withFlag(asList(aFlag()
                                        .withFlag("flag1")
                                        .build()
                                , aFlag()
                                        .withFlag("flag2")
                                        .build())
                        )
                        .build())
                .withMainSummary("mainSummary")
                .withFullDescription("fullDescription")
                .withImages(TestImagesBuilder.anImages()
                        .withImage(asList(TestImageBuilder.anImage().withUrl("url1")
                                        .withModified(of(2014, 8, 11, 11, 44))
                                        .build()
                                , TestImageBuilder.anImage().withUrl("url2")
                                        .withModified(of(2014, 5, 9, 12, 44))
                                        .build()
                        ))
                        .build())
                .withFloorplans(TestFloorplansBuilder.aFloorplans()
                        .withFloorplan(asList(TestFloorplanBuilder.aFloorplan()
                                        .withUrl("url1")
                                        .withModified(of(2014, 8, 11, 11, 44))
                                        .build()
                                , TestFloorplanBuilder.aFloorplan()
                                        .withUrl("url2")
                                        .withModified(of(2014, 5, 9, 12, 44))
                                        .build())
                        ).build()
                )
                .withBrochures(TestBrochuresBuilder.aBrochures()
                        .withBrochure(asList(TestBrochureBuilder.aBrochure()
                                        .withUrl("url1")
                                        .withModified(of(2014, 8, 11, 11, 44))
                                        .build()
                                , TestBrochureBuilder.aBrochure()
                                        .withUrl("url2")
                                        .withModified(of(2014, 5, 9, 12, 44))
                                        .build())
                        ).build()
                )
                .withVirtualTours(TestVirtualToursBuilder.aVirtualTours()
                        .withVirtualTour(asList(TestVirtualTourBuilder.aVirtualTour()
                                        .withUrl("url1")
                                        .withModified(of(2014, 8, 11, 11, 44))
                                        .build()
                                , TestVirtualTourBuilder.aVirtualTour()
                                        .withUrl("url2")
                                        .withModified(of(2014, 5, 9, 12, 44))
                                        .build())
                        ).build()
                )
                .withEpcGraphs(TestEpcGraphsBuilder.anEpcGraphs()
                        .withEpcGraph(asList(TestEpcGraphBuilder.anEpcGraph()
                                        .withUrl("url1")
                                        .withModified(of(2014, 8, 11, 11, 44))
                                        .build()
                                , TestEpcGraphBuilder.anEpcGraph()
                                        .withUrl("url2")
                                        .withModified(of(2014, 5, 9, 12, 44))
                                        .build())
                        ).build()
                )
                .withEpcFrontPages(TestEpcFrontPagesBuilder.anEpcFrontPages()
                        .withEpcFrontPage(asList(TestEpcFrontPageBuilder.anEpcFrontPage()
                                        .withUrl("url1")
                                        .withModified(of(2014, 8, 11, 11, 44))
                                        .build()
                                , TestEpcFrontPageBuilder.anEpcFrontPage()
                                        .withUrl("url2")
                                        .withModified(of(2014, 5, 9, 12, 44))
                                        .build())
                        ).build()
                )

                .withExternalLinks(TestExternalLinksBuilder.anExternalLinks()
                        .withExternalLink(asList(TestExternalLinkBuilder.anExternalLink()
                                        .withUrl("url1")
                                        .withModified(of(2014, 8, 11, 11, 44))
                                        .withDescription("a")
                                        .build()
                                , TestExternalLinkBuilder.anExternalLink()
                                        .withUrl("url2")
                                        .withModified(of(2014, 5, 9, 12, 44))
                                        .withDescription("b")
                                        .build())
                        ).build()
                )
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
                .withRent(BigDecimal.valueOf(4534))
                .withRentFrequency(2)
                .withToLetPOA(0)
                .withStudentProperty(1)
                .withLettingFeePolicyHeadline("Fees Apply")
                .withLettingFeePolicyDetails("bla")
                .build();
        final ResidentialLetting propertyLetting = (ResidentialLetting) propertyConverter.convert(property);
        assertThat(propertyLetting, Matchers.isA(ResidentialLetting.class));
        assertThat(propertyLetting.getPropertyId(), is(64634L));
        assertThat(propertyLetting.getBranchId(), is(7));
        assertThat(propertyLetting.getClientName(), is("JUPIX"));
        assertThat(propertyLetting.getBranchName(), is("Cambridge Office"));
        assertThat(propertyLetting.getDepartment(), is(LETTINGS));
        assertThat(propertyLetting.getReferenceNumber(), is("45435"));
        assertThat(propertyLetting.getAddressName(), is("Bla"));
        assertThat(propertyLetting.getAddressNumber(), is(1));
        assertThat(propertyLetting.getAddressStreet(), is("The Street"));
        assertThat(propertyLetting.getAddress2(), is("address2"));
        assertThat(propertyLetting.getAddress3(), is("address3"));
        assertThat(propertyLetting.getAddress4(), is("address4"));
        assertThat(propertyLetting.getAddressPostcode(), is("postcode"));
        assertThat(propertyLetting.getCountry(), is("United Kingdom"));
        assertThat(propertyLetting.getDisplayAddress(), is("1 Greenhill Street, Evesham"));
        assertThat(propertyLetting.getPropertyFeature1(), is("Bedroom with views over garden1"));
        assertThat(propertyLetting.getPropertyFeature2(), is("Bedroom with views over garden2"));
        assertThat(propertyLetting.getPropertyFeature3(), is("Bedroom with views over garden3"));
        assertThat(propertyLetting.getPropertyFeature4(), is("Bedroom with views over garden4"));
        assertThat(propertyLetting.getPropertyFeature5(), is("Bedroom with views over garden5"));
        assertThat(propertyLetting.getPropertyFeature6(), is("Bedroom with views over garden6"));
        assertThat(propertyLetting.getPropertyFeature7(), is("Bedroom with views over garden7"));
        assertThat(propertyLetting.getPropertyFeature8(), is("Bedroom with views over garden8"));
        assertThat(propertyLetting.getPropertyFeature9(), is("Bedroom with views over garden9"));
        assertThat(propertyLetting.getPropertyFeature10(), is("Bedroom with views over garden10"));
        assertThat(propertyLetting.getDateLastModified(), is(LocalDate.of(2016, 3, 1)));
        assertThat(propertyLetting.getTimeLastModified(), is(LocalTime.of(22, 50, 34)));
        assertThat(propertyLetting.isFeaturedProperty(), is(true));
        assertThat(propertyLetting.getRegionId(), is(38));
        assertThat(propertyLetting.getLatitude(), is(53.800651));
        assertThat(propertyLetting.getLongitude(), is(-4.064941));
        assertThat(propertyLetting.getFlags(), hasItems("flag1", "flag2"));
        assertThat(propertyLetting.getMainSummary(), is("mainSummary"));
        assertThat(propertyLetting.getFullDescription(), is("fullDescription"));
        assertThat(propertyLetting.getPropertyBedrooms(), is(5));
        assertThat(propertyLetting.getPropertyBathrooms(), is(3));
        assertThat(propertyLetting.getPropertyEnsuites(), is(6));
        assertThat(propertyLetting.getPropertyReceptionRooms(), is(3));
        assertThat(propertyLetting.getPropertyKitchens(), is(5));
        assertThat(propertyLetting.getPropertyAge(), is(TWENTIES_THIRTIES));
        assertThat(propertyLetting.getFloorArea(), is(190.0));
        assertThat(propertyLetting.getFloorAreaUnit(), is(HECTARES));
        assertThat(propertyLetting.getDisplayPropertyType(), is("Modern Detached House"));
        assertThat(propertyLetting.getPropertyType(), is(BUNGALOWS));
        assertThat(propertyLetting.getPropertyStyle(), is(DETACHED_HOUSE));
        assertThat(propertyLetting.getAvailbility(), is(REFERENCES_PENDING));
        assertThat(propertyLetting.getRent(), is(BigDecimal.valueOf(4534)));
        assertThat(propertyLetting.getRentFrequency(), is(PW));
        assertThat(propertyLetting.isLetPOA(), is(false));
        assertThat(propertyLetting.isStudentProperty(), is(true));
        assertThat(propertyLetting.getLettingFeePolicyHeadline(), is("Fees Apply"));
        assertThat(propertyLetting.getLettingFeePolicyDetails(), is("bla"));
        assertThat(propertyLetting.getImages(), hasItems(anImage().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , anImage().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(propertyLetting.getFloorplans(), hasItems(aFloorplan().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , aFloorplan().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(propertyLetting.getBrochures(), hasItems(aBrochure().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , aBrochure().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(propertyLetting.getVirtualTours(), hasItems(aVirtualTour().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , aVirtualTour().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(propertyLetting.getEpcGraphs(), hasItems(anEpcGraph().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , anEpcGraph().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(propertyLetting.getEpcFrontPages(), hasItems(anEpcFrontPage().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , anEpcFrontPage().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(propertyLetting.getExternalLinks(), hasItems(anExternalLink()
                        .withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .withDescription("a")
                        .build()
                , anExternalLink()
                        .withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .withDescription("b")
                        .build()
                )
        );
    }
}