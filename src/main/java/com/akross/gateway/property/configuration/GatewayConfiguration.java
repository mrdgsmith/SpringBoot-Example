package com.akross.gateway.property.configuration;

import com.akross.gateway.PropertyClient;
import com.akross.gateway.property.HttpPropertyClient;
import com.akross.gateway.property.utilities.PropertyConverter;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@SpringBootConfiguration
@EnableConfigurationProperties(JupixPropertiesRestClientConfiguration.class)
public class GatewayConfiguration {

    @Autowired
    private JupixPropertiesRestClientConfiguration jupixPropertiesRestClientConfiguration;
    
    @Bean
    public MappingJackson2XmlHttpMessageConverter mappingJacksonHttpMessageConverter() {
        final JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
        final XmlMapper xmlMapper = (XmlMapper) new XmlMapper(jacksonXmlModule)
                .disable(FAIL_ON_UNKNOWN_PROPERTIES);
        MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter();
        mappingJackson2XmlHttpMessageConverter.setObjectMapper(xmlMapper);
        return mappingJackson2XmlHttpMessageConverter;
    }

    @Bean
    public RestTemplate jupixPropertiesRestClient(final RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .rootUri(jupixPropertiesRestClientConfiguration.getRootUrl())
                .build();
    }

    @Bean
    public HttpPropertyClient httpPropertyClient(final RestTemplate jupixPropertiesRestClient) {
        return new HttpPropertyClient(jupixPropertiesRestClient, jupixPropertiesRestClientConfiguration);
    }

    @Bean
    public PropertyClient propertyClient(final HttpPropertyClient httpPropertyClient) {
        return new com.akross.gateway.property.PropertyClient(httpPropertyClient, new PropertyConverter());
    }
}