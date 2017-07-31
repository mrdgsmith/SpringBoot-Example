package com.akross.service.property.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class JupixPropertiesRestServiceConfiguration {

    private static final String PREFIX = "${jupix.restService";

    private final String rootUrl;
    private final String propertyPath;
    private final String clientId;
    private final String passphrase;
    private final String version;

    public JupixPropertiesRestServiceConfiguration(final @Value(PREFIX + ".rootUrl}") String rootUrl
            , final @Value(PREFIX + ".propertyPath}") String propertyPath
            , final @Value(PREFIX + ".clientId}") String clientId
            , final @Value(PREFIX + ".passphrase}") String passphrase
            , final @Value(PREFIX + ".version}") String version) {
        this.rootUrl = rootUrl;
        this.propertyPath = propertyPath;
        this.clientId = clientId;
        this.passphrase = passphrase;
        this.version = version;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public String getPropertyPath() {
        return propertyPath;
    }

    public String getClientId() {
        return clientId;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public String getVersion() {
        return version;
    }
}