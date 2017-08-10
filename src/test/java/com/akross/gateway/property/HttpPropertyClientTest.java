package com.akross.gateway.property;

import com.akross.domain.property.utilities.configuration.PropertyConverterConfiguration;
import com.akross.gateway.property.configuration.PropertyGatewayConfiguration;
import com.akross.gateway.property.entity.Properties;
import com.akross.gateway.property.entity.Property;
import com.akross.gateway.property.exception.PropertiesGatewayException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.akross.gateway.property.enitity.builders.entity.TestBrochureBuilder.anBrochure;
import static com.akross.gateway.property.enitity.builders.entity.TestEpcFrontPageBuilder.anEpcFrontPage;
import static com.akross.gateway.property.enitity.builders.entity.TestEpcGraphBuilder.anEpcGraph;
import static com.akross.gateway.property.enitity.builders.entity.TestExternalLinkBuilder.anExternalLink;
import static com.akross.gateway.property.enitity.builders.entity.TestFloorplanBuilder.anFloorplan;
import static com.akross.gateway.property.enitity.builders.entity.TestImageBuilder.anImage;
import static com.akross.gateway.property.enitity.builders.entity.TestVirtualTourBuilder.anVirtualTour;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDateTime.of;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Objects.nonNull;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.TEXT_XML;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(HttpPropertyClient.class)
@ContextConfiguration(classes = {PropertyGatewayConfiguration.class, PropertyConverterConfiguration.class})
public class HttpPropertyClientTest {

    private static final String EXAMPLE_FEED_XML = "PropertyFeed.xml";

    @Rule
    public ExpectedException expectedException = none();

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private HttpPropertyClient httpPropertyClient;

    @Test
    public void shouldReturnErrorMessage() {
        mockRestServiceServer
                .expect(requestTo("/api/get_properties.php?clientId=foo&passphrase=bar&version=5.0"))
                .andExpect(method(GET))
                .andExpect(queryParam("clientId", "foo"))
                .andExpect(queryParam("passphrase", "bar"))
                .andExpect(queryParam("version", "5.0"))
                .andRespond(withServerError());
        expectedException.expect(PropertiesGatewayException.class);
        expectedException.expectMessage("Failed to get properties with this get request clientId=foo&passphrase=bar&version=5.0");
        httpPropertyClient.getProperties();
    }

