package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.Brochure;

import java.time.LocalDateTime;

public final class TestBrochureBuilder {
    private LocalDateTime modified;
    private String url;

    private TestBrochureBuilder() {
    }

    public static TestBrochureBuilder anBrochure() {
        return new TestBrochureBuilder();
    }

    public TestBrochureBuilder withModified(final LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestBrochureBuilder withUrl(final String url) {
        this.url = url;
        return this;
    }

    public Brochure build() {
        return new Brochure(modified, url);
    }
}