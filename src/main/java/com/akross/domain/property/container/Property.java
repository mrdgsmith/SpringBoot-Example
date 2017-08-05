package com.akross.domain.property.container;

import com.akross.domain.property.residentialsalesandletting.residentialletting.ResidentialLetting;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.nonNull;

public class Property {
    private final List<ResidentialLetting> residentialLettings;

    private Property(final List<ResidentialLetting> residentialLettings) {
        this.residentialLettings = nonNull(residentialLettings) ? unmodifiableList(residentialLettings) : emptyList();
    }

    public List<ResidentialLetting> getResidentialLettings() {
        return unmodifiableList(residentialLettings);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(residentialLettings, property.residentialLettings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residentialLettings);
    }

    @Override
    public String toString() {
        return "Property{" +
                "residentialLettings=" + residentialLettings +
                '}';
    }

    public static final class PropertyBuilder {
        List<ResidentialLetting> residentialLettings;

        private PropertyBuilder() {
        }

        public static PropertyBuilder aProperty() {
            return new PropertyBuilder();
        }

        public PropertyBuilder withResidentialLettings(final List<ResidentialLetting> residentialLettings) {
            this.residentialLettings = residentialLettings;
            return this;
        }

        public Property build() {
            return new Property(residentialLettings);
        }
    }
}