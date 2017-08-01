package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.ExternalLink;
import com.akross.gateway.property.entity.ExternalLinks;

import java.util.List;

public final class TestExternalLinksBuilder {
    private List<ExternalLink> externalLink;

    private TestExternalLinksBuilder() {
    }

    public static TestExternalLinksBuilder anExternalLinks() {
        return new TestExternalLinksBuilder();
    }

    public TestExternalLinksBuilder withExternalLink(List<ExternalLink> externalLink) {
        this.externalLink = externalLink;
        return this;
    }

    public ExternalLinks build() {
        return new ExternalLinks(externalLink);
    }
}
