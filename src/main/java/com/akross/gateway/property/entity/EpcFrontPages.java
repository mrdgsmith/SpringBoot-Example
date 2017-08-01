package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class EpcFrontPages {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<EpcFrontPage> epcFrontPage;

    public EpcFrontPages(@JacksonXmlProperty(localName = "epcFrontPage") final List<EpcFrontPage> epcFrontPage) {
        this.epcFrontPage = epcFrontPage;
    }

    public List<EpcFrontPage> getEpcFrontPage() {
        return Objects.nonNull(epcFrontPage) ? Collections.unmodifiableList(epcFrontPage) : emptyList();
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