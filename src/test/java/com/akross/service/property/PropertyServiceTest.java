package com.akross.service.property;


import com.akross.domain.property.container.Property;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.exception.property.PropertyNotFoundException;
import com.akross.repository.PropertyRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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

//    private static List<ResidentialLetting> createInvalidFeaturedResidentialLettingProperties() {
//        return asList(aResidentialLetting()
//                        .withDepartment(SALES)
//                        .withIsFeaturedProperty(true)
//                        .withAvailability(LET)
//                        .withDisplayAddress("Should not be here!")
//                        .withDateLastModified(of(2015, OCTOBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()
//                , aResidentialLetting()
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(false)
//                        .withAvailability(LET)
//                        .withDisplayAddress("Should not be here!")
//                        .withDateLastModified(of(2015, SEPTEMBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()
//                , aResidentialLetting()
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(true)
//                        .withAvailability(WITHDRAWN)
//                        .withDisplayAddress("Should not be here!")
//                        .withDateLastModified(of(2015, NOVEMBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build());
//    }

//    private static List<ResidentialLetting> createValidFeaturedResidentialLettingProperties() {
//        return asList(aResidentialLetting()
//                        .withPropertyId(5L)
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(true)
//                        .withAvailability(LET)
//                        .withDisplayAddress("foo3")
//                        .withMainSummary("mainSummary3")
//                        .withAddress3("london")
//                        .withPropertyType(HOUSE)
//                        .withPropertyBedrooms(3)
//                        .withRent(valueOf(3000))
//                        .withPropertyBedrooms(3)
//                        .withIsLetPOA(false)
//                        .withRentFrequency(PCM)
//                        .withDateLastModified(of(2015, OCTOBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 12))
//                        .build()
//                , aResidentialLetting()
//                        .withPropertyId(4L)
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(true)
//                        .withAvailability(LET)
//                        .withDisplayAddress("foo2")
//                        .withMainSummary("mainSummary2")
//                        .withAddress3("London")
//                        .withPropertyType(BUNGALOWS)
//                        .withPropertyBedrooms(3)
//                        .withRent(valueOf(2000))
//                        .withIsLetPOA(true)
//                        .withRentFrequency(PCM)
//                        .withDateLastModified(of(2015, AUGUST, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 13))
//                        .build()
//                , aResidentialLetting()
//                        .withPropertyId(3L)
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(true)
//                        .withAvailability(LET)
//                        .withDisplayAddress("foo4")
//                        .withMainSummary("mainSummary4")
//                        .withRent(valueOf(4000))
//                        .withIsLetPOA(true)
//                        .withRentFrequency(PCM)
//                        .withDateLastModified(of(2015, AUGUST, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 10))
//                        .build()
//                , aResidentialLetting()
//                        .withPropertyId(2L)
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(true)
//                        .withAvailability(LET)
//                        .withDisplayAddress("foo1")
//                        .withMainSummary("mainSummary1")
//                        .withRent(valueOf(1000))
//                        .withIsLetPOA(false)
//                        .withRentFrequency(PCM)
//                        .withDateLastModified(of(2015, AUGUST, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()
//        );
//    }

//    private static List<ResidentialLetting> createResidentialLettingProperties() {
//        return concat(Stream.of(aResidentialLetting()
//                        .withPropertyId(12L)
//                        .withDepartment(SALES)
//                        .withIsFeaturedProperty(true)
//                        .withAvailability(LET)
//                        .withIsLetPOA(true)
//                        .withDisplayAddress("Should not be here!")
//                        .withDateLastModified(of(2015, OCTOBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()
//                , aResidentialLetting()
//                        .withPropertyId(13L)
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(false)
//                        .withAvailability(LET)
//                        .withIsLetPOA(true)
//                        .withDisplayAddress("Should not be here!")
//                        .withDateLastModified(of(2015, SEPTEMBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()
//                , aResidentialLetting()
//                        .withPropertyId(14L)
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(true)
//                        .withIsLetPOA(true)
//                        .withAvailability(WITHDRAWN)
//                        .withDisplayAddress("Should not be here!")
//                        .withDateLastModified(of(2015, NOVEMBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()), createValidFeaturedResidentialLettingProperties().stream())
//                .collect(toList());
//    }

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
//        when(propertyClient.getProperties().getResidentialLettings())
//                .thenReturn(createResidentialLettingProperties());

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
    public void shouldReturnAllPropertiesWithSearchCriteria() {
//        when(propertyRepository.getProperties().getResidentialLettings())
//                .thenReturn(createResidentialLettingProperties());

        when(propertyRepository.getPropertiesBySearchCriteria("london"
                , valueOf(2000)
                , valueOf(4000)
                , asList(HOUSE, BUNGALOWS), 3))
                .thenReturn(aProperty()
                        .withResidentialLettings(createResidentialLettingProperties())
                        .build()
                );

        final Property actualProperty = propertyService.getPropertiesBySearchCriteria("london"
                , valueOf(2000)
                , valueOf(4000)
                , asList(HOUSE, BUNGALOWS), 3);

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
        verify(propertyRepository).getPropertiesBySearchCriteria("london"
                , valueOf(2000)
                , valueOf(4000)
                , asList(HOUSE, BUNGALOWS), 3);
        verifyNoMoreInteractions(propertyRepository);
    }

    @Test
    public void shouldGetMostRecentFeaturedResidentialLettingProperties() {
//        when(propertyClient.getProperties().getResidentialLettings())
//                .thenReturn(concat(createInvalidFeaturedResidentialLettingProperties().stream()
//                        , createValidFeaturedResidentialLettingProperties().stream())
//                        .collect(toList()));

        when(propertyRepository.getFeaturedProperties())
                .thenReturn(
                        aProperty()
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
    public void shouldGetAllResidentialLettingPropertiesWhenFlagFalse() {
//        when(propertyClient.getProperties().getResidentialLettings())
//                .thenReturn(concat(createInvalidFeaturedResidentialLettingProperties().stream()
//                        , createValidFeaturedResidentialLettingProperties().stream())
//                        .collect(toList()));

        when(propertyRepository.getProperties())
                .thenReturn(
                        aProperty()
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