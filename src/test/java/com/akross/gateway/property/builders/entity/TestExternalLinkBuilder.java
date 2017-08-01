package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.ExternalLink;

import java.time.LocalDateTime;

public final class TestExternalLinkBuilder {
    private String url;
    private LocalDateTime modified;
    private String description;

    private TestExternalLinkBuilder() {
    }

    public static TestExternalLinkBuilder anExternalLink() {
        return new TestExternalLinkBuilder();
    }

    public TestExternalLinkBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public TestExternalLinkBuilder withModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestExternalLinkBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ExternalLink build() {
        return new ExternalLink(url, description, modified);
    }
}
