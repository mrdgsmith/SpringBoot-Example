package com.akross.service.property.configuration;

import com.akross.gateway.PropertyClient;
import com.akross.service.PropertyService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ServiceConfiguration {

    @Bean
    public PropertyService propertyService(final PropertyClient propertyClient) {
        return new com.akross.service.property.PropertyService(propertyClient);
    }
}