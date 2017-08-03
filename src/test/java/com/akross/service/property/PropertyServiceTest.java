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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private PropertyClient propertyClient;

    @InjectMocks
    private PropertyService propertyService;

    private static List<ResidentialLetting> createValidProperties() {
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

    @Test
    public void shouldGetMostRecentFeaturedResidentialLettingProperties() throws Exception {
        final List<ResidentialLetting> invalidProperties = createInvalidProperties();
        final List<ResidentialLetting> validProperties = createValidProperties();

        when(propertyClient.getProperties().getResidentialLettings())
                .thenReturn(concat(invalidProperties.stream(), validProperties.stream())
                        .collect(toList()));

        final Property actualProperty = propertyService.getFeaturedProperties(LETTINGS, 3);
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
        ));
    }

    private static List<ResidentialLetting> createInvalidProperties() {
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
}
