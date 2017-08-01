package com.akross.gateway.property;

import com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.gateway.property.entity.Property;
import com.akross.gateway.property.utilities.PropertyConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.akross.domain.Department.LETTINGS;
import static com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static com.akross.gateway.property.builders.entity.TestPropertyBuilder.aProperty;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyClientTest {

    @Mock
    private HttpPropertyClient httpPropertyClient;

    @Mock
    private PropertyConverter propertyConverter;

    @InjectMocks
    private PropertyClient propertyClient;

    @Test
    public void shouldReturnProperties() throws Exception {
        final Property property1 = aProperty()
                .withPropertyId(16565L)
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
                .build();
        final Property property2 = aProperty()
                .withPropertyId(2L)
                .withBranchId(72)
                .withClientName("JUPIX2")
                .withBranchName("Cambridge Office2")
                .withDepartment("Sales")
                .withReferenceNumber("454352")
                .withAddressName("Bla2")
                .withAddressNumber(12)
                .withAddressStreet("The Street2")
                .withAddress2("address22")
                .withAddress3("address32")
                .withAddress4("address42")
                .withAddressPostcode("postcode2")
                .withCountry("United Kingdom2")
                .withDisplayAddress("1 Greenhill Street, Evesham")
                .withPropertyFeature1("Bedroom with views over garden12")
                .withPropertyFeature2("Bedroom with views over garden22")
                .withPropertyFeature3("Bedroom with views over garden32")
                .build();
        when(httpPropertyClient.getProperties())
                .thenReturn(asList(property1
                        , property2
                        )
                );

        final ResidentialLetting residentialLetting1 = aResidentialLetting()
                .withPropertyId(2L)
                .withBranchId(72)
                .withClientName("JUPIX2")
                .withBranchName("Cambridge Office2")
                .withDepartment(LETTINGS)
                .withReferenceNumber("454352")
                .withAddressName("Bla2")
                .withAddressNumber(12)
                .withAddressStreet("The Street2")
                .withAddress2("address22")
                .withAddress3("address32")
                .withAddress4("address42")
                .withAddressPostcode("postcode2")
                .withCountry("United Kingdom2")
                .withDisplayAddress("1 Greenhill Street, Evesham2")
                .withPropertyFeature1("Bedroom with views over garden12")
                .withPropertyFeature2("Bedroom with views over garden22")
                .withPropertyFeature3("Bedroom with views over garden32")
                .build();

        final ResidentialLetting residentialLetting2 = aResidentialLetting()
                .withPropertyId(16565L)
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
                .build();

        when(propertyConverter.convert(property1)).thenReturn(residentialLetting1);
        when(propertyConverter.convert(property2)).thenReturn(residentialLetting2);

        final List<com.akross.domain.Property> properties = propertyClient.getProperties();
        assertThat(properties, hasItems(residentialLetting1, residentialLetting2));
    }
}