package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.UrlModified;
import com.akross.gateway.property.entity.VirtualTour;

import java.time.LocalDateTime;

public final class TestVirtualTourBuilder {
    private LocalDateTime modified;
    private String url;

    private TestVirtualTourBuilder() {
    }

    public static TestVirtualTourBuilder anVirtualTour() {
        return new TestVirtualTourBuilder();
    }

    public TestVirtualTourBuilder withModified(final LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestVirtualTourBuilder withUrl(final String url) {
        this.url = url;
        return this;
    }

    public UrlModified build() {
        return new VirtualTour(modified, url);
    }
}
