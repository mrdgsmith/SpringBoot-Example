package com.akross.repository.property;

import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder;
import com.akross.domain.property.utilities.PropertyConverter;
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

import java.time.LocalTime;

import static com.akross.domain.property.Department.LETTINGS;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.Availability.LET;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.RentFrequency.PCM;
import static com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static java.time.Month.AUGUST;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
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
//                        .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
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
//                        .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
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
//                        .withDateLastModified(LocalDate.of(2015, AUGUST, 21))
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
//                        .withDateLastModified(LocalDate.of(2015, AUGUST, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()
//        );
//    }
//
//    private static List<ResidentialLetting> createResidentialLettingProperties() {
//        return concat(of(aResidentialLetting()
//                        .withPropertyId(12L)
//                        .withDepartment(SALES)
//                        .withIsFeaturedProperty(true)
//                        .withAvailability(LET)
//                        .withIsLetPOA(true)
//                        .withDisplayAddress("Should not be here!")
//                        .withDateLastModified(LocalDate.of(2015, OCTOBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()
//                , aResidentialLetting()
//                        .withPropertyId(13L)
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(false)
//                        .withAvailability(LET)
//                        .withIsLetPOA(true)
//                        .withDisplayAddress("Should not be here!")
//                        .withDateLastModified(LocalDate.of(2015, SEPTEMBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()
//                , aResidentialLetting()
//                        .withPropertyId(14L)
//                        .withDepartment(LETTINGS)
//                        .withIsFeaturedProperty(true)
//                        .withIsLetPOA(true)
//                        .withAvailability(WITHDRAWN)
//                        .withDisplayAddress("Should not be here!")
//                        .withDateLastModified(LocalDate.of(2015, NOVEMBER, 21))
//                        .withTimeLastModified(LocalTime.of(21, 55, 14))
//                        .build()), createValidFeaturedResidentialLettingProperties().stream())
//                .collect(toList());
//    }

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

        final com.akross.domain.property.Property property = propertyRepository.getProperty(propertyId);
        assertThat(property, instanceOf(com.akross.domain.property.residentialsalesandletting
                .residentialletting.ResidentialLetting.class));
        assertThat(property, is(ResidentialLettingBuilder.aResidentialLetting()
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

}