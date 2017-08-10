package com.akross.gateway.utilities.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {

    private static final DateTimeFormatter TIME_FORMATTER = ofPattern("HH:mm:ss");

    @Override
    public String marshal(final LocalTime localTime) {
        return localTime.format(TIME_FORMATTER);
    }

    @Override
    public LocalTime unmarshal(final String localTime) {
        return LocalTime.parse(localTime, TIME_FORMATTER);
    }
}