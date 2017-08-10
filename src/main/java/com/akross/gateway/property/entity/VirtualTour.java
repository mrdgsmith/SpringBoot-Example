package com.akross.gateway.property.entity;

import java.time.LocalDateTime;

public class VirtualTour extends UrlModified {

    private VirtualTour() {
        this(null, null);
    }

    public VirtualTour(final LocalDateTime modified, final String url) {
        super(modified, url);
    }
}