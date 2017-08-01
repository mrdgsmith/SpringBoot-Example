package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class Floorplans {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<Floorplan> floorplan;

    public Floorplans(@JacksonXmlProperty(localName = "floorplan") final List<Floorplan> floorplan) {
        this.floorplan = floorplan;
    }

    public List<Floorplan> getFloorPlan() {
        return Objects.nonNull(floorplan) ? Collections.unmodifiableList(floorplan) : emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floorplans that = (Floorplans) o;
        return Objects.equals(floorplan, that.floorplan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorplan);
    }

    @Override
    public String toString() {
        return "Floorplans{" +
                "floorplan=" + floorplan +
                '}';
    }
}