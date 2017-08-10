package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.ExternalLink;

import java.time.LocalDateTime;

public final class TestExternalLinkBuilder {
    private String description;
    private LocalDateTime modified;
    private String url;

    private TestExternalLinkBuilder() {
    }

    public static TestExternalLinkBuilder anExternalLink() {
        return new TestExternalLinkBuilder();
    }

    public TestExternalLinkBuilder withModified(final LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestExternalLinkBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public TestExternalLinkBuilder withUrl(final String url) {
        this.url = url;
        return this;
    }

    public ExternalLink build() {
        return new ExternalLink(description, modified, url);
    }
}
