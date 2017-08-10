package com.akross.gateway.property.exception;

public class PropertiesGatewayException extends RuntimeException {
    public PropertiesGatewayException(final String message) {
        super(message);
    }

    public PropertiesGatewayException(final String message, final Throwable cause) {
        super(message, cause);
    }
}