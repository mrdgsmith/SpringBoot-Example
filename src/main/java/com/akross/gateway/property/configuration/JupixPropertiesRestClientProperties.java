package com.akross.gateway.property.configuration;

import com.akross.gateway.JupixBaseProperties;
import org.springframework.beans.factory.annotation.Value;

public class JupixPropertiesRestClientProperties extends JupixBaseProperties {

    private static final String PREFIX = "${jupix.restService.property";
    private static final String URL_PREFIX = "${jupix.restService";

    private final String path;
    private final String clientId;
    private final String passphrase;
    private final Double version;

    public JupixPropertiesRestClientProperties(@Value(URL_PREFIX + ".rootUrl}") final String rootUrl
            , @Value(PREFIX + ".path}") final String path
            , @Value(PREFIX + ".clientId}") final String clientId
            , @Value(PREFIX + ".passphrase}") final String passphrase
            , @Value(PREFIX + ".version}") final Double version) {
        super(rootUrl);
        this.path = path;
        this.clientId = clientId;
        this.passphrase = passphrase;
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public String getClientId() {
        return clientId;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public Double getVersion() {
        return version;
    }
}