package com.akross.service.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

public class Brochures {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<Brochure> brochure;

    public Brochures(@JacksonXmlProperty(localName = "brochure") final List<Brochure> brochure) {
        this.brochure = brochure;
    }

    public List<Brochure> getBrochure() {
        return brochure;
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