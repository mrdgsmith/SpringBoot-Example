package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.nonNull;

public class VirtualTours {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<VirtualTour> virtualTour;

    public VirtualTours(@JacksonXmlProperty(localName = "brochure") final List<VirtualTour> virtualTour) {
        this.virtualTour = nonNull(virtualTour) ? unmodifiableList(virtualTour) : emptyList();
    }

    public List<VirtualTour> getVirtualTour() {
        return unmodifiableList(virtualTour);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualTours that = (VirtualTours) o;
        return Objects.equals(virtualTour, that.virtualTour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(virtualTour);
    }

    @Override
    public String toString() {
        return "VirtualTours{" +
                "virtualTour=" + virtualTour +
                '}';
    }
}