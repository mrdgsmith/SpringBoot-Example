package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.EpcGraph;

import java.time.LocalDateTime;

public final class TestEpcGraphBuilder {
    private LocalDateTime modified;
    private String url;

    private TestEpcGraphBuilder() {
    }

    public static TestEpcGraphBuilder anEpcGraph() {
        return new TestEpcGraphBuilder();
    }

    public TestEpcGraphBuilder withModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestEpcGraphBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public EpcGraph build() {
        return new EpcGraph(modified, url);
    }
}
