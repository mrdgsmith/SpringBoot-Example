package com.akross.gateway.property.entity;

import java.time.LocalDateTime;

public class Image extends UrlModified {

    private Image() {
        this(null, null);
    }

    public Image(final LocalDateTime modified, final String url) {
        super(modified, url);
    }
}