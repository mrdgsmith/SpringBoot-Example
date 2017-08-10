package com.akross.repository.property;

import com.akross.domain.property.Property;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.domain.property.utilities.PropertyConverter;
import com.akross.repository.PropertyRepositoryInMemory;
import com.akross.repository.property.exception.PropertyNotFoundException;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.util.stream.Collectors.toList;

public class PropertyRepository implements com.akross.repository.PropertyRepository {

    private final PropertyRepositoryInMemory<com.akross.repository.property.entity.Property> propertyRepositoryInMemory;
    private final PropertyConverter propertyConverter;

    public PropertyRepository(
            final PropertyRepositoryInMemory<com.akross.repository.property.entity.Property> propertyRepositoryInMemory
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

    private static boolean isResidentialLetting(final com.akross.repository.property.entity.Property property) {
        return property instanceof com.akross.repository.property.entity.residentialsalesandletting
                .residentialletting.ResidentialLetting;
    }

    @Override
    public com.akross.domain.property.container.Property getPropertiesBySearchCriteria(
            final String location
            , final BigDecimal minimumPrice
            , final BigDecimal maximumPrice, List<PropertyType> propertyTypes
            , final Integer bedroomAmount) {
        final List<com.akross.repository.property.entity.Property> propertiesBySearchCriteria
                = propertyRepositoryInMemory.getPropertiesBySearchCriteria(location
                , minimumPrice
                , maximumPrice
                , propertyTypes
                , bedroomAmount);
        return createPropertyContainer(propertiesBySearchCriteria);
    }

    @Override
    public com.akross.domain.property.container.Property getFeaturedProperties() {
        final List<com.akross.repository.property.entity.Property> featuredProperties
                = propertyRepositoryInMemory.getFeaturedProperties();

        return createPropertyContainer(featuredProperties);

    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Property> T getProperty(final Long propertyId) {
        final com.akross.repository.property.entity.Property property
                = propertyRepositoryInMemory.findOne(propertyId);
        if (isResidentialLetting(property)) {
            return (T) getResidentialLettings((com.akross.repository.property.entity.residentialsalesandletting
                    .residentialletting.ResidentialLetting) property).stream()
                    .findFirst()
                    .orElseThrow(() -> new PropertyNotFoundException(propertyId));
        }
        throw new PropertyNotFoundException(propertyId);
    }

    @Override
    public com.akross.domain.property.container.Property getProperties() {
        final List<com.akross.repository.property.entity.Property> properties = propertyRepositoryInMemory.findAll();
        return createPropertyContainer(properties);
    }

    private com.akross.domain.property.container.Property createPropertyContainer(
            final List<com.akross.repository.property.entity.Property> featuredProperties) {
        return com.akross.domain.property.container.Property.PropertyBuilder.aProperty()
                .withResidentialLettings(getResidentialLettings(
                        featuredProperties.parallelStream()
                                .filter(PropertyRepository::isResidentialLetting)
                                .map(com.akross.repository.property.entity
                                        .residentialsalesandletting.residentialletting.ResidentialLetting.class::cast)
                                .toArray(com.akross.repository.property.entity
                                        .residentialsalesandletting.residentialletting.ResidentialLetting[]::new)
                ))
                .build();
    }

    private List<ResidentialLetting> getResidentialLettings(
            final com.akross.repository.property.entity.residentialsalesandletting.residentialletting
                    .ResidentialLetting... residentialLettings) {
        return Stream.of(residentialLettings).parallel()
                .map(residentialLetting -> setRentForResidentialLettingPropertyDisplayFunction()
                        .apply(propertyConverter.convertToResidentialLetting(residentialLetting)))
                .collect(toList());
    }
}
