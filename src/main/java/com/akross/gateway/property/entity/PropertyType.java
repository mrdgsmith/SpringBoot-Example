package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.Objects;

import static java.lang.Integer.valueOf;

public class PropertyType {

    @JacksonXmlText
    private final Integer propertyType;

    public PropertyType(@JacksonXmlProperty() final String propertyType) {
        this.propertyType = valueOf(propertyType);
    }

    public Integer getPropertyType() {
        return propertyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyType that = (PropertyType) o;
        return Objects.equals(propertyType, that.propertyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyType);
    }

    @Override
    public String toString() {
        return "PropertyType{" +
                "propertyType=" + propertyType +
                '}';
    }
}