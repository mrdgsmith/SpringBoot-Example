package com.akross.service.property;

import com.akross.domain.property.container.Property;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.repository.PropertyRepository;

import java.math.BigDecimal;
import java.util.List;

public class PropertyService implements com.akross.service.PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(final PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends com.akross.domain.property.Property> T getProperty(final Long propertyId) {
        return (T) propertyRepository.getProperty(propertyId);
    }

    @Override
    public Property getProperties() {
        return propertyRepository.getProperties();
    }

    @Override
    public com.akross.domain.property.container.Property getProperties(final Boolean featured) {
        return featured ? propertyRepository.getFeaturedProperties() : getProperties();
    }

    @Override
    public com.akross.domain.property.container.Property getPropertiesBySearchCriteria(
            final String location, final BigDecimal minimumPrice, final BigDecimal maximumPrice
            , final List<PropertyType> propertyType, final Integer bedroomAmount) {
        return propertyRepository.getPropertiesBySearchCriteria(location, minimumPrice, maximumPrice
                , propertyType, bedroomAmount);
    }
}