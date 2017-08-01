package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.Floorplan;
import com.akross.gateway.property.entity.Floorplans;

import java.util.List;

public final class TestFloorplansBuilder {
    private List<Floorplan> floorplan;

    private TestFloorplansBuilder() {
    }

    public static TestFloorplansBuilder aFloorplans() {
        return new TestFloorplansBuilder();
    }

    public TestFloorplansBuilder withFloorplan(List<Floorplan> floorplan) {
        this.floorplan = floorplan;
        return this;
    }

    public Floorplans build() {
        return new Floorplans(floorplan);
    }
}
