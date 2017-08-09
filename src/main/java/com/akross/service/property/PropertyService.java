package com.akross.service.property;

import com.akross.domain.property.container.Property;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.repository.PropertyRepository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.akross.domain.property.Department.LETTINGS;
import static com.akross.domain.property.container.Property.PropertyBuilder.aProperty;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.Availability.LET;
import static com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PropertyService implements com.akross.service.PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(final PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    private static List<ResidentialLetting> getFeaturedResidentialLettings(final List<ResidentialLetting>
                                                                                   residentialLettings) {
        final List<Predicate<ResidentialLetting>> filterResidentialLettingFeatured = asList(
                residentialLetting -> LETTINGS.equals(residentialLetting.getDepartment())
                , ResidentialLetting::isFeaturedProperty
                , residentialLetting -> LET.equals(residentialLetting.getAvailability())
        );
        return residentialLettings.parallelStream()
                .filter(filterResidentialLettingFeatured.stream()
                        .reduce(Predicate::and).orElse(v -> true))
                .map(setRentForResidentialLettingPropertyDisplayFunction())
                .sorted(getSortedResidentialLettings())
                .collect(toList());
    }

    private static Comparator<ResidentialLetting> getSortedResidentialLettings() {
        return (comparing(ResidentialLetting::getDateLastModified)
                .thenComparing(ResidentialLetting::getTimeLastModified)).reversed();
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

    private static Property getAllProperties(final List<ResidentialLetting> residentialLettings) {
        return aProperty()
                .withResidentialLettings(residentialLettings.parallelStream()
                        .map(setRentForResidentialLettingPropertyDisplayFunction())
                        .sorted(getSortedResidentialLettings())
                        .collect(toList()))
                .build();
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
//        final Property properties = propertyClient.getProperties();
//        final List<ResidentialLetting> residentialLettings = properties.getResidentialLettings();
//        if (featured) {
//            return aProperty()
//                    .withResidentialLettings(getFeaturedResidentialLettings(residentialLettings))
//                    .build();
//        } else {
//            return getAllProperties(residentialLettings);
//        }
        return featured ? propertyRepository.getFeaturedProperties() : propertyRepository.getProperties();
    }

    @Override
    public com.akross.domain.property.container.Property getPropertiesBySearchCriteria(
            final String location, final BigDecimal minimumPrice, final BigDecimal maximumPrice
            , final List<PropertyType> propertyType, final Integer bedroomAmount) {
        return propertyRepository.getPropertiesBySearchCriteria(location, minimumPrice, maximumPrice
                , propertyType, bedroomAmount);
    }
}