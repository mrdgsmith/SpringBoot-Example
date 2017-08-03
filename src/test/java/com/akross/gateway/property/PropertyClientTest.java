package com.akross.gateway.property;

import com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.gateway.property.entity.Property;
import com.akross.gateway.property.utilities.PropertyConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.akross.domain.Department.LETTINGS;
import static com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static com.akross.gateway.property.builders.entity.TestPropertyBuilder.aProperty;
import static java.math.BigDecimal.valueOf;
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
    public void shouldReturnPropertiesForResidentialLetting() throws Exception {
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

        when(httpPropertyClient.getProperties()).thenReturn(asList(property1, property2));

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

        final com.akross.domain.container.Property actualProperties = propertyClient.getProperties();
        assertThat(actualProperties.getResidentialLettings(), hasItems(residentialLetting1, residentialLetting2));
    }
}