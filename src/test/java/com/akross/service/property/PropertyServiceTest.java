package com.akross.service.property;

import com.akross.domain.property.container.Property;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.repository.PropertyRepository;
import com.akross.repository.property.exception.PropertyNotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

import static com.akross.domain.property.Department.LETTINGS;
import static com.akross.domain.property.Department.SALES;
import static com.akross.domain.property.container.Property.PropertyBuilder.aProperty;
import static com.akross.domain.property.residentialsalesandletting.PropertyType.BUNGALOWS;
import static com.akross.domain.property.residentialsalesandletting.PropertyType.HOUSE;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.Availability.LET;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.Availability.WITHDRAWN;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.RentFrequency.PCM;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static java.time.Month.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceTest {

    @Rule
    public ExpectedException expectedException = none();

    @Mock
    private PropertyRepository propertyRepository;

    @InjectMocks
    private PropertyService propertyService;

    private static List<ResidentialLetting> createResidentialLettingProperties() {
        return asList(
                aResidentialLetting()
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
                        .build()
        );
    }

    @Test
    public void shouldReturnResidentialLettingProperty() {
        final Long propertyId = 3L;

        when(propertyRepository.getProperty(propertyId))
                .thenReturn(aResidentialLetting()
                        .withPropertyId(3L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo4")
                        .withMainSummary("mainSummary4")
                        .withRent(null)
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 10))
                        .build());

        final com.akross.domain.property.Property property = propertyService.getProperty(propertyId);
        assertThat(property, instanceOf(ResidentialLetting.class));
        assertThat(property, is(aResidentialLetting()
                        .withPropertyId(3L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo4")
                        .withMainSummary("mainSummary4")
                        .withRent(null)
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 10))
                        .build()
                )
        );
        verify(propertyRepository).getProperty(propertyId);
        verifyNoMoreInteractions(propertyRepository);
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenPropertyNotFound() {
        final Long propertyId = 1L;
        when(propertyRepository.getProperty(propertyId))
                .thenThrow(new PropertyNotFoundException(propertyId));
        try {
            propertyService.getProperty(propertyId);
            fail("My method didn't throw when I expected it to");
        } catch (final PropertyNotFoundException propertyNotFoundException) {
            assertThat(propertyNotFoundException.getMessage()
                    , is("Property Id " + propertyId + " can not be found"));
            verify(propertyRepository).getProperty(propertyId);
            verifyNoMoreInteractions(propertyRepository);
        }
    }

    @Test
    public void shouldReturnAllProperties() {
        when(propertyRepository.getProperties())
                .thenReturn(aProperty()
                        .withResidentialLettings(createResidentialLettingProperties())
                        .build());
        final Property actualProperty = propertyService.getProperties();
        assertThat(actualProperty.getResidentialLettings(), containsInAnyOrder(
                aResidentialLetting()
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
                        .build()
                )
        );
        verify(propertyRepository).getProperties();
        verifyNoMoreInteractions(propertyRepository);
    }

    @Test
    public void shouldReturnAllPropertiesThatMatchSearchCriteria() {
        final String location = "london";
        final BigDecimal minimumPrice = valueOf(2000);
        final BigDecimal maximumPrice = valueOf(4000);
        final List<PropertyType> propertyTypes = asList(HOUSE, BUNGALOWS);
        final int bedroomAmount = 3;
        when(propertyRepository.getPropertiesBySearchCriteria(location, minimumPrice, maximumPrice, propertyTypes
                , bedroomAmount))
                .thenReturn(aProperty()
                        .withResidentialLettings(createResidentialLettingProperties())
                        .build()
                );

        final Property actualProperty = propertyService.getPropertiesBySearchCriteria(location, minimumPrice
                , maximumPrice, propertyTypes, bedroomAmount);

        assertThat(actualProperty.getResidentialLettings(), containsInAnyOrder(
                aResidentialLetting()
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
                        .build()
                )
        );
        verify(propertyRepository).getPropertiesBySearchCriteria(location, minimumPrice, maximumPrice, propertyTypes
                , bedroomAmount);
        verifyNoMoreInteractions(propertyRepository);
    }

    @Test
    public void shouldGetFeaturedProperties() {
        when(propertyRepository.getFeaturedProperties()).thenReturn(aProperty()
                .withResidentialLettings(createResidentialLettingProperties())
                .build()
        );

        final Property actualProperty = propertyService.getProperties(true);
        assertThat(actualProperty.getResidentialLettings(), containsInAnyOrder(
                aResidentialLetting()
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
                        .build()
                )
        );
        verify(propertyRepository).getFeaturedProperties();
        verifyNoMoreInteractions(propertyRepository);
    }

    @Test
    public void shouldGetAllPropertiesWhenFlagFalse() {
        when(propertyRepository.getProperties()).thenReturn(aProperty()
                .withResidentialLettings(createResidentialLettingProperties())
                .build()
        );

        final Property actualProperty = propertyService.getProperties(false);

        assertThat(actualProperty.getResidentialLettings(), containsInAnyOrder(
                aResidentialLetting()
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
                        .build()
                )
        );
        verify(propertyRepository).getProperties();
        verifyNoMoreInteractions(propertyRepository);
    }
}