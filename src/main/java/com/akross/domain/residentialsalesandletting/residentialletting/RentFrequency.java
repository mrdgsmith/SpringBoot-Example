package com.akross.domain.residentialsalesandletting.residentialletting;

import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

public enum RentFrequency {
    PCM(1, "pcm"), PW(2, "pw"), PA(3, "pa");

    private static Map<Integer, RentFrequency> map = of(RentFrequency.values())
            .collect(toMap(rentFrequency -> rentFrequency.id, rentFrequency -> rentFrequency));

    private final Integer id;
    private final String description;

    RentFrequency(final Integer id, final String description) {
        this.id = id;
        this.description = description;
    }

    public static Map<Integer, RentFrequency> getMap() {
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
        return "RentFrequency{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}