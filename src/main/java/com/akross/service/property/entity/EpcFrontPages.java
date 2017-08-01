package com.akross.service.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

public class EpcFrontPages {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<EpcFrontPage> epcFrontPage;

    public EpcFrontPages(@JacksonXmlProperty(localName = "epcFrontPage") final List<EpcFrontPage> epcFrontPage) {
        this.epcFrontPage = epcFrontPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpcFrontPages that = (EpcFrontPages) o;
        return Objects.equals(epcFrontPage, that.epcFrontPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(epcFrontPage);
    }

    @Override
    public String toString() {
        return "EpcFrontPages{" +
                "epcFrontPage=" + epcFrontPage +
                '}';
    }
}