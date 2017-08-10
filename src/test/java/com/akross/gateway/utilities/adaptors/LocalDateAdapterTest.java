package com.akross.gateway.utilities.adaptors;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static java.time.LocalDate.of;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;

@RunWith(MockitoJUnitRunner.class)
public class LocalDateAdapterTest {

    @Rule
    public ExpectedException expectedException = none();

    @InjectMocks
    private LocalDateAdapter localDateAdapter;

    @Test
    public void shouldGetLocalDateObject() throws Exception {
        final String localDate = "2017-08-03";
        final LocalDate actualLocalDate = localDateAdapter.unmarshal(localDate);
        assertThat(actualLocalDate, is(of(2017, 8, 3)));
    }

    @Test
    public void shouldGetStringValueOfLocalDate() throws Exception {
        final LocalDate localDate = of(2017, 8, 3);
        final String actualLocalDate = localDateAdapter.marshal(localDate);
        assertThat(actualLocalDate, is("2017-08-03"));
    }
}