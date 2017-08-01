package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class Flags {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<Flag> flag;

    public Flags(@JacksonXmlProperty(localName = "flag") final List<Flag> flag) {
        this.flag = flag;
    }

    public List<Flag> getFlag() {
        return Objects.nonNull(flag) ? Collections.unmodifiableList(flag) : emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flags flags = (Flags) o;
        return Objects.equals(flag, flags.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag);
    }

    @Override
    public String toString() {
        return "Flags{" +
                "flag=" + flag +
                '}';
    }
}