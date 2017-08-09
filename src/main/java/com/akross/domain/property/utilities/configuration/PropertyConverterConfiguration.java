package com.akross.domain.property.utilities.configuration;

import com.akross.domain.property.utilities.PropertyConverter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class PropertyConverterConfiguration {

    @Bean
    public PropertyConverter propertyConverter() {
        return new PropertyConverter();
    }
}
