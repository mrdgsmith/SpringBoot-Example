package com.akross.gateway.property.entity;

import java.time.LocalDateTime;

public class EpcGraph extends UrlModified {

    private EpcGraph() {
        this(null, null);
    }

    public EpcGraph(final LocalDateTime modified, final String url) {
        super(modified, url);
    }
}