    @Test
    public void ShouldGetPropertiesAndClientMakesCorrectCall() throws Exception {
        mockRestServiceServer
                .expect(requestTo("/api/get_properties.php?clientId=foo&passphrase=bar&version=5.0"))
                .andExpect(method(GET))
                .andExpect(queryParam("clientId", "foo"))
                .andExpect(queryParam("passphrase", "bar"))
                .andExpect(queryParam("version", "5.0"))
                .andRespond(withSuccess(xmlFeed(), TEXT_XML));
        final Properties properties = httpPropertyClient.getProperties();
        final List<Property> actualProperties = properties.getProperties();
        assertThat(actualProperties.get(0).getPropertyId(), is(2232L));
        assertThat(actualProperties.get(0).getBranchId(), is(1));
        assertThat(actualProperties.get(0).getClientName(), is("JUPIX Demo"));
        assertThat(actualProperties.get(0).getBranchName(), is("Cambridge Office"));
        assertThat(actualProperties.get(0).getDepartment(), is("Sales"));
        assertThat(actualProperties.get(0).getReferenceNumber(), is("11111"));
        assertThat(actualProperties.get(0).getAddressName(), is("Garnes"));
        assertThat(actualProperties.get(0).getAddressNumber(), is("1"));
        assertThat(actualProperties.get(0).getAddressStreet(), is("Greenhill Street"));
        assertThat(actualProperties.get(0).getAddress2(), is("Whiston"));
        assertThat(actualProperties.get(0).getAddress3(), is("Evesham"));
        assertThat(actualProperties.get(0).getAddress4(), is("Worcestershire"));
        assertThat(actualProperties.get(0).getAddressPostcode(), is("NN13 7XY"));
        assertThat(actualProperties.get(0).getCountry(), is("United Kingdom"));
        assertThat(actualProperties.get(0).getDisplayAddress(), is("1 Greenhill Street, Evesham"));
        assertThat(actualProperties.get(0).getPropertyFeature1(), is("Master bedroom with views over the garden"));
        assertThat(actualProperties.get(0).getPropertyFeature2(), is("Double beds in all bedrooms"));
        assertThat(actualProperties.get(0).getPropertyFeature3(), is("4 Bathrooms"));
        assertThat(actualProperties.get(0).getPropertyFeature4(), is("Garage parking"));
        assertThat(actualProperties.get(0).getPropertyFeature5(), is("5 Reception Rooms"));
        assertThat(actualProperties.get(0).getPropertyFeature6(), is("4 cottages and Lodge "));
        assertThat(actualProperties.get(0).getPropertyFeature7(), is("Extensive outbuilding &amp; barns "));
        assertThat(actualProperties.get(0).getPropertyFeature8(), is("Swimming pool and paddocks "));
        assertThat(actualProperties.get(0).getPropertyFeature9(), is("In all about 69.3 acres"));
        assertThat(actualProperties.get(0).getPropertyFeature10(), is("feature 10"));
        assertThat(actualProperties.get(0).getDateLastModified(), is(LocalDate.of(2011, 6, 3)));
        assertThat(actualProperties.get(0).getTimeLastModified(), is(LocalTime.of(9, 38, 56)));
        assertThat(actualProperties.get(0).getFeaturedProperty(), is(1));
        assertThat(actualProperties.get(0).getRegionId(), is(1));
        assertThat(actualProperties.get(0).getLatitude(), is(53.800651));
        assertThat(actualProperties.get(0).getLongitude(), is(-4.064941));
        assertThat(actualProperties.get(0).getFlags(), contains("New Instruction", "Price Reduction"));
        assertThat(actualProperties.get(0).getMainSummary(), is("We are delighted to offer for sale this" +
                " immaculately presented and imaginatively extended attractive flint fronted four bedroom detached family" +
                " home enviably located in the heart of St Michaels Meadows. 8 bedrooms, 5 reception rooms - 4 cottages" +
                " and Lodge - Extensive outbuilding &amp; barns - Swimming pool and paddocks" +
                " - In all about 69.3 acres.We are delighted to offer for sale this immaculately presented and" +
                " imaginatively extended attractive flint fronted four bedroom detached family home enviably" +
                " located in the heart of St Michaels Meadows."));
        assertThat(actualProperties.get(0).getFullDescription(), is("<strong>SITUATION</strong> <strong></strong> Grade II listed, Loudham Hall is an exceptional Georgian home with a rich architectural history. Located two miles east of Wickham Market (winner of the 2006 Best Village Award in Suffolk), it lies less than seven miles to the north of the picturesque, riverside town of Woodbridge. The main house, gardens and grounds offer privacy yet all the conveniences of a superbly accessible location. Local shopping and recreational facilities can be found in Wickham Market with the county town of Ipswich offering more extensive amenities, as well as a train service to London Liverpool Street (from 72 minutes). <br />\n" +
                "<br />\n" +
                "Good local schools are numerous and include Ipswich School and Prep School, Royal Hospital School and Orwell Park School. There is also Woodbridge School in Woodbridge. <br />\n" +
                "<br />\n" +
                "The land included within the sale provides wonderful walking and riding opportunities. Golf can be enjoyed at Aldeburgh, Woodbridge, Melton and Ipswich and there is excellent sailing on the Alde, Deben and Orwell estuaries and along the east coast. Racing is at Newmarket and Great Yarmouth. The world-class concert hall at Snap Maltings is easily accessible as are the choice of theatres in both Woodbridge and Ipswich.<br />\n" +
                "<br />\n" +
                "The present Loudham Hall was preceded by, and is believed to still contain, a substantial part of an Elizabethan manor house, which is thought to make up the core of the property. The Hall was later substantially altered and improved, in around 1750, when it inherited its Georgian flourishes and perfectly symmetrical front elevation.<br />\n" +
                "<br />\n" +
                "The estate passed from the original Loudham family, by marriage in the early fifteenth century, to a family called Blennerhassett who also had a substantial estate at Diss. Sir Henry Wood who was the Treasurer of the Household of Henrietta, a widow of King Charles I, purchased it in the seventeenth century. His heiress, Mary, was much sought after as a wife and at 16 was contracted to be married to Charles, one of Charles II's sons by Barbara Villiers. The house was remodelled by Charles Wood who inherited following the death of the Duke of Southampton in the mid eighteenth century, although he had probably already been in occupation for some time.&nbsp;<br /><br /><strong>DESCRIPTION</strong> <strong></strong> Approached via a long, private driveway, Loudham Hall stands proudly within 100 acres of surrounding parkland, woodland and gardens, enjoying fine views towards the Deben Valley. Listed Grade II*, the Hall has beautifully symmetrical, Flemish bond brick elevations under a tile roof. An exceptional three bay, projecting pediment marks the centre of the front of the house, with four Ionic brick pilasters at first floor level and a domed clock face. A visual feast both inside and out, Loudham offers very well proportioned accommodation for family living and lavish entertaining alike.&nbsp;<br /><br /><strong>GROUND</strong> <strong>FLOOR</strong> <strong></strong> Favourably reviewed by the architectural historian Sir Nikolaus Pevsner, Loudham Hall has copious fine internal features that include the magnificent wood panelled Entrance Hall with a lavish pair of Corinthian columns and original flagstone flooring. It creates an instantly impressive welcome and connects with the central Staircase Hall and Side Entrance Hall, both of which join and cross the length of the house from east to west. This makes for a very logical layout, with all the principal reception rooms positioned off these splendid central corridors. Extravagant fireplaces - invariably with marble surrounds - are regular features inside Loudham Hall and are of particular note in the Dining Room and Drawing Room: the latter has a Neo Classical marble chimney piece with fluted pilasters supporting a carved central panel holding a reclining beauty in a classical landscape.<br />\n" +
                "<br />\n" +
                "The Kitchen/Breakfast Room has been well designed and adapted for modern life with a four door Aga and a striking copper chimney above it. There is a useful Pantry and Utility Room to either side. <br />\n" +
                "<br />\n" +
                "For more details, please consult the floorplans.&nbsp;"));
        assertThat(actualProperties.get(0).getPropertyBedrooms(), is(5));
        assertThat(actualProperties.get(0).getPropertyBathrooms(), is(4));
        assertThat(actualProperties.get(0).getPropertyEnsuites(), is(2));
        assertThat(actualProperties.get(0).getPropertyReceptionRooms(), is(4));
        assertThat(actualProperties.get(0).getPropertyKitchens(), is(1));
        assertThat(actualProperties.get(0).getPropertyAge(), is(9));
        assertThat(actualProperties.get(0).getFloorArea(), is(140.00));
        assertThat(actualProperties.get(0).getFloorAreaUnits(), is("sq ft"));
        assertThat(actualProperties.get(0).getDisplayPropertyType(), is("Detached House"));
        assertThat(actualProperties.get(0).getPropertyType(), is(1));
        assertThat(actualProperties.get(0).getPropertyStyle(), is(4));
        assertThat(actualProperties.get(0).getAvailability(), is(2));
        assertThat(actualProperties.get(0).getPrice(), is(valueOf(2100000)));
        assertThat(actualProperties.get(0).getForSalePOA(), is(1));
        assertThat(actualProperties.get(0).getPriceQualifier(), is(4));
        assertThat(actualProperties.get(0).getPropertyTenure(), is(1));
        assertThat(actualProperties.get(0).getSaleBy(), is(1));
        assertThat(actualProperties.get(0).getDevelopmentOpportunity(), is(1));
        assertThat(actualProperties.get(0).getInvestmentOpportunity(), is(1));
        assertThat(actualProperties.get(0).getEstimatedRentalIncome(), is(valueOf(3950)));
        assertThat(actualProperties.get(0).getRent(), is(valueOf(568)));
        assertThat(actualProperties.get(0).getRentFrequency(), is(1));
        assertThat(actualProperties.get(0).getToLetPOA(), is(1));
        assertThat(actualProperties.get(0).getStudentProperty(), is(1));
        assertThat(actualProperties.get(0).getLettingFeePolicyHeadline(), is("Fees Apply"));
        assertThat(actualProperties.get(0).getLettingFeePolicyDetails(), is("Fees will be charged to each" +
                " prospective tenant, on application, for referencing and administration."));
        assertThat(actualProperties.get(0).getForSale(), is(1));
        assertThat(actualProperties.get(0).getToLet(), is(1));
        assertThat(actualProperties.get(0).getPriceTo(), is(valueOf(600)));
        assertThat(actualProperties.get(0).getPriceFrom(), is(valueOf(700)));
        assertThat(actualProperties.get(0).getRentTo(), is(valueOf(9300)));
        assertThat(actualProperties.get(0).getRentFrom(), is(valueOf(467)));
        assertThat(actualProperties.get(0).getFloorAreaTo(), is(50.5));
        assertThat(actualProperties.get(0).getFloorAreaFrom(), is(478.986));
        assertThat(actualProperties.get(0).getSiteArea(), is(0.00));
        assertThat(actualProperties.get(0).getSiteAreaUnits(), is("sq ft"));
        assertThat(actualProperties.get(0).getStrapLine(), is("Offices available"));
        assertThat(actualProperties.get(0).getPropertyTypes(), is(asList(1, 3)));
        assertThat(actualProperties.get(0).getLandAreaTo(), is(89.4));
        assertThat(actualProperties.get(0).getLandAreaFrom(), is(45.35));
        assertThat(actualProperties.get(0).getLandAreaUnits(), is("Acres"));
        assertThat(actualProperties.get(0).getForSaleLeaseLength(), is(7));
        assertThat(actualProperties.get(0).getImages(), is(asList(
                anImage()
                        .withModified(of(2011, 1, 21, 10, 12, 6))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_1_large.jpg")
                        .build()
                , anImage()
                        .withModified(of(2011, 4, 1, 11, 20, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_2_large.jpg")
                        .build(),

                anImage()
                        .withModified(of(2011, 4, 1, 11, 20, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_3_large.jpg")
                        .build()
                , anImage()
                        .withModified(of(2011, 4, 1, 11, 20, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_4_large.jpg")
                        .build()
                , anImage()
                        .withModified(of(2011, 4, 1, 11, 20, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_5_large.jpg")
                        .build()
                , anImage()
                        .withModified(of(2011, 4, 1, 11, 20, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_6_large.jpg")
                        .build()
                , anImage()
                        .withModified(of(2011, 4, 1, 11, 20, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_7_large.jpg")
                        .build()
                , anImage()
                        .withModified(of(2011, 4, 1, 11, 20, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_8_large.jpg")
                        .build()
                , anImage()
                        .withModified(of(2011, 4, 1, 11, 20, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_9_large.jpg")
                        .build()
                , anImage()
                        .withModified(of(2011, 4, 1, 11, 20, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_10_large.jpg")
                        .build()
                , anImage()
                        .withModified(of(2011, 6, 3, 14, 33, 10))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_11_large.jpg")
                        .build()
                ))
        );
        assertThat(actualProperties.get(0).getFloorplans(), is((asList(
                anFloorplan()
                        .withModified(of(2011, 4, 1, 11, 30, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/FLP_795_1_large.jpg")
                        .build()
                , anFloorplan()
                        .withModified(of(2011, 4, 1, 11, 30, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/FLP_795_2_large.jpg")
                        .build()
                )))
        );
        assertThat(actualProperties.get(0).getEpcGraphs(), is(singletonList(anEpcGraph()
                        .withModified(of(2011, 4, 1, 11, 35, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/MED_795_5086.jpg")
                        .build()
                ))
        );
        assertThat(actualProperties.get(0).getEpcFrontPages(), is(singletonList(
                anEpcFrontPage()
                        .withModified(of(2011, 4, 1, 11, 35, 0))
                        .withUrl("http://epc.jupix.co.uk/f465cvd")
                        .build()
                ))
        );
        assertThat(actualProperties.get(0).getBrochures(), is(singletonList(
                anBrochure()
                        .withModified(of(2011, 4, 1, 11, 40, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/MED_795_5085.pdf")
                        .build()
                ))
        );
        assertThat(actualProperties.get(0).getVirtualTours(), is(asList(
                anVirtualTour()
                        .withModified(of(2011, 4, 1, 11, 50, 0))
                        .withUrl("http://www.hackneyandleigh.co.uk/vt/k4485/k4485.htm")
                        .build()
                , anVirtualTour()
                        .withModified(of(2011, 4, 1, 11, 50, 0))
                        .withUrl("http://media2.jupix.co.uk/v3/clients/4/properties/795/MED_795_72967.swf")
                        .build()
                ))
        );
        assertThat(actualProperties.get(0).getExternalLinks(), is(singletonList(
                anExternalLink()
                        .withDescription("Interactive Floorplan")
                        .withModified(of(2013, 4, 17, 16, 15, 46))
                        .withUrl("www.test.com?this=that&here=there")
                        .build()
                ))
        );
        assertThat(actualProperties.get(19).getPropertyId(), is(38324L));
    }

    private String xmlFeed() throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource(EXAMPLE_FEED_XML);
        if (nonNull(resource)) {
            return new String(Files.readAllBytes(Paths.get(resource.toURI())));
        }
        throw new RuntimeException(MessageFormat.format("Cannot find file {0}", EXAMPLE_FEED_XML));
    }
}