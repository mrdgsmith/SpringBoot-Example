package com.akross.domain.property.residentialsalesandletting;

import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

public enum PropertyType {
    HOUSE(1, "Houses"), FLAT_APARTMENTS(2, "Flat / Apartments"), BUNGALOWS(3, "Bungalows"), OTHER(4, "Other");

    private static final Map<Integer, PropertyType> map = of(PropertyType.values())
            .collect(toMap(propertyType -> propertyType.typeId, propertyType -> propertyType));

    private final Integer typeId;
    private final String type;

    PropertyType(final Integer typeId, final String type) {
        this.typeId = typeId;
        this.type = type;
    }

    public static Map<Integer, PropertyType> getMap() {
        return unmodifiableMap(map);
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "PropertyType{" +
                "typeId=" + typeId +
                ", type='" + type + '\'' +
                '}';
    }
}
