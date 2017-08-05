package com.akross.service;

import com.akross.domain.container.Property;
import com.akross.domain.residentialsalesandletting.PropertyType;

import java.math.BigDecimal;
import java.util.List;

public interface PropertyService {
    Property getProperties();

    Property getProperties(final Boolean featured);

    Property getPropertiesBySearchCriteria(final String location, final BigDecimal minimumPrice
            , final BigDecimal maximumPrice, final List<PropertyType> propertyType, final Integer bedroomAmount);

    <T extends com.akross.domain.Property> T getProperty(final Long propertyId);
}
