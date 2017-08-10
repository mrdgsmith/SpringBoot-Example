package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.Properties;
import com.akross.gateway.property.entity.Property;

import java.util.List;

public final class TestPropertiesBuilder {
    private List<Property> properties;

    private TestPropertiesBuilder() {
    }

    public static TestPropertiesBuilder aProperties() {
        return new TestPropertiesBuilder();
    }

    public TestPropertiesBuilder withProperties(final List<Property> properties) {
        this.properties = properties;
        return this;
    }

    public Properties build() {
        return new Properties(properties);
    }
}
