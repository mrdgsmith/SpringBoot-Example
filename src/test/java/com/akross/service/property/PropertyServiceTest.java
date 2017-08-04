package com.akross.service.property;


import com.akross.domain.container.Property;
import com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.gateway.PropertyClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import static com.akross.domain.Department.LETTINGS;
import static com.akross.domain.Department.SALES;
import static com.akross.domain.residentialsalesandletting.residentialletting.Availability.LET;
import static com.akross.domain.residentialsalesandletting.residentialletting.Availability.WITHDRAWN;
import static com.akross.domain.residentialsalesandletting.residentialletting.RentFrequency.PCM;
import static com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static java.time.Month.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private PropertyClient propertyClient;

    @InjectMocks
    private PropertyService propertyService;

    private static List<ResidentialLetting> createInvalidFeaturedProperties() {
        return asList(aResidentialLetting()
                        .withDepartment(SALES)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(false)
                        .withAvailability(LET)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, SEPTEMBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(WITHDRAWN)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, NOVEMBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build());
    }

    private static List<ResidentialLetting> createValidFeaturedProperties() {
        return asList(aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo3")
                        .withMainSummary("mainSummary3")
                        .withRent(valueOf(3000))
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 12))
                        .build()
                , aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo2")
                        .withMainSummary("mainSummary2")
                        .withRent(valueOf(2000))
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 13))
                        .build()
                , aResidentialLetting()
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
                        .build()
                , aResidentialLetting()
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
        );
    }

    private static List<ResidentialLetting> createProperties() {
        return concat(Stream.of(aResidentialLetting()
                        .withDepartment(SALES)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withIsLetPOA(true)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(false)
                        .withAvailability(LET)
                        .withIsLetPOA(true)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, SEPTEMBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withIsLetPOA(true)
                        .withAvailability(WITHDRAWN)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, NOVEMBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()), createValidFeaturedProperties().stream())
                .collect(toList());
    }

    @Test
    public void shouldReturnAllProperties() throws Exception {
        when(propertyClient.getProperties().getResidentialLettings())
                .thenReturn(createProperties());

        final Property actualProperty = propertyService.getProperties(false);
        assertThat(actualProperty.getResidentialLettings(), containsInAnyOrder(
                aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo3")
                        .withMainSummary("mainSummary3")
                        .withRent(valueOf(3000))
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 12))
                        .build()
                , aResidentialLetting()
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
                , aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo2")
                        .withMainSummary("mainSummary2")
                        .withRent(null)
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 13))
                        .build()
                , aResidentialLetting()
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
                , aResidentialLetting()
                        .withDepartment(SALES)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withIsLetPOA(true)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(false)
                        .withAvailability(LET)
                        .withIsLetPOA(true)
                        .withDisplayAddress("Should not be here!")
                        .withDateLastModified(of(2015, SEPTEMBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 14))
                        .build()
                , aResidentialLetting()
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
    }

    @Test
    public void shouldGetMostRecentFeaturedResidentialLettingProperties() throws Exception {
        when(propertyClient.getProperties().getResidentialLettings())
                .thenReturn(concat(createInvalidFeaturedProperties().stream()
                        , createValidFeaturedProperties().stream())
                        .collect(toList()));

        final Property actualProperty = propertyService.getProperties(true);
        assertThat(actualProperty.getResidentialLettings(), contains(aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo3")
                        .withMainSummary("mainSummary3")
                        .withRent(valueOf(3000))
                        .withIsLetPOA(false)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, OCTOBER, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 12))
                        .build()
                , aResidentialLetting()
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
                , aResidentialLetting()
                        .withDepartment(LETTINGS)
                        .withIsFeaturedProperty(true)
                        .withAvailability(LET)
                        .withDisplayAddress("foo2")
                        .withMainSummary("mainSummary2")
                        .withRent(null)
                        .withIsLetPOA(true)
                        .withRentFrequency(PCM)
                        .withDateLastModified(of(2015, AUGUST, 21))
                        .withTimeLastModified(LocalTime.of(21, 55, 13))
                        .build()
                , aResidentialLetting()
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
        ));
    }
}