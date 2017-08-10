package com.akross.gateway.property;

import com.akross.domain.property.utilities.PropertyConverter;
import com.akross.gateway.property.entity.Properties;
import com.akross.gateway.property.entity.Property;
import com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.akross.domain.property.Department.LETTINGS;
import static com.akross.gateway.property.enitity.builders.entity.TestPropertiesBuilder.aProperties;
import static com.akross.gateway.property.enitity.builders.entity.TestPropertyBuilder.aProperty;
import static com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.math.BigDecimal.valueOf;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyClientTest {

    @Rule
    public ExpectedException expectedException = none();

    @Mock
    private HttpPropertyClient httpPropertyClient;

    @Mock
    private PropertyConverter propertyConverter;

    @InjectMocks
    private PropertyClient propertyClient;

    @Test
    public void shouldReturnPropertiesForResidentialLetting() {
        final Property property1 = aProperty()
                .withPropertyId(1L)
                .withBranchId(1)
                .withClientName("JUPIX")
                .withBranchName("Cambridge Office")
                .withDepartment("Lettings")
                .withReferenceNumber("4000")
                .withRent(valueOf(400))
                .build();
        final Property property2 = aProperty()
                .withPropertyId(2L)
                .withBranchId(1)
                .withClientName("JUPIX")
                .withBranchName("Cambridge Office")
                .withDepartment("Lettings")
                .withReferenceNumber("5000")
                .withRent(valueOf(500))
                .build();

        final Properties properties = aProperties()
                .withProperties(asList(property1, property2))
                .build();

        when(httpPropertyClient.getProperties()).thenReturn(properties);

        final ResidentialLetting residentialLetting1 = aResidentialLetting()
                .withPropertyId(1L)
                .withDepartment(LETTINGS)
                .withRent(valueOf(400))
                .build();

        final ResidentialLetting residentialLetting2 = aResidentialLetting()
                .withPropertyId(2L)
                .withDepartment(LETTINGS)
                .withRent(valueOf(500))
                .build();

        when(propertyConverter.convertToResidentialLetting(property1)).thenReturn(residentialLetting1);
        when(propertyConverter.convertToResidentialLetting(property2)).thenReturn(residentialLetting2);

        final List<com.akross.repository.property.entity.Property> actualProperties = propertyClient.getProperties();
        assertThat(actualProperties, hasItems(residentialLetting1, residentialLetting2));
    }
}