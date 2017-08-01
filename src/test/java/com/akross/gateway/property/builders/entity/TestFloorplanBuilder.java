package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.Floorplan;

import java.time.LocalDateTime;

public final class TestFloorplanBuilder {
    private LocalDateTime modified;
    private String url;

    private TestFloorplanBuilder() {
    }

    public static TestFloorplanBuilder aFloorplan() {
        return new TestFloorplanBuilder();
    }

    public TestFloorplanBuilder withModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestFloorplanBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public Floorplan build() {
        return new Floorplan(modified, url);
    }
}
