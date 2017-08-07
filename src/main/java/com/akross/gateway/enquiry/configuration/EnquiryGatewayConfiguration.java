package com.akross.gateway.enquiry.configuration;

import com.akross.gateway.EnquiryClient;
import com.akross.gateway.enquiry.HttpEnquiryClient;
import com.akross.gateway.enquiry.utilities.EnquiryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
@EnableConfigurationProperties(JupixEnquiryRestClientProperties.class)
public class EnquiryGatewayConfiguration {

    @Autowired
    private JupixEnquiryRestClientProperties jupixEnquiryRestClientProperties;

    @Bean
    public RestTemplate jupixEnquiryRestClient(final RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .rootUri(jupixEnquiryRestClientProperties.getRootUrl())
                .build();
    }

    @Bean
    public HttpEnquiryClient httpEnquiryClient(final RestTemplate jupixEnquiryRestClient) {
        return new HttpEnquiryClient(jupixEnquiryRestClient, jupixEnquiryRestClientProperties.getPath());
    }

    @Bean
    public EnquiryClient enquiryClient(final HttpEnquiryClient httpEnquiryClient) {
        return new com.akross.gateway.enquiry.EnquiryClient(httpEnquiryClient, new EnquiryConverter()
                , jupixEnquiryRestClientProperties);
    }
}