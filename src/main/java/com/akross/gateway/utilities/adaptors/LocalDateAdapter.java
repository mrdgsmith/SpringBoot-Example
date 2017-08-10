package com.akross.gateway.utilities.adaptors;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final DateTimeFormatter DATE_FORMATTER = ofPattern("yyyy-MM-dd");

    @Override
    public String marshal(final LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }

    @Override
    public LocalDate unmarshal(final String localDate) {
        return LocalDate.parse(localDate, DATE_FORMATTER);
    }
}