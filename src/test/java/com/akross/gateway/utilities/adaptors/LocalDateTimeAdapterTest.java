package com.akross.gateway.utilities.adaptors;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.of;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;

@RunWith(MockitoJUnitRunner.class)
public class LocalDateTimeAdapterTest {

    @Rule
    public ExpectedException expectedException = none();

    @InjectMocks
    private LocalDateTimeAdapter localDateTimeAdapter;

    @Test
    public void shouldGetLocalDateTimeObject() throws Exception {
        final String localDateTime = "2017-08-03 15:33:28";
        final LocalDateTime actualLocalDateTime = localDateTimeAdapter.unmarshal(localDateTime);
        assertThat(actualLocalDateTime, is(of(2017, 8, 3, 15, 33, 28)));
    }

    @Test
    public void shouldGetStringValueOfLocalDatetime() throws Exception {
        final LocalDateTime localDateTime = of(2017, 8, 3, 15, 33, 28);
        final String actualLocalDateTime = localDateTimeAdapter.marshal(localDateTime);
        assertThat(actualLocalDateTime, is("2017-08-03 15:33:28"));
    }
}