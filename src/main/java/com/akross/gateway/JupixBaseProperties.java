package com.akross.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public abstract class JupixBaseProperties {

    private final String rootUrl;

    public JupixBaseProperties(final String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public String getRootUrl() {
        return rootUrl;
    }
}