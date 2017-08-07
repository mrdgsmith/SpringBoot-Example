package com.akross.service.enquiry.configuration;

import com.akross.gateway.EnquiryClient;
import com.akross.service.EnquiryService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class EnquiryServiceConfiguration {

    @Bean
    public EnquiryService enquiryService(final EnquiryClient enquiryClient) {
        return new com.akross.service.enquiry.EnquiryService(enquiryClient);
    }
}