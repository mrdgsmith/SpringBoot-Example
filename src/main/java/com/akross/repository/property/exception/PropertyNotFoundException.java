package com.akross.repository.property.exception;

import static java.text.MessageFormat.format;

public class PropertyNotFoundException extends RuntimeException {

    private final Long propertyId;

    public PropertyNotFoundException(final Long propertyId) {
        super(format("Property Id {0} can not be found", propertyId));
        this.propertyId = propertyId;
    }

    public Long getPropertyId() {
        return propertyId;
    }
}