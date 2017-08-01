package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.Image;

import java.time.LocalDateTime;

public final class TestImageBuilder {
    private LocalDateTime modified;
    private String url;

    private TestImageBuilder() {
    }

    public static TestImageBuilder anImage() {
        return new TestImageBuilder();
    }

    public TestImageBuilder withModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public TestImageBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public Image build() {
        return new Image(modified, url);
    }
}
