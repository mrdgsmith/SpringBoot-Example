package com.akross.service.property.configuration;

import com.akross.repository.PropertyRepository;
import com.akross.service.PropertyService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class PropertyServiceConfiguration {

    @Bean
    public PropertyService propertyService(final PropertyRepository propertyRepository) {
        return new com.akross.service.property.PropertyService(propertyRepository);
    }
}