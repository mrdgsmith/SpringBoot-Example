package com.akross.gateway.property;

import com.akross.gateway.property.configuration.JupixPropertiesRestClientProperties;
import com.akross.gateway.property.entity.Properties;
import com.akross.gateway.property.exception.PropertiesGatewayException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static java.text.MessageFormat.format;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.util.UriComponentsBuilder.newInstance;

public class HttpPropertyClient {

    private static final String CLIENT_ID = "clientID";
    private static final String PASSPHRASE = "passphrase";
    private static final String VERSION = "version";
    private static final String GATEWAY_FAILURE_MESSAGE = "Failed to get properties with this get request {0}";
    private final RestTemplate jupixPropertiesRestClient;
    private final JupixPropertiesRestClientProperties jupixPropertiesRestClientProperties;

    public HttpPropertyClient(final RestTemplate jupixPropertiesRestClient
            , final JupixPropertiesRestClientProperties jupixPropertiesRestClientProperties) {
        this.jupixPropertiesRestClient = jupixPropertiesRestClient;
        this.jupixPropertiesRestClientProperties = jupixPropertiesRestClientProperties;
    }

    private static Properties checkPropertiesResponseIsSuccessful(
            final ResponseEntity<Properties> propertiesResponseEntity, final String uriRequest) {
        if (OK.equals(propertiesResponseEntity.getStatusCode())) {
            return propertiesResponseEntity.getBody();
        }
        throw new PropertiesGatewayException(format(GATEWAY_FAILURE_MESSAGE, uriRequest));
    }

    public Properties getProperties() {
        final UriComponentsBuilder uriComponentsBuilder = newInstance()
                .path(jupixPropertiesRestClientProperties.getPath())
                .queryParam(CLIENT_ID, jupixPropertiesRestClientProperties.getClientId())
                .queryParam(PASSPHRASE, jupixPropertiesRestClientProperties.getPassphrase())
                .queryParam(VERSION, jupixPropertiesRestClientProperties.getVersion());
        final String uriRequest = uriComponentsBuilder.build().encode().toUriString();
        try {
            final ResponseEntity<Properties> propertiesResponseEntity =
                    jupixPropertiesRestClient.getForEntity(uriRequest, Properties.class);
            return checkPropertiesResponseIsSuccessful(propertiesResponseEntity, uriRequest);
        } catch (final Exception exception) {
            throw new PropertiesGatewayException(format(GATEWAY_FAILURE_MESSAGE, uriRequest)
                    , exception);
        }
    }
}