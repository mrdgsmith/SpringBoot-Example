package com.akross.web.property.exception;

import static java.text.MessageFormat.format;

public class InvalidPropertyTypeException extends RuntimeException {

    private final String propertyType;

    public InvalidPropertyTypeException(final String propertyType) {
        super(format("Property type {0} is invalid", propertyType));
        this.propertyType = propertyType;
    }

    public String getPropertyType() {
        return propertyType;
    }
}