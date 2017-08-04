package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.nonNull;

public class EpcGraphs {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<EpcGraph> epcGraph;

    public EpcGraphs(@JacksonXmlProperty(localName = "epcGraph") final List<EpcGraph> epcGraph) {
        this.epcGraph = nonNull(epcGraph) ? unmodifiableList(epcGraph) : emptyList();
    }

    public List<EpcGraph> getEpcGraph() {
        return unmodifiableList(epcGraph);
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