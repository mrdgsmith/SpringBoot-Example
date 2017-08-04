package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.nonNull;

public class PropertyTypes {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<PropertyType> propertyType;

    public PropertyTypes(@JacksonXmlProperty(localName = "propertyType") final List<PropertyType> propertyType) {
        this.propertyType = nonNull(propertyType) ? unmodifiableList(propertyType) : emptyList();
    }

    public List<PropertyType> getPropertyType() {
        return unmodifiableList(propertyType);
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