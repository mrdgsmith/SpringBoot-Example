package com.akross.gateway.property.entity;

import java.time.LocalDateTime;

public class Brochure extends UrlModified {

    private Brochure() {
        this(null, null);
    }

    public Brochure(final LocalDateTime modified, final String url) {
        super(modified, url);
    }
}