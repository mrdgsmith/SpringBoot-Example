package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.EpcFrontPage;

import java.time.LocalDateTime;

public final class TestEpcFrontPageBuilder {
    private LocalDateTime modified;
    private String url;

    private TestEpcFrontPageBuilder() {
    }

    public static TestEpcFrontPageBuilder anEpcFrontPage() {
        return new TestEpcFrontPageBuilder();
    }

    public TestEpcFrontPageBuilder withModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestEpcFrontPageBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public EpcFrontPage build() {
        return new EpcFrontPage(modified, url);
    }
}
