package com.akross.gateway.utilities.adaptors;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalTime;

import static java.time.LocalTime.of;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;

@RunWith(MockitoJUnitRunner.class)
public class LocalTimeAdapterTest {

    @Rule
    public ExpectedException expectedException = none();

    @InjectMocks
    private LocalTimeAdapter localTimeAdapter;

    @Test
    public void shouldGetLocalTimeObject() throws Exception {
        final String localTime = "15:33:28";
        final LocalTime actualLocalTime = localTimeAdapter.unmarshal(localTime);
        assertThat(actualLocalTime, is(of(15, 33, 28)));
    }

    @Test
    public void shouldGetStringValueOfLocalTime() throws Exception {
        final LocalTime localTime = of(15, 33, 28);
        final String actualLocalTime = localTimeAdapter.marshal(localTime);
        assertThat(actualLocalTime, is("15:33:28"));
    }
}