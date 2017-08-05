package com.akross.domain.property.residentialsalesandletting;

import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

public enum FloorAreaUnit {
    ACRES("acres"), HECTARES("hectares"), SQUARE_METERS("sq m"), SQUARE_FEET("sq ft");

    private static final Map<String, FloorAreaUnit> map = of(FloorAreaUnit.values())
            .collect(toMap(floorAreaUnit -> floorAreaUnit.floorAreaUnit, floorAreaUnit -> floorAreaUnit));

    private final String floorAreaUnit;

    FloorAreaUnit(final String floorAreaUnit) {
        this.floorAreaUnit = floorAreaUnit;
    }

    public static Map<String, FloorAreaUnit> getMap() {
        return unmodifiableMap(map);
    }

    public String getFloorAreaUnit() {
        return floorAreaUnit;
    }

    @Override
    public String toString() {
        return "FloorAreaUnit{" +
                "floorAreaUnit='" + floorAreaUnit + '\'' +
                '}';
    }
}
