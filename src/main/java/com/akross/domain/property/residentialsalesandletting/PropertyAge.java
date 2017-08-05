package com.akross.domain.property.residentialsalesandletting;

import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

public enum PropertyAge {

    NOT_SPECIFIED(0, "Not Specified"), NEW_BUILD(1, "New Build"), MODERN(2, "Modern"), EIGHTIES_NINETIES(3, "1980s to 1990s"), FIFTIES_SIXTIES_SEVENTIES(4, "1950s, 1960s and 1970s"), FORTIES(5, "1940s"), TWENTIES_THIRTIES(6, "1920s to 1930s"), EDWARDIAN(7, "1901 - 1910"), VICTORIAN(8, "1837 - 1901"), GEORGIAN(9, "1714 - 1830"), PRE_EIGHTIETH_CENTURY(10, "Pre 18th Century");

    private static final Map<Integer, PropertyAge> map = of(PropertyAge.values())
            .collect(toMap(propertyAge -> propertyAge.id, propertyAge -> propertyAge));

    private final Integer id;
    private final String description;

    PropertyAge(final Integer id, final String description) {
        this.id = id;
        this.description = description;
    }

    public static Map<Integer, PropertyAge> getMap() {
        return unmodifiableMap(map);
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "PropertyAge{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
