package com.akross.domain.property;

public enum Department {
    SALES("Sales"), LETTINGS("Lettings"), COMMERCIAL("Commercial"), AGRICULTURAL("Agricultural");

    private final String description;

    Department(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Department{" +
                "description='" + description + '\'' +
                '}';
    }
}