package com.akross.repository.property;

import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder;
import com.akross.domain.property.utilities.PropertyConverter;
import com.akross.exception.property.PropertyNotFoundException;
import com.akross.repository.PropertyRepositoryInMemory;
import com.akross.repository.property.entity.Property;
import com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.akross.domain.property.Department.LETTINGS;
import static com.akross.domain.property.residentialsalesandletting.PropertyType.BUNGALOWS;
import static com.akross.domain.property.residentialsalesandletting.PropertyType.HOUSE;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.Availability.LET;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.RentFrequency.PCM;
import static com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static java.time.Month.AUGUST;
import static java.time.Month.OCTOBER;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PropertyRepositoryTest {

    @Rule
    public ExpectedException expectedException = none();

    @Mock
    private PropertyRepositoryInMemory<Property> propertyRepositoryInMemory;

    @Mock
    private PropertyConverter propertyConverter;

    @InjectMocks
    private PropertyRepository propertyRepository;

    private static List<Property> createValidResidentialLettingProperties() {
        return asList(aResidentialLetting()
                        .withPropertyId(5L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo3")
                        .withMainSummary("mainSummary3")
                        .withAddress3("london")
                        .withPropertyType(HOUSE)
                        .withRent(valueOf(3000))
                        .withPropertyBedrooms(3)
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
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
                        .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
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
                        .withDateLastModified(LocalDate.of(2015, AUGUST, 21))
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
                        .withDateLastModified(LocalDate.of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
        );
    }

    @Test
    public void shouldReturnResidentialLettingProperty() {
        final Long propertyId = 3L;
        final ResidentialLetting residentialLetting = aResidentialLetting()
                .withPropertyId(propertyId)
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
                .build();
        when(propertyRepositoryInMemory.findOne(propertyId)).thenReturn(residentialLetting);
        when(propertyConverter.convertToResidentialLetting(residentialLetting))
                .thenReturn(ResidentialLettingBuilder.aResidentialLetting()
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
                        .build());

        final com.akross.domain.property.Property actualProperty = propertyRepository.getProperty(propertyId);
        assertThat(actualProperty, instanceOf(com.akross.domain.property.residentialsalesandletting
                .residentialletting.ResidentialLetting.class));
        assertThat(actualProperty, is(ResidentialLettingBuilder.aResidentialLetting()
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
        verify(propertyRepositoryInMemory).findOne(propertyId);
        verify(propertyConverter).convertToResidentialLetting(residentialLetting);
        verifyNoMoreInteractions(propertyRepositoryInMemory, propertyConverter);
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenPropertyNotFound() {
        final Long propertyId = 1L;
        when(propertyRepositoryInMemory.findOne(propertyId)).thenReturn(null);
        try {
            propertyRepository.getProperty(propertyId);
            fail("My method didn't throw when I expected it to");
        } catch (final PropertyNotFoundException propertyNotFoundException) {
            assertThat(propertyNotFoundException.getMessage()
                    , is("Property Id " + propertyId + " can not be found"));
            verify(propertyRepositoryInMemory).findOne(propertyId);
            verifyZeroInteractions(propertyConverter);
            verifyNoMoreInteractions(propertyRepositoryInMemory, propertyConverter);
        }
    }

    @Test
    public void shouldReturnAllProperties() {
        final List<Property> validFeaturedResidentialLettingProperties =
                createValidResidentialLettingProperties();
        when(propertyRepositoryInMemory.findAll()).thenReturn(validFeaturedResidentialLettingProperties);

        setupPropertyConverterWithValidFeaturedProperties();

        final com.akross.domain.property.container.Property actualProperties = propertyRepository.getProperties();
        assertThat(actualProperties.getResidentialLettings(), hasItems(ResidentialLettingBuilder.aResidentialLetting()
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
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 12))
                        .build()
                , ResidentialLettingBuilder.aResidentialLetting()
                        .withPropertyId(4L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo2")
                        .withMainSummary("mainSummary2")
                        .withAddress3("London")
                        .withPropertyType(BUNGALOWS)
                        .withPropertyBedrooms(3)
                        .withRent(null)
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 13))
                        .build()
                , ResidentialLettingBuilder.aResidentialLetting()
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
                , ResidentialLettingBuilder.aResidentialLetting()
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
                )
        );

        verify(propertyRepositoryInMemory).findAll();
        validFeaturedResidentialLettingProperties.forEach(
                property -> verify(propertyConverter).convertToResidentialLetting((ResidentialLetting) property)
        );
        verifyNoMoreInteractions(propertyRepositoryInMemory, propertyConverter);
    }

    @Test
    public void shouldReturnAllPropertiesWithSearchCriteria() {
        final String location = "london";
        final BigDecimal minimumPrice = valueOf(2000);
        final BigDecimal maximumPrice = valueOf(4000);
        final List<PropertyType> propertyType = asList(HOUSE, BUNGALOWS);
        final int bedroomAmount = 3;

        when(propertyRepositoryInMemory.getPropertiesBySearchCriteria(location, minimumPrice, maximumPrice, propertyType
                , bedroomAmount))
                .thenReturn(asList(aResidentialLetting()
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
                                .withIsLetPOA(false)
                                .withRentFrequency(PCM)
                                .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
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
                                .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
                                .withTimeLastModified(LocalTime.of(21, 55, 13))
                                .build()));

        setupPropertyConverterWithValidFeaturedProperties();

        final com.akross.domain.property.container.Property actualProperty =
                propertyRepository.getPropertiesBySearchCriteria(location, minimumPrice, maximumPrice, propertyType
                        , bedroomAmount);

        assertThat(actualProperty.getResidentialLettings(), contains(ResidentialLettingBuilder.aResidentialLetting()
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
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 12))
                        .build()
                , ResidentialLettingBuilder.aResidentialLetting()
                        .withPropertyId(4L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo2")
                        .withMainSummary("mainSummary2")
                        .withAddress3("London")
                        .withPropertyType(BUNGALOWS)
                        .withPropertyBedrooms(3)
                        .withRent(null)
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 13))
                        .build()
                )
        );

        verify(propertyRepositoryInMemory).getPropertiesBySearchCriteria(location
                , minimumPrice
                , maximumPrice
                , propertyType
                , bedroomAmount
        );
        verify(propertyConverter).convertToResidentialLetting(aResidentialLetting()
                .withPropertyId(5L)
                .build());
        verify(propertyConverter).convertToResidentialLetting(aResidentialLetting()
                .withPropertyId(4L)
                .build());
        verifyNoMoreInteractions(propertyRepositoryInMemory, propertyConverter);

    }

    @Test
    public void shouldGetMostRecentFeaturedResidentialLettingProperties() {
        final List<Property> validResidentialLettingProperties = createValidResidentialLettingProperties();
        when(propertyRepositoryInMemory.getFeaturedProperties())
                .thenReturn(validResidentialLettingProperties);

        setupPropertyConverterWithValidFeaturedProperties();

        final com.akross.domain.property.container.Property actualProperty
                = propertyRepository.getFeaturedProperties();

        assertThat(actualProperty.getResidentialLettings(), contains(ResidentialLettingBuilder.aResidentialLetting()
                        .withPropertyId(5L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo3")
                        .withMainSummary("mainSummary3")
                        .withAddress3("london")
                        .withPropertyType(HOUSE)
                        .withRent(valueOf(3000))
                        .withPropertyBedrooms(3)
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 12))
                        .build()
                , ResidentialLettingBuilder.aResidentialLetting()
                        .withPropertyId(4L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo2")
                        .withMainSummary("mainSummary2")
                        .withAddress3("London")
                        .withPropertyType(BUNGALOWS)
                        .withPropertyBedrooms(3)
                        .withRent(null)
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 13))
                        .build()
                , ResidentialLettingBuilder.aResidentialLetting()
                        .withPropertyId(3L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo4")
                        .withMainSummary("mainSummary4")
                        .withRent(null)
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(LocalDate.of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 10))
                        .build()
                , ResidentialLettingBuilder.aResidentialLetting()
                        .withPropertyId(2L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo1")
                        .withMainSummary("mainSummary1")
                        .withRent(valueOf(1000))
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(LocalDate.of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
        ));

        verify(propertyRepositoryInMemory).getFeaturedProperties();
        validResidentialLettingProperties.forEach(
                property -> verify(propertyConverter).convertToResidentialLetting((ResidentialLetting) property)
        );
        verifyNoMoreInteractions(propertyRepositoryInMemory, propertyConverter);
    }

    private void setupPropertyConverterWithValidFeaturedProperties() {
        when(propertyConverter.convertToResidentialLetting(aResidentialLetting()
                .withPropertyId(5L)
                .build()))
                .thenReturn(ResidentialLettingBuilder.aResidentialLetting()
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
                        .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 12))
                        .build());

        when(propertyConverter.convertToResidentialLetting(aResidentialLetting()
                .withPropertyId(4L)
                .build()))
                .thenReturn(ResidentialLettingBuilder.aResidentialLetting()
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
                        .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 13))
                        .build());

        when(propertyConverter.convertToResidentialLetting(aResidentialLetting()
                .withPropertyId(3L)
                .build()))
                .thenReturn(ResidentialLettingBuilder.aResidentialLetting()
                        .withPropertyId(3L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo4")
                        .withMainSummary("mainSummary4")
                        .withRent(valueOf(4000))
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(LocalDate.of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 10))
                        .build());

        when(propertyConverter.convertToResidentialLetting(aResidentialLetting()
                .withPropertyId(2L)
                .build()))
                .thenReturn(ResidentialLettingBuilder.aResidentialLetting()
                        .withPropertyId(2L)
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo1")
                        .withMainSummary("mainSummary1")
                        .withRent(valueOf(1000))
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(LocalDate.of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build());
    }
}