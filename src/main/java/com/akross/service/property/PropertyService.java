package com.akross.service.property;

import com.akross.domain.Department;
import com.akross.domain.container.Property;
import com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.gateway.PropertyClient;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.akross.domain.container.Property.PropertyBuilder.aProperty;
import static com.akross.domain.residentialsalesandletting.residentialletting.Availability.LET;
import static com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting.ResidentialLettingBuilder.aResidentialLetting;
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
        final List<Predicate<ResidentialLetting>> filter_residential_letting_featured = asList(
                residentialLetting -> Department.LETTINGS.equals(residentialLetting.getDepartment())
                , ResidentialLetting::isFeaturedProperty
                , residentialLetting -> LET.equals(residentialLetting.getAvailability())
        );
        return residentialLettings.parallelStream()
                .filter(filter_residential_letting_featured.stream()
                        .reduce(Predicate::and).orElse(v -> true))
                .map(setRentForResidentialLettingPropertyDisplayFunction())
                .sorted((comparing(ResidentialLetting::getDateLastModified)
                        .thenComparing(ResidentialLetting::getTimeLastModified)).reversed())
                .collect(toList());
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
    public com.akross.domain.container.Property getProperties(final boolean featured) {
        final Property properties = propertyClient.getProperties();
        if (featured) {
            return aProperty()
                    .withResidentialLettings(getFeaturedResidentialLettings(properties.getResidentialLettings()))
                    .build();
        }
        return null;
    }
}