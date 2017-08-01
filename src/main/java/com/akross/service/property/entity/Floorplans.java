package com.akross.service.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

public class Floorplans {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<Floorplan> floorplan;

    public Floorplans(@JacksonXmlProperty(localName = "floorplan") final List<Floorplan> floorplan) {
        this.floorplan = floorplan;
    }

    public List<Floorplan> getFloorPlan() {
        return floorplan;
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