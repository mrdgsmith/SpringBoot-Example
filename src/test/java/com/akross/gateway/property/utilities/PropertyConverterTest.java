package com.akross.gateway.property.utilities;

import com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.gateway.property.builders.entity.*;
import com.akross.gateway.property.entity.Property;
import org.junit.Before;
import org.junit.Test;

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
import static com.akross.gateway.property.builders.entity.TestBrochuresBuilder.aBrochures;
import static com.akross.gateway.property.builders.entity.TestEpcFrontPagesBuilder.anEpcFrontPages;
import static com.akross.gateway.property.builders.entity.TestEpcGraphsBuilder.anEpcGraphs;
import static com.akross.gateway.property.builders.entity.TestExternalLinksBuilder.anExternalLinks;
import static com.akross.gateway.property.builders.entity.TestFlagBuilder.aFlag;
import static com.akross.gateway.property.builders.entity.TestFlagsBuilder.aFlags;
import static com.akross.gateway.property.builders.entity.TestFloorplansBuilder.aFloorplans;
import static com.akross.gateway.property.builders.entity.TestImagesBuilder.anImages;
import static com.akross.gateway.property.builders.entity.TestPropertyBuilder.aProperty;
import static com.akross.gateway.property.builders.entity.TestVirtualToursBuilder.aVirtualTours;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static java.time.LocalDateTime.of;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.isA;
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
                .withDateLastModified(of(2016, 3, 1))
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
                .withImages(anImages()
                        .withImage(asList(TestImageBuilder.anImage().withUrl("url1")
                                        .withModified(of(2014, 8, 11, 11, 44))
                                        .build()
                                , TestImageBuilder.anImage().withUrl("url2")
                                        .withModified(of(2014, 5, 9, 12, 44))
                                        .build()
                        ))
                        .build())
                .withFloorplans(aFloorplans()
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
                .withBrochures(aBrochures()
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
                .withVirtualTours(aVirtualTours()
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
                .withEpcGraphs(anEpcGraphs()
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
                .withEpcFrontPages(anEpcFrontPages()
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

                .withExternalLinks(anExternalLinks()
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
                .withRent(valueOf(4534))
                .withRentFrequency(2)
                .withToLetPOA(0)
                .withStudentProperty(1)
                .withLettingFeePolicyHeadline("Fees Apply")
                .withLettingFeePolicyDetails("bla")
                .build();
        final ResidentialLetting actualResidentialLetting = propertyConverter.convertToResidentialLetting(property);
        assertThat(actualResidentialLetting, isA(ResidentialLetting.class));
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
        assertThat(actualResidentialLetting.getAvailability(), is(REFERENCES_PENDING));
        assertThat(actualResidentialLetting.getRent(), is(valueOf(4534)));
        assertThat(actualResidentialLetting.getRentFrequency(), is(PW));
        assertThat(actualResidentialLetting.isLetPOA(), is(false));
        assertThat(actualResidentialLetting.isStudentProperty(), is(true));
        assertThat(actualResidentialLetting.getLettingFeePolicyHeadline(), is("Fees Apply"));
        assertThat(actualResidentialLetting.getLettingFeePolicyDetails(), is("bla"));
        assertThat(actualResidentialLetting.getImages(), hasItems(anImage().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , anImage().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(actualResidentialLetting.getFloorplans(), hasItems(aFloorplan().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , aFloorplan().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(actualResidentialLetting.getBrochures(), hasItems(aBrochure().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , aBrochure().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(actualResidentialLetting.getVirtualTours(), hasItems(aVirtualTour().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , aVirtualTour().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(actualResidentialLetting.getEpcGraphs(), hasItems(anEpcGraph().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , anEpcGraph().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(actualResidentialLetting.getEpcFrontPages(), hasItems(anEpcFrontPage().withUrl("url1")
                        .withModified(of(2014, 8, 11, 11, 44))
                        .build()
                , anEpcFrontPage().withUrl("url2")
                        .withModified(of(2014, 5, 9, 12, 44))
                        .build()
                )
        );
        assertThat(actualResidentialLetting.getExternalLinks(), hasItems(anExternalLink()
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