package com.akross.repository.property;

import com.akross.domain.property.Property;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.domain.property.utilities.PropertyConverter;
import com.akross.repository.PropertyRepositoryInMemory;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

import static com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;

public class PropertyRepository implements com.akross.repository.PropertyRepository {

    private final PropertyRepositoryInMemory propertyRepositoryInMemory;
    private final PropertyConverter propertyConverter;

    public PropertyRepository(final PropertyRepositoryInMemory propertyRepositoryInMemory
            , final PropertyConverter propertyConverter) {
        this.propertyRepositoryInMemory = propertyRepositoryInMemory;
        this.propertyConverter = propertyConverter;
    }

    private static Function<ResidentialLetting, ResidentialLetting> setRentForResidentialLettingPropertyDisplayFunction() {
        return residentialLetting -> {
            if (residentialLetting.isLetPOA()) {
                return aResidentialLetting(residentialLetting)
                        .withRent(null)
                        .build();
            }
            return residentialLetting;
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Property> T getProperty(final Long propertyId) {
        final com.akross.repository.property.entity.Property property
                = (com.akross.repository.property.entity.Property) propertyRepositoryInMemory.findOne(propertyId);
        if (property instanceof com.akross.repository.property.entity.residentialsalesandletting
                .residentialletting.ResidentialLetting) {
            return (T) setRentForResidentialLettingPropertyDisplayFunction().apply(propertyConverter
                    .convertToResidentialLetting((com.akross.repository.property.entity
                            .residentialsalesandletting.residentialletting.ResidentialLetting) property));
        }
        return null;
    }

    @Override
    public com.akross.domain.property.container.Property getProperties() {
        return null;
    }

    @Override
    public com.akross.domain.property.container.Property getPropertiesBySearchCriteria(
            String location, BigDecimal minimumPrice, BigDecimal maximumPrice, List<PropertyType> propertyType
            , Integer bedroomAmount) {
        return null;
    }

    @Override
    public com.akross.domain.property.container.Property getFeaturedProperties() {
        return null;
    }

}
