package com.akross.gateway.property;

import com.akross.gateway.property.configuration.JupixPropertiesRestClientProperties;
import com.akross.gateway.property.entity.Properties;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.RequestEntity.get;
import static org.springframework.web.util.UriComponentsBuilder.newInstance;

public class HttpPropertyClient {

    private static final String CLIENT_ID = "clientId";
    private static final String PASSPHRASE = "passphrase";
    private static final String VERSION = "version";
    private final RestTemplate jupixPropertiesRestClient;
    private final JupixPropertiesRestClientProperties jupixPropertiesRestClientProperties;

    public HttpPropertyClient(final RestTemplate jupixPropertiesRestClient
            , final JupixPropertiesRestClientProperties jupixPropertiesRestClientProperties) {
        this.jupixPropertiesRestClient = jupixPropertiesRestClient;
        this.jupixPropertiesRestClientProperties = jupixPropertiesRestClientProperties;
    }

    public Properties getProperties() {
        final UriComponentsBuilder builder = newInstance()
                .path(jupixPropertiesRestClientProperties.getPath())
                .queryParam(CLIENT_ID, jupixPropertiesRestClientProperties.getClientId())
                .queryParam(PASSPHRASE, jupixPropertiesRestClientProperties.getPassphrase())
                .queryParam(VERSION, jupixPropertiesRestClientProperties.getVersion());
        return jupixPropertiesRestClient.exchange(get(builder.build().encode().toUri()).build(), Properties.class)
                .getBody();
    }
}