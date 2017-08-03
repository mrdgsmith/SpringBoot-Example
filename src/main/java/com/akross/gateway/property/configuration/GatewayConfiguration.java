package com.akross.gateway.property.configuration;

import com.akross.gateway.property.HttpPropertyClient;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@SpringBootConfiguration
@EnableConfigurationProperties(JupixPropertiesRestClientConfiguration.class)
public class GatewayConfiguration {

    @Autowired
    private JupixPropertiesRestClientConfiguration jupixPropertiesRestClientConfiguration;

    @Bean
    @Primary
    public XmlMapper xmlMapper() {
        final JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
        return (XmlMapper) new XmlMapper(jacksonXmlModule)
                .disable(FAIL_ON_UNKNOWN_PROPERTIES, FAIL_ON_IGNORED_PROPERTIES);
    }

    @Bean
    public MappingJackson2XmlHttpMessageConverter mappingJacksonHttpMessageConverter(final XmlMapper xmlMapper) {
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
}