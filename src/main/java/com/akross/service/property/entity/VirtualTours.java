package com.akross.service.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

public class VirtualTours {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<VirtualTour> virtualTour;

    public VirtualTours(@JacksonXmlProperty(localName = "brochure") final List<VirtualTour> virtualTour) {
        this.virtualTour = virtualTour;
    }

    public List<VirtualTour> getVirtualTour() {
        return virtualTour;
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