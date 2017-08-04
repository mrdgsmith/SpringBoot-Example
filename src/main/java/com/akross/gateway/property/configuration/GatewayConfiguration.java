package com.akross.gateway.property.configuration;

import com.akross.gateway.PropertyClient;
import com.akross.gateway.property.HttpPropertyClient;
import com.akross.gateway.property.utilities.PropertyConverter;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static java.time.format.DateTimeFormatter.ofPattern;

@SpringBootConfiguration
@EnableConfigurationProperties(JupixPropertiesRestClientConfiguration.class)
public class GatewayConfiguration {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private JupixPropertiesRestClientConfiguration jupixPropertiesRestClientConfiguration;

    @Bean
    public MappingJackson2XmlHttpMessageConverter mappingJacksonHttpMessageConverter() {
        final JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
        jacksonXmlModule.addDeserializer(LocalDate.class, LocalDateDeserializer.INSTANCE)
                .addDeserializer(LocalTime.class, LocalTimeDeserializer.INSTANCE)
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DATE_TIME_FORMATTER));
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