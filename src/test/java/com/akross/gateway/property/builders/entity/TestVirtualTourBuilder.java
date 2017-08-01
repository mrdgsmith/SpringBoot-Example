package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.VirtualTour;

import java.time.LocalDateTime;

public final class TestVirtualTourBuilder {
    private LocalDateTime modified;
    private String url;

    private TestVirtualTourBuilder() {
    }

    public static TestVirtualTourBuilder aVirtualTour() {
        return new TestVirtualTourBuilder();
    }

    public TestVirtualTourBuilder withModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestVirtualTourBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public VirtualTour build() {
        return new VirtualTour(modified, url);
    }
}
