package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.nonNull;

public class EpcFrontPages {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<EpcFrontPage> epcFrontPage;

    public EpcFrontPages(@JacksonXmlProperty(localName = "epcFrontPage") final List<EpcFrontPage> epcFrontPage) {
        this.epcFrontPage = nonNull(epcFrontPage) ? unmodifiableList(epcFrontPage) : emptyList();
    }

    public List<EpcFrontPage> getEpcFrontPage() {
        return unmodifiableList(epcFrontPage);
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