package com.akross.gateway.property.configuration;

import com.akross.domain.property.utilities.PropertyConverter;
import com.akross.gateway.PropertyClient;
import com.akross.gateway.property.HttpPropertyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
@EnableConfigurationProperties(JupixPropertiesRestClientProperties.class)
public class PropertyGatewayConfiguration {

    @Autowired
    private JupixPropertiesRestClientProperties jupixPropertiesRestClientProperties;

    @Bean
    public RestTemplate jupixPropertiesRestClient(final RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .rootUri(jupixPropertiesRestClientProperties.getRootUrl())
                .build();
    }

    @Bean
    public HttpPropertyClient httpPropertyClient(final RestTemplate jupixPropertiesRestClient) {
        return new HttpPropertyClient(jupixPropertiesRestClient, jupixPropertiesRestClientProperties);
    }

    @Bean
    public PropertyClient propertyClient(final HttpPropertyClient httpPropertyClient
            , final PropertyConverter propertyConverter) {
        return new com.akross.gateway.property.PropertyClient(httpPropertyClient, propertyConverter);
    }

//    private static MappingJackson2XmlHttpMessageConverter mappingJacksonHttpMessageConverter() {
//        final JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
//        jacksonXmlModule.addDeserializer(LocalDate.class, LocalDateDeserializer.INSTANCE)
//                .addDeserializer(LocalTime.class, LocalTimeDeserializer.INSTANCE)
//                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(ofPattern("yyyy-MM-dd HH:mm:ss")));
//        final XmlMapper xmlMapper = (XmlMapper) new XmlMapper(jacksonXmlModule)
//                .disable(FAIL_ON_UNKNOWN_PROPERTIES);
//        MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter
//                = new MappingJackson2XmlHttpMessageConverter();
//        mappingJackson2XmlHttpMessageConverter.setObjectMapper(xmlMapper);
//        return mappingJackson2XmlHttpMessageConverter;
//    }
}