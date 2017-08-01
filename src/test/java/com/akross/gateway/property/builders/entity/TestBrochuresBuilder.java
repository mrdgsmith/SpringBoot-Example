package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.Brochure;
import com.akross.gateway.property.entity.Brochures;

import java.util.List;

public final class TestBrochuresBuilder {
    private List<Brochure> brochure;

    private TestBrochuresBuilder() {
    }

    public static TestBrochuresBuilder aBrochures() {
        return new TestBrochuresBuilder();
    }

    public TestBrochuresBuilder withBrochure(List<Brochure> brochure) {
        this.brochure = brochure;
        return this;
    }

    public Brochures build() {
        return new Brochures(brochure);
    }
}
