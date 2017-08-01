package com.akross.gateway.property;

import com.akross.gateway.property.configuration.JupixPropertiesRestServiceConfiguration;
import com.akross.gateway.property.entity.Property;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.RequestEntity.get;
import static org.springframework.web.util.UriComponentsBuilder.newInstance;

public class HttpPropertyClient {

    private final RestTemplate jupixPropertiesRestService;
    private final JupixPropertiesRestServiceConfiguration jupixPropertiesRestServiceConfiguration;

    public HttpPropertyClient(final RestTemplate jupixPropertiesRestService
            , final JupixPropertiesRestServiceConfiguration jupixPropertiesRestServiceConfiguration) {
        this.jupixPropertiesRestService = jupixPropertiesRestService;
        this.jupixPropertiesRestServiceConfiguration = jupixPropertiesRestServiceConfiguration;
    }

    public List<Property> getProperties() {
        final UriComponentsBuilder builder = newInstance()
                .path(jupixPropertiesRestServiceConfiguration.getPropertyPath())
                .queryParam("clientId", jupixPropertiesRestServiceConfiguration.getClientId())
                .queryParam("passphrase", jupixPropertiesRestServiceConfiguration.getPassphrase())
                .queryParam("version", jupixPropertiesRestServiceConfiguration.getVersion());
        return jupixPropertiesRestService.exchange(get(builder.build().encode().toUri()).build()
                , new ParameterizedTypeReference<List<Property>>() {
                }).getBody();
    }
}