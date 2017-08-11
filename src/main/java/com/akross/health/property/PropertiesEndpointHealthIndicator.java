package com.akross.health.property;

import com.akross.gateway.property.configuration.JupixPropertiesRestClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpEntity.EMPTY;
import static org.springframework.http.HttpMethod.HEAD;

@Component
public class PropertiesEndpointHealthIndicator implements HealthIndicator {

    @Autowired
    private RestTemplate jupixPropertiesRestClient;

    @Autowired
    private JupixPropertiesRestClientProperties jupixPropertiesRestClientProperties;

    @Override
    public Health health() {
        try {
            final ResponseEntity<String> responseEntity = jupixPropertiesRestClient
                    .exchange(jupixPropertiesRestClientProperties.getPath(), HEAD, EMPTY, String.class);
            if (!responseEntity.getStatusCode().is2xxSuccessful()) {
                return Health.down().withDetail("Error Code", "Jupix is down").build();
            }
        } catch (Exception exception) {
            return Health.down().withDetail("Error Code", "Jupix is down due to " + exception).build();
        }
        return Health.up().build();
    }
}