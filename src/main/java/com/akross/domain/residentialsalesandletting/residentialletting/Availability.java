package com.akross.domain.residentialsalesandletting.residentialletting;

import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

public enum Availability {
    ON_HOLD(1, "On Hold"), TO_LET(2, "To Let"), REFERENCES_PENDING(3, "References Pending"), LET_AGREED(4, "Let Agreed"), LET(5, "Let"), WITHDRAWN(6, "Withdrwan");

    private static Map<Integer, Availability> map = of(Availability.values())
            .collect(toMap(availability -> availability.id, availability -> availability));

    private final Integer id;
    private final String description;

    Availability(final Integer id, final String description) {
        this.id = id;
        this.description = description;
    }

    public static Map<Integer, Availability> getMap() {
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
        return "Availlability{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}