package com.akross.web.property;

import com.akross.service.PropertyService;
import com.akross.web.property.enitity.container.Property;
import com.akross.web.property.enitity.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.akross.domain.Brochure.BrochureBuilder.aBrochure;
import static com.akross.domain.Department.LETTINGS;
import static com.akross.domain.EpcFrontPage.EpcFrontPageBuilder.anEpcFrontPage;
import static com.akross.domain.EpcGraph.EpcGraphBuilder.anEpcGraph;
import static com.akross.domain.ExternalLink.ExternalLinkBuilder.anExternalLink;
import static com.akross.domain.Floorplan.FloorplanBuilder.aFloorplan;
import static com.akross.domain.Image.ImageBuilder.anImage;
import static com.akross.domain.VirtualTour.VirtualTourBuilder.aVirtualTour;
import static com.akross.domain.container.Property.PropertyBuilder.aProperty;
import static com.akross.domain.residentialsalesandletting.FloorAreaUnit.HECTARES;
import static com.akross.domain.residentialsalesandletting.PropertyAge.TWENTIES_THIRTIES;
import static com.akross.domain.residentialsalesandletting.PropertyStyle.DETACHED_HOUSE;
import static com.akross.domain.residentialsalesandletting.PropertyType.BUNGALOWS;
import static com.akross.domain.residentialsalesandletting.residentialletting.Availability.REFERENCES_PENDING;
import static com.akross.domain.residentialsalesandletting.residentialletting.RentFrequency.PW;
import static com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDateTime.of;
import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PropertyController.class)
@AutoConfigureWebClient
//@AutoConfigureRestDocs("target/generated-snippets")
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PropertyService propertyService;

    private static com.akross.domain.container.Property getDomainProperty() {
        return aProperty()
                .withResidentialLettings(asList(
                        aResidentialLetting()
                                .withPropertyId(64634L)
                                .withBranchId(7)
                                .withClientName("JUPIX")
                                .withBranchName("Cambridge Office")
                                .withDepartment(LETTINGS)
                                .withReferenceNumber("563456")
                                .withAddressName("bla")
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
                                .withAvailability(REFERENCES_PENDING)
                                .withRent(valueOf(4534))
                                .withRentFrequency(PW)
                                .withIsLetPOA(false)
                                .withIsStudentProperty(true)
                                .withLettingFeePolicyHeadline("Fees Apply")
                                .withLettingFeePolicyDetails("bla")
                                .withImages(asList(
                                        anImage().withUrl("url1")
                                                .withModified(of(2014, 8, 11, 11, 44))
                                                .build()
                                        , anImage().withUrl("url2")
                                                .withModified(of(2014, 5, 9, 12, 44))
                                                .build()
                                ))
                                .withFloorplans(asList(
                                        aFloorplan().withUrl("url1")
                                                .withModified(of(2014, 8, 11, 11, 44))
                                                .build()
                                        , aFloorplan().withUrl("url2")
                                                .withModified(of(2014, 5, 9, 12, 44))
                                                .build()
                                ))
                                .withBrochures(asList(
                                        aBrochure().withUrl("url1")
                                                .withModified(of(2014, 8, 11, 11, 44))
                                                .build()
                                        , aBrochure().withUrl("url2")
                                                .withModified(of(2014, 5, 9, 12, 44))
                                                .build()
                                ))
                                .withVirtualTours(asList(
                                        aVirtualTour().withUrl("url1")
                                                .withModified(of(2014, 8, 11, 11, 44))
                                                .build()
                                        , aVirtualTour().withUrl("url2")
                                                .withModified(of(2014, 5, 9, 12, 44))
                                                .build()
                                ))
                                .withEpcGraphs(asList(
                                        anEpcGraph().withUrl("url1")
                                                .withModified(of(2014, 8, 11, 11, 44))
                                                .build()
                                        , anEpcGraph().withUrl("url2")
                                                .withModified(of(2014, 5, 9, 12, 44))
                                                .build()
                                ))
                                .withEpcFrontPages(asList(
                                        anEpcFrontPage().withUrl("url1")
                                                .withModified(of(2014, 8, 11, 11, 44))
                                                .build()
                                        , anEpcFrontPage().withUrl("url2")
                                                .withModified(of(2014, 5, 9, 12, 44))
                                                .build()
                                ))
                                .withExternalLinks(asList(
                                        anExternalLink()
                                                .withUrl("url1")
                                                .withModified(of(2014, 8, 11, 11, 44))
                                                .withDescription("a")
                                                .build()
                                        , anExternalLink()
                                                .withUrl("url2")
                                                .withModified(of(2014, 5, 9, 12, 44))
                                                .withDescription("b")
                                                .build()
                                ))
                                .build()
                        )
                ).build();
    }

    @Test
    public void shouldReturnFeaturedProperties() throws Exception {
        given(propertyService.getProperties(true)).willReturn(getDomainProperty());
        mockMvc.perform(get("/properties")
                .param("featured", "true")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(content()
                        .json(getExpectedJsonProperty())
                );
    }

    private String getExpectedJsonProperty() throws JsonProcessingException {
        return objectMapper.writeValueAsString(
                Property.PropertyBuilder.aProperty()
                        .withResidentialLettings(asList(
                                ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting()
                                        .withPropertyId(64634L)
                                        .withBranchId(7)
                                        .withClientName("JUPIX")
                                        .withBranchName("Cambridge Office")
                                        .withDepartment(LETTINGS)
                                        .withReferenceNumber("563456")
                                        .withAddressName("bla")
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
                                        .withAvailability(REFERENCES_PENDING)
                                        .withRent(valueOf(4534))
                                        .withRentFrequency(PW)
                                        .withIsLetPOA(false)
                                        .withIsStudentProperty(true)
                                        .withLettingFeePolicyHeadline("Fees Apply")
                                        .withLettingFeePolicyDetails("bla")
                                        .withImages(asList(
                                                com.akross.web.property.enitity.Image.ImageBuilder.anImage().withUrl("url1")
                                                        .withModified(of(2014, 8, 11, 11, 44))
                                                        .build()
                                                , com.akross.web.property.enitity.Image.ImageBuilder.anImage().withUrl("url2")
                                                        .withModified(of(2014, 5, 9, 12, 44))
                                                        .build()
                                        ))
                                        .withFloorplans(asList(
                                                com.akross.web.property.enitity.Floorplan.FloorplanBuilder.aFloorplan().withUrl("url1")
                                                        .withModified(of(2014, 8, 11, 11, 44))
                                                        .build()
                                                , com.akross.web.property.enitity.Floorplan.FloorplanBuilder.aFloorplan().withUrl("url2")
                                                        .withModified(of(2014, 5, 9, 12, 44))
                                                        .build()
                                        ))
                                        .withBrochures(asList(
                                                com.akross.web.property.enitity.Brochure.BrochureBuilder.aBrochure().withUrl("url1")
                                                        .withModified(of(2014, 8, 11, 11, 44))
                                                        .build()
                                                , com.akross.web.property.enitity.Brochure.BrochureBuilder.aBrochure().withUrl("url2")
                                                        .withModified(of(2014, 5, 9, 12, 44))
                                                        .build()
                                        ))
                                        .withVirtualTours(asList(
                                                com.akross.web.property.enitity.VirtualTour.VirtualTourBuilder.aVirtualTour().withUrl("url1")
                                                        .withModified(of(2014, 8, 11, 11, 44))
                                                        .build()
                                                , com.akross.web.property.enitity.VirtualTour.VirtualTourBuilder.aVirtualTour().withUrl("url2")
                                                        .withModified(of(2014, 5, 9, 12, 44))
                                                        .build()
                                        ))
                                        .withEpcGraphs(asList(
                                                com.akross.web.property.enitity.EpcGraph.EpcGraphBuilder.anEpcGraph().withUrl("url1")
                                                        .withModified(of(2014, 8, 11, 11, 44))
                                                        .build()
                                                , com.akross.web.property.enitity.EpcGraph.EpcGraphBuilder.anEpcGraph().withUrl("url2")
                                                        .withModified(of(2014, 5, 9, 12, 44))
                                                        .build()
                                        ))
                                        .withEpcFrontPages(asList(
                                                com.akross.web.property.enitity.EpcFrontPage.EpcFrontPageBuilder.anEpcFrontPage().withUrl("url1")
                                                        .withModified(of(2014, 8, 11, 11, 44))
                                                        .build()
                                                , com.akross.web.property.enitity.EpcFrontPage.EpcFrontPageBuilder.anEpcFrontPage().withUrl("url2")
                                                        .withModified(of(2014, 5, 9, 12, 44))
                                                        .build()
                                        ))
                                        .withExternalLinks(asList(
                                                com.akross.web.property.enitity.ExternalLink.ExternalLinkBuilder.anExternalLink()
                                                        .withUrl("url1")
                                                        .withModified(of(2014, 8, 11, 11, 44))
                                                        .withDescription("a")
                                                        .build()
                                                , com.akross.web.property.enitity.ExternalLink.ExternalLinkBuilder.anExternalLink()
                                                        .withUrl("url2")
                                                        .withModified(of(2014, 5, 9, 12, 44))
                                                        .withDescription("b")
                                                        .build()
                                                )
                                        )
                                        .build()
                                )
                        )
                        .build()
        );
    }
}
