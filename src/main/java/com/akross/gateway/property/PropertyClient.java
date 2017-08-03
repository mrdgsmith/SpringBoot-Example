package com.akross.gateway.property;

import com.akross.domain.container.Property;
import com.akross.domain.residentialsalesandletting.residentialletting.ResidentialLetting;
import com.akross.gateway.property.utilities.PropertyConverter;

import java.util.List;
import java.util.function.Predicate;

import static com.akross.domain.Department.LETTINGS;
import static com.akross.domain.container.Property.PropertyBuilder.aProperty;
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
    public Property getProperties() {
        final List<com.akross.gateway.property.entity.Property> properties = httpPropertyClient.getProperties();
        final List<ResidentialLetting> residentialLettings = properties.parallelStream()
                .filter(FILTER_RESIDENTIAL_LETTING.stream()
                        .reduce(Predicate::and)
                        .orElse(v -> false))
                .map(propertyConverter::convertToResidentialLetting)
                .collect(toList());
        return aProperty()
                .withResidentialLettings(residentialLettings)
                .build();
    }
}
