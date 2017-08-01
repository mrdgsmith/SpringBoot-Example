package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.VirtualTour;
import com.akross.gateway.property.entity.VirtualTours;

import java.util.List;

public final class TestVirtualToursBuilder {
    private List<VirtualTour> virtualTour;

    private TestVirtualToursBuilder() {
    }

    public static TestVirtualToursBuilder aVirtualTours() {
        return new TestVirtualToursBuilder();
    }

    public TestVirtualToursBuilder withVirtualTour(List<VirtualTour> virtualTour) {
        this.virtualTour = virtualTour;
        return this;
    }

    public VirtualTours build() {
        return new VirtualTours(virtualTour);
    }
}
