package com.akross.service.property.schedule;

import com.akross.gateway.PropertyClient;
import com.akross.repository.PropertyRepository;
import com.akross.repository.property.entity.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.nonNull;

@Component
@EnableScheduling
public class SchedulePropertyLoader {

    @Autowired
    private PropertyClient propertyClient;

    @Autowired
    private PropertyRepository propertyRepository;

    @Scheduled(fixedRate = 6000 * 60)
    public void getProperties() {
        final List<? extends Property> properties = propertyClient.getProperties();
        if (nonNull(properties) && !properties.isEmpty()) {
            propertyRepository.deleteAllProperties();
            propertyRepository.save(properties);
        }
    }
}