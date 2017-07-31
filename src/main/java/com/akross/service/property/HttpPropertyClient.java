package com.akross.service.property;

import com.akross.service.property.configuration.JupixPropertiesRestServiceConfiguration;
import com.akross.service.property.entity.Property;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.RequestEntity.get;
import static org.springframework.web.util.UriComponentsBuilder.newInstance;

public class HttpPropertyClient implements PropertyClient {

    private final RestTemplate jupixPropertiesRestService;
    private final JupixPropertiesRestServiceConfiguration jupixPropertiesRestServiceConfiguration;

    public HttpPropertyClient(final RestTemplate jupixPropertiesRestService
            , final JupixPropertiesRestServiceConfiguration jupixPropertiesRestServiceConfiguration) {
        this.jupixPropertiesRestService = jupixPropertiesRestService;
        this.jupixPropertiesRestServiceConfiguration = jupixPropertiesRestServiceConfiguration;
    }

    @Override
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