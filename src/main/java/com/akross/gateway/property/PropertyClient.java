package com.akross.gateway.property;

import com.akross.domain.property.utilities.PropertyConverter;
import com.akross.repository.property.entity.Property;

import java.util.List;
import java.util.function.Predicate;

import static com.akross.domain.property.Department.LETTINGS;
import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

public class PropertyClient implements com.akross.gateway.PropertyClient {

    private static final List<Predicate<com.akross.gateway.property.entity.Property>> FILTER_RESIDENTIAL_LETTING =
            asList(property -> LETTINGS.getDescription().equals(property.getDepartment())
                    , property -> nonNull(property.getRent()));

    private final HttpPropertyClient httpPropertyClient;
    private final PropertyConverter propertyConverter;

    public PropertyClient(final HttpPropertyClient httpPropertyClient
            , final PropertyConverter propertyConverter) {
        this.httpPropertyClient = httpPropertyClient;
        this.propertyConverter = propertyConverter;
    }

    @Override
    public List<Property> getProperties() {
        final List<com.akross.gateway.property.entity.Property> properties
                = httpPropertyClient.getProperties().getProperties();
        return properties.parallelStream()
                .filter(FILTER_RESIDENTIAL_LETTING.stream()
                        .reduce(Predicate::and)
                        .orElse(v -> false))
                .map(propertyConverter::convertToResidentialLetting)
                .collect(toList());
    }
}