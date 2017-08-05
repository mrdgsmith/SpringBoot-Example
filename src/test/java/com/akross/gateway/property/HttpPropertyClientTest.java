package com.akross.gateway.property;

import com.akross.gateway.property.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Objects.nonNull;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.TEXT_XML;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(HttpPropertyClient.class)
public class HttpPropertyClientTest {

    private static final String EXAMPLE_FEED_XML = "PropertyFeed.xml";

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private HttpPropertyClient httpPropertyClient;

    @Test
    public void ShouldGetPropertiesAndClientMakesCorrectCall() throws Exception {
        server.expect(requestTo("/api/get_properties.php?clientId=foo&passphrase=bar&version=5.0"))
                .andExpect(method(GET))
                .andExpect(queryParam("clientId", "foo"))
                .andExpect(queryParam("passphrase", "bar"))
                .andExpect(queryParam("version", "5.0"))
                .andRespond(withSuccess(xmlFeed(), TEXT_XML));
        final List<Property> actualProperties = httpPropertyClient.getProperties();
        assertThat(actualProperties.get(0).getPropertyId(), is(2232L));
        assertThat(actualProperties.get(0).getBranchId(), is(1));
        assertThat(actualProperties.get(0).getClientName(), is("JUPIX Demo"));
        assertThat(actualProperties.get(0).getBranchName(), is("Cambridge Office"));
        assertThat(actualProperties.get(0).getDepartment(), is("Sales"));
        assertThat(actualProperties.get(0).getReferenceNumber(), is("11111"));
        assertThat(actualProperties.get(0).getAddressName(), is(nullValue()));
        assertThat(actualProperties.get(0).getAddressNumber(), is(1));
        assertThat(actualProperties.get(0).getAddressStreet(), is("Greenhill Street"));
        assertThat(actualProperties.get(0).getAddress2(), is(nullValue()));
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
        assertThat(actualProperties.get(0).getPropertyFeature6(), is("4 cottages and Lodge"));
        assertThat(actualProperties.get(0).getPropertyFeature7(), is("Extensive outbuilding &amp; barns"));
        assertThat(actualProperties.get(0).getPropertyFeature8(), is("Swimming pool and paddocks"));
        assertThat(actualProperties.get(0).getPropertyFeature9(), is("In all about 69.3 acres"));
        assertThat(actualProperties.get(0).getPropertyFeature10(), is(nullValue()));
        assertThat(actualProperties.get(0).getDateLastModified(), is(LocalDate.of(2011, 6, 3)));
        assertThat(actualProperties.get(0).getTimeLastModified(), is(LocalTime.of(9, 38, 56)));
        assertThat(actualProperties.get(0).getFeaturedProperty(), is(0));
        assertThat(actualProperties.get(0).getRegionId(), is(1));
        assertThat(actualProperties.get(0).getLatitude(), is(53.800651));
        assertThat(actualProperties.get(0).getLongitude(), is(-4.064941));
        assertThat(actualProperties.get(0).getFlags(), is(new Flags(asList(new Flag("New Instruction")
                , new Flag("Price Reduction")))));
        assertThat(actualProperties.get(0).getMainSummary(), is("We are delighted to offer for sale this immaculately presented and imaginatively extended\n" +
                "            attractive flint fronted four bedroom detached family home enviably located in the heart of St Michaels\n" +
                "            Meadows. 8 bedrooms, 5 reception rooms - 4 cottages and Lodge - Extensive outbuilding &amp; barns -\n" +
                "            Swimming pool and paddocks - In all about 69.3 acres.We are delighted to offer for sale this immaculately\n" +
                "            presented and imaginatively extended attractive flint fronted four bedroom detached family home enviably\n" +
                "            located in the heart of St Michaels Meadows."));
        assertThat(actualProperties.get(0).getFullDescription(), is("<strong>SITUATION</strong> <strong></strong> Grade II listed, Loudham Hall is an exceptional Georgian home with a rich architectural history. Located two miles east of Wickham Market (winner of the 2006 Best Village Award in Suffolk), it lies less than seven miles to the north of the picturesque, riverside town of Woodbridge. The main house, gardens and grounds offer privacy yet all the conveniences of a superbly accessible location. Local shopping and recreational facilities can be found in Wickham Market with the county town of Ipswich offering more extensive amenities, as well as a train service to London Liverpool Street (from 72 minutes). <br />\n" +
                "    <br />\n" +
                "    Good local schools are numerous and include Ipswich School and Prep School, Royal Hospital School and Orwell Park School. There is also Woodbridge School in Woodbridge. <br />\n" +
                "    <br />\n" +
                "    The land included within the sale provides wonderful walking and riding opportunities. Golf can be enjoyed at Aldeburgh, Woodbridge, Melton and Ipswich and there is excellent sailing on the Alde, Deben and Orwell estuaries and along the east coast. Racing is at Newmarket and Great Yarmouth. The world-class concert hall at Snap Maltings is easily accessible as are the choice of theatres in both Woodbridge and Ipswich.<br />\n" +
                "    <br />\n" +
                "    The present Loudham Hall was preceded by, and is believed to still contain, a substantial part of an Elizabethan manor house, which is thought to make up the core of the property. The Hall was later substantially altered and improved, in around 1750, when it inherited its Georgian flourishes and perfectly symmetrical front elevation.<br />\n" +
                "    <br />\n" +
                "    The estate passed from the original Loudham family, by marriage in the early fifteenth century, to a family called Blennerhassett who also had a substantial estate at Diss. Sir Henry Wood who was the Treasurer of the Household of Henrietta, a widow of King Charles I, purchased it in the seventeenth century. His heiress, Mary, was much sought after as a wife and at 16 was contracted to be married to Charles, one of Charles II's sons by Barbara Villiers. The house was remodelled by Charles Wood who inherited following the death of the Duke of Southampton in the mid eighteenth century, although he had probably already been in occupation for some time.&nbsp;<br /><br /><strong>DESCRIPTION</strong> <strong></strong> Approached via a long, private driveway, Loudham Hall stands proudly within 100 acres of surrounding parkland, woodland and gardens, enjoying fine views towards the Deben Valley. Listed Grade II*, the Hall has beautifully symmetrical, Flemish bond brick elevations under a tile roof. An exceptional three bay, projecting pediment marks the centre of the front of the house, with four Ionic brick pilasters at first floor level and a domed clock face. A visual feast both inside and out, Loudham offers very well proportioned accommodation for family living and lavish entertaining alike.&nbsp;<br /><br /><strong>GROUND</strong> <strong>FLOOR</strong> <strong></strong> Favourably reviewed by the architectural historian Sir Nikolaus Pevsner, Loudham Hall has copious fine internal features that include the magnificent wood panelled Entrance Hall with a lavish pair of Corinthian columns and original flagstone flooring. It creates an instantly impressive welcome and connects with the central Staircase Hall and Side Entrance Hall, both of which join and cross the length of the house from east to west. This makes for a very logical layout, with all the principal reception rooms positioned off these splendid central corridors. Extravagant fireplaces - invariably with marble surrounds - are regular features inside Loudham Hall and are of particular note in the Dining Room and Drawing Room: the latter has a Neo Classical marble chimney piece with fluted pilasters supporting a carved central panel holding a reclining beauty in a classical landscape.<br />\n" +
                "    <br />\n" +
                "    The Kitchen/Breakfast Room has been well designed and adapted for modern life with a four door Aga and a striking copper chimney above it. There is a useful Pantry and Utility Room to either side. <br />\n" +
                "    <br />\n" +
                "    For more details, please consult the floorplans.&nbsp;"));
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
        assertThat(actualProperties.get(0).getPrice(), is(BigDecimal.valueOf(2100000)));
        assertThat(actualProperties.get(0).getForSalePOA(), is(0));
        assertThat(actualProperties.get(0).getPriceQualifier(), is(4));
        assertThat(actualProperties.get(0).getPropertyTenure(), is(1));
        assertThat(actualProperties.get(0).getSaleBy(), is(1));
        assertThat(actualProperties.get(0).getDevelopmentOpportunity(), is(0));
        assertThat(actualProperties.get(0).getInvestmentOpportunity(), is(0));
        assertThat(actualProperties.get(0).getEstimatedRentalIncome(), is(BigDecimal.valueOf(3950)));
        assertThat(actualProperties.get(1).getRent(), is(BigDecimal.valueOf(2500)));
        assertThat(actualProperties.get(1).getRentFrequency(), is(1));
        assertThat(actualProperties.get(1).getToLetPOA(), is(0));
        assertThat(actualProperties.get(1).getStudentProperty(), is(nullValue()));
        assertThat(actualProperties.get(1).getLettingFeePolicyHeadline(), is("Fees may apply"));
        assertThat(actualProperties.get(1).getLettingFeePolicyDetails(), is(nullValue()));
        assertThat(actualProperties.get(0).getForSale(), is(0));
        assertThat(actualProperties.get(0).getToLet(), is(1));
        assertThat(actualProperties.get(0).getPriceTo(), is(BigDecimal.valueOf(150000)));
        assertThat(actualProperties.get(0).getPriceFrom(), is(BigDecimal.valueOf(450000)));
        assertThat(actualProperties.get(0).getRentTo(), is(BigDecimal.valueOf(12000)));
        assertThat(actualProperties.get(0).getRentFrom(), is(BigDecimal.valueOf(22000)));
        assertThat(actualProperties.get(0).getFloorAreaTo(), is(55.7));
        assertThat(actualProperties.get(0).getFloorAreaFrom(), is(85.10));
        assertThat(actualProperties.get(0).getSiteArea(), is(100.10));
        assertThat(actualProperties.get(0).getSiteAreaUnits(), is("hectares"));
        assertThat(actualProperties.get(0).getStrapLine(), is("Flexible office space"));
        assertThat(actualProperties.get(0).getPropertyTypes(), is(new PropertyTypes(asList(new PropertyType("28")
                , new PropertyType("5")
                , new PropertyType("1"))
        )));
        assertThat(actualProperties.get(0).getLandAreaTo(), is(4342.20D));
        assertThat(actualProperties.get(0).getLandAreaFrom(), is(4347.24D));
        assertThat(actualProperties.get(0).getLandAreaUnits(), is("bla"));
        assertThat(actualProperties.get(0).getForSaleLeaseLength(), is(7));
        assertThat(actualProperties.get(0).getImages(), is(new Images(asList(
                new Image(LocalDateTime.of(2011, 1, 21, 10, 12, 6)
                        , "http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_1_large.jpg")
                , new Image(LocalDateTime.of(2011, 4, 1, 11, 20, 0)
                        , "http://media2.jupix.co.uk/v3/clients/4/properties/795/IMG_795_2_large.jpg")
                ))
        ));
        assertThat(actualProperties.get(0).getFloorplans(), is(new Floorplans(asList(
                new Floorplan(LocalDateTime.of(2011, 4, 1, 11, 30, 0)
                        , "http://media2.jupix.co.uk/v3/clients/4/properties/795/FLP_795_1_large.jpg")
                , new Floorplan(LocalDateTime.of(2011, 4, 1, 11, 31, 0)
                        , "http://media2.jupix.co.uk/v3/clients/4/properties/795/FLP_795_2_large.jpg")
                ))
        ));
        assertThat(actualProperties.get(0).getEpcGraphs(), is(new EpcGraphs(singletonList(
                new EpcGraph(LocalDateTime.of(2011, 4, 1, 11, 35, 0)
                        , "http://media2.jupix.co.uk/v3/clients/4/properties/795/MED_795_5086.jpg")
                ))
        ));
        assertThat(actualProperties.get(0).getEpcFrontPages(), is(new EpcFrontPages(singletonList(
                new EpcFrontPage(LocalDateTime.of(2011, 4, 1, 11, 35, 0)
                        , "http://epc.jupix.co.uk/f465cvd")
                ))
        ));
        assertThat(actualProperties.get(0).getBrochures(), is(new Brochures(singletonList(
                new Brochure(LocalDateTime.of(2011, 4, 1, 11, 40, 0)
                        , "http://media2.jupix.co.uk/v3/clients/4/properties/795/MED_795_5085.pdf")
                ))
        ));
        assertThat(actualProperties.get(0).getVirtualTours(), is(new VirtualTours(asList(
                new VirtualTour(LocalDateTime.of(2011, 4, 1, 11, 50, 0)
                        , "http://www.hackneyandleigh.co.uk/vt/k4485/k4485.htm")
                , new VirtualTour(LocalDateTime.of(2011, 4, 1, 11, 50, 0)
                        , "http://media2.jupix.co.uk/v3/clients/4/properties/795/MED_795_72967.swf")
                ))
        ));
        assertThat(actualProperties.get(0).getExternalLinks(), is(new ExternalLinks(singletonList(
                new ExternalLink("www.test.com?this=that&here=there"
                        , "Interactive Floorplan"
                        , LocalDateTime.of(2013, 4, 17, 16, 15, 46))
                ))
        ));
    }

    private String xmlFeed() throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource(EXAMPLE_FEED_XML);
        if (nonNull(resource)) {
            return new String(Files.readAllBytes(Paths.get(resource.toURI())));
        }
        throw new RuntimeException(MessageFormat.format("Cannot find file {0}", EXAMPLE_FEED_XML));
    }
}