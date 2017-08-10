package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.EpcFrontPage;
import com.akross.gateway.property.entity.UrlModified;

import java.time.LocalDateTime;

public final class TestEpcFrontPageBuilder {
    private LocalDateTime modified;
    private String url;

    private TestEpcFrontPageBuilder() {
    }

    public static TestEpcFrontPageBuilder anEpcFrontPage() {
        return new TestEpcFrontPageBuilder();
    }

    public TestEpcFrontPageBuilder withModified(final LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestEpcFrontPageBuilder withUrl(final String url) {
        this.url = url;
        return this;
    }

    public UrlModified build() {
        return new EpcFrontPage(modified, url);
    }
}
