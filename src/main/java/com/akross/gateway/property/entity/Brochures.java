package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class Brochures {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<Brochure> brochure;

    public Brochures(@JacksonXmlProperty(localName = "brochure") final List<Brochure> brochure) {
        this.brochure = brochure;
    }

    public List<Brochure> getBrochure() {
        return Objects.nonNull(brochure) ? Collections.unmodifiableList(brochure) : emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brochures brochures = (Brochures) o;
        return Objects.equals(brochure, brochures.brochure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brochure);
    }

    @Override
    public String toString() {
        return "Brochures{" +
                "brochure=" + brochure +
                '}';
    }
}