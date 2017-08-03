package com.akross.gateway.property;

import com.akross.gateway.property.configuration.JupixPropertiesRestClientConfiguration;
import com.akross.gateway.property.entity.Property;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.RequestEntity.get;
import static org.springframework.web.util.UriComponentsBuilder.newInstance;

public class HttpPropertyClient {

    private final RestTemplate jupixPropertiesRestClient;
    private final JupixPropertiesRestClientConfiguration jupixPropertiesRestClientConfiguration;

    public HttpPropertyClient(final RestTemplate jupixPropertiesRestClient
            , final JupixPropertiesRestClientConfiguration jupixPropertiesRestClientConfiguration) {
        this.jupixPropertiesRestClient = jupixPropertiesRestClient;
        this.jupixPropertiesRestClientConfiguration = jupixPropertiesRestClientConfiguration;
    }

    public List<Property> getProperties() {
        final UriComponentsBuilder builder = newInstance()
                .path(jupixPropertiesRestClientConfiguration.getPropertyPath())
                .queryParam("clientId", jupixPropertiesRestClientConfiguration.getClientId())
                .queryParam("passphrase", jupixPropertiesRestClientConfiguration.getPassphrase())
                .queryParam("version", jupixPropertiesRestClientConfiguration.getVersion());
        return jupixPropertiesRestClient.exchange(get(builder.build().encode().toUri()).build()
                , new ParameterizedTypeReference<List<Property>>() {
                }).getBody();
    }
}