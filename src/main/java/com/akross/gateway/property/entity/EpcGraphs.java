package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class EpcGraphs {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<EpcGraph> epcGraph;

    public EpcGraphs(@JacksonXmlProperty(localName = "epcGraph") final List<EpcGraph> epcGraph) {
        this.epcGraph = epcGraph;
    }

    public List<EpcGraph> getEpcGraph() {
        return Objects.nonNull(epcGraph) ? Collections.unmodifiableList(epcGraph) : emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpcGraphs epcGraphs = (EpcGraphs) o;
        return Objects.equals(epcGraph, epcGraphs.epcGraph);
    }

    @Override
    public int hashCode() {
        return Objects.hash(epcGraph);
    }

    @Override
    public String toString() {
        return "EpcGraphs{" +
                "epcGraph=" + epcGraph +
                '}';
    }
}