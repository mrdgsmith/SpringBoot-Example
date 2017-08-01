package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.EpcGraph;
import com.akross.gateway.property.entity.EpcGraphs;

import java.util.List;

public final class TestEpcGraphsBuilder {
    private List<EpcGraph> epcGraph;

    private TestEpcGraphsBuilder() {
    }

    public static TestEpcGraphsBuilder anEpcGraphs() {
        return new TestEpcGraphsBuilder();
    }

    public TestEpcGraphsBuilder withEpcGraph(List<EpcGraph> epcGraph) {
        this.epcGraph = epcGraph;
        return this;
    }

    public EpcGraphs build() {
        return new EpcGraphs(epcGraph);
    }
}
