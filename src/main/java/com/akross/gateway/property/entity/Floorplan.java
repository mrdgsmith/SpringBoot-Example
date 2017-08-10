package com.akross.gateway.property.entity;

import java.time.LocalDateTime;

public class Floorplan extends UrlModified {

    private Floorplan() {
        this(null, null);
    }

    public Floorplan(final LocalDateTime modified, final String url) {
        super(modified, url);
    }
}