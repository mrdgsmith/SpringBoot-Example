package com.akross.service.property.schedule;

import com.akross.gateway.PropertyClient;
import com.akross.repository.PropertyRepository;
import com.akross.repository.property.entity.Property;

import java.util.List;
import java.util.Objects;

public class SchedulePropertyLoader {

    private final PropertyClient propertyClient;
    private final PropertyRepository propertyRepository;

    public SchedulePropertyLoader(final PropertyClient propertyClient, final PropertyRepository propertyRepository) {
        this.propertyClient = propertyClient;
        this.propertyRepository = propertyRepository;
    }

    public void getProperties() {
        final List<? extends Property> properties = propertyClient.getProperties();
        if (Objects.nonNull(properties) && !properties.isEmpty()) {
            propertyRepository.deleteAllProperties();
            propertyRepository.save(properties);
        }
    }
}