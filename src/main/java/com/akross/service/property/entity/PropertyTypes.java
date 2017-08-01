package com.akross.service.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

public class PropertyTypes {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<PropertyType> propertyType;

    public PropertyTypes(@JacksonXmlProperty(localName = "propertyType") final List<PropertyType> propertyType) {
        this.propertyType = propertyType;
    }

    public List<PropertyType> getPropertyType() {
        return propertyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyTypes that = (PropertyTypes) o;
        return Objects.equals(propertyType, that.propertyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyType);
    }

    @Override
    public String toString() {
        return "PropertyTypes{" +
                "propertyType=" + propertyType +
                '}';
    }
}