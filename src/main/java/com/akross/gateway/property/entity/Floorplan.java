package com.akross.gateway.property.entity;

import java.time.LocalDateTime;

public class Floorplan extends UrlModified {

    public Floorplan() {
        this(null, null);
    }

    public Floorplan(final LocalDateTime modified, final String url) {
        super(modified, url);
    }
}