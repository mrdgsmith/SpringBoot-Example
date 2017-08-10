package com.akross.gateway.property.entity;

import java.time.LocalDateTime;

public class EpcFrontPage extends UrlModified {

    private EpcFrontPage() {
        this(null, null);
    }

    public EpcFrontPage(final LocalDateTime modified, final String url) {
        super(modified, url);
    }
}