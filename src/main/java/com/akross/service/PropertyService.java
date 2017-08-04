package com.akross.service;

import com.akross.domain.container.Property;

public interface PropertyService {
    Property getProperties(final Boolean featured);

    <T extends com.akross.domain.Property> T getProperty(final Long propertyId);
}
