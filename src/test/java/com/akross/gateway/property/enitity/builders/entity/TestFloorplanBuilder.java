package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.Floorplan;
import com.akross.gateway.property.entity.UrlModified;

import java.time.LocalDateTime;

public final class TestFloorplanBuilder {
    private LocalDateTime modified;
    private String url;

    private TestFloorplanBuilder() {
    }

    public static TestFloorplanBuilder anFloorplan() {
        return new TestFloorplanBuilder();
    }

    public TestFloorplanBuilder withModified(final LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestFloorplanBuilder withUrl(final String url) {
        this.url = url;
        return this;
    }

    public UrlModified build() {
        return new Floorplan(modified, url);
    }
}