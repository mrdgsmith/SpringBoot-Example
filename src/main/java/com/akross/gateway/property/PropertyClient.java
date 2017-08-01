package com.akross.gateway.property;

import com.akross.domain.Property;
import com.akross.gateway.property.utilities.PropertyConverter;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PropertyClient implements com.akross.gateway.PropertyClient {

    private final HttpPropertyClient httpPropertyClient;
    private final PropertyConverter propertyConverter;

    public PropertyClient(final HttpPropertyClient httpPropertyClient
            , final PropertyConverter propertyConverter) {
        this.httpPropertyClient = httpPropertyClient;
        this.propertyConverter = propertyConverter;
    }

    @Override
    public List<Property> getProperties() {
        return httpPropertyClient.getProperties().stream()
                .map(propertyConverter::convert)
                .collect(toList());
    }
}
