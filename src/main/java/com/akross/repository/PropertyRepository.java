package com.akross.repository;

import com.akross.domain.property.Property;
import com.akross.domain.property.residentialsalesandletting.PropertyType;

import java.math.BigDecimal;
import java.util.List;

public interface PropertyRepository {

    <T extends Property> T getProperty(final Long propertyId);

    com.akross.domain.property.container.Property getProperties();

    com.akross.domain.property.container.Property getPropertiesBySearchCriteria(
            final String location
            , final BigDecimal minimumPrice
            , final BigDecimal maximumPrice
            , final List<PropertyType> propertyTypes
            , final Integer bedroomAmount);

    com.akross.domain.property.container.Property getFeaturedProperties();

    void deleteAllProperties();

    void save(final List<? extends com.akross.repository.property.entity.Property> properties);
}