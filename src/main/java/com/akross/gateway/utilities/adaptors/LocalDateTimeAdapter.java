package com.akross.gateway.utilities.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public LocalDateTime unmarshal(final String localDateTime) throws Exception {
        return LocalDateTime.parse(localDateTime, DATE_TIME_FORMATTER);
    }

    @Override
    public String marshal(final LocalDateTime localDateTime) throws Exception {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }
}
