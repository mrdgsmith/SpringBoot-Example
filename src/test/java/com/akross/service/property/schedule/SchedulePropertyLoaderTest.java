package com.akross.service.property.schedule;

import com.akross.gateway.PropertyClient;
import com.akross.repository.PropertyRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.akross.repository.property.entity.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SchedulePropertyLoaderTest {

    @Rule
    public ExpectedException expectedException = none();

    @Mock
    private PropertyClient propertyClient;

    @Mock
    private PropertyRepository propertyRepository;

    @InjectMocks
    private SchedulePropertyLoader schedulePropertyLoader;

    @Test
    @SuppressWarnings("unchecked")
    public void shouldLoadProperties() {
        final List residentialLettings = asList(aResidentialLetting()
                        .withPropertyId(1L)
                        .build()
                , aResidentialLetting()
                        .withPropertyId(2L)
                        .build()
        );

        when(propertyClient.getProperties()).thenReturn(residentialLettings);

        schedulePropertyLoader.getProperties();

        verify(propertyClient).getProperties();
        verify(propertyRepository).deleteAllProperties();
        verify(propertyRepository).save(residentialLettings);
        verifyNoMoreInteractions(propertyClient, propertyRepository);
    }

    @Test
    public void shouldNotDeletePropertiesInDatabaseIfClientReturnsNoProperties() {
        when(propertyClient.getProperties()).thenReturn(emptyList());

        schedulePropertyLoader.getProperties();
        verify(propertyClient).getProperties();
        verifyZeroInteractions(propertyRepository);
        verifyNoMoreInteractions(propertyClient, propertyRepository);
    }

    @Test
    public void shouldNotDeletePropertiesInDatabaseIfClientReturnsNoNull() {
        when(propertyClient.getProperties()).thenReturn(null);

        schedulePropertyLoader.getProperties();
        verify(propertyClient).getProperties();
        verifyZeroInteractions(propertyRepository);
        verifyNoMoreInteractions(propertyClient, propertyRepository);
    }
}