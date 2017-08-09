package com.akross.repository.property.configuration;

import com.akross.domain.property.utilities.PropertyConverter;
import com.akross.repository.PropertyRepository;
import com.akross.repository.PropertyRepositoryInMemory;
import com.akross.repository.property.entity.Property;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class PropertyRepositoryConfiguration {

    @Bean
    public PropertyRepository propertyRepository(final PropertyRepositoryInMemory<Property> propertyRepositoryInMemory
            , final PropertyConverter propertyConverter) {
        return new com.akross.repository.property.PropertyRepository(propertyRepositoryInMemory, propertyConverter);
    }
}
