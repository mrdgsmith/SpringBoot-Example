package com.akross.service.property;

import com.akross.domain.property.container.Property;
import com.akross.domain.property.residentialsalesandletting.PropertyType;
import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.gateway.PropertyClient;
import com.akross.service.property.exception.PropertyNotFoundException;

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

    private final PropertyClient propertyClient;

    public PropertyService(final PropertyClient propertyClient) {
        this.propertyClient = propertyClient;
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
        return (T) propertyClient.getProperties().getResidentialLettings().parallelStream()
                .filter(residentialLetting -> propertyId.equals(residentialLetting.getPropertyId()))
                .map(setRentForResidentialLettingPropertyDisplayFunction())
                .findFirst()
                .orElseThrow(() -> new PropertyNotFoundException(propertyId));
    }

    @Override
    public Property getProperties() {
        final Property properties = propertyClient.getProperties();
        final List<ResidentialLetting> residentialLettings = properties.getResidentialLettings();
        return getAllProperties(residentialLettings);
    }

    @Override
    public com.akross.domain.property.container.Property getProperties(final Boolean featured) {
        final Property properties = propertyClient.getProperties();
        final List<ResidentialLetting> residentialLettings = properties.getResidentialLettings();
        if (featured) {
            return aProperty()
                    .withResidentialLettings(getFeaturedResidentialLettings(residentialLettings))
                    .build();
        } else {
            return getAllProperties(residentialLettings);
        }
    }

    @Override
    public com.akross.domain.property.container.Property getPropertiesBySearchCriteria(
            final String location, final BigDecimal minimumPrice, final BigDecimal maximumPrice
            , final List<PropertyType> propertyType, final Integer bedroomAmount) {

        final List<Predicate<ResidentialLetting>> filterResidentialLettingSearchCriteria = asList(
                residentialLetting -> location.equalsIgnoreCase(residentialLetting.getAddress3())
                , residentialLetting -> minimumPrice.compareTo(residentialLetting.getRent()) <= 0
                , residentialLetting -> maximumPrice.compareTo(residentialLetting.getRent()) >= 0
                , residentialLetting -> propertyType.contains(residentialLetting.getPropertyType())
                , residentialLetting -> bedroomAmount.equals(residentialLetting.getPropertyBedrooms())
        );

        final Property properties = propertyClient.getProperties();
        final List<ResidentialLetting> residentialLettings = properties.getResidentialLettings().parallelStream()
                .filter(filterResidentialLettingSearchCriteria.stream()
                        .reduce(Predicate::and).orElse(v -> true))
                .collect(toList());
        return getAllProperties(residentialLettings);
    }
}