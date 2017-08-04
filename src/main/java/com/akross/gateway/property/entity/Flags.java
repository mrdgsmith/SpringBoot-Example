package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.nonNull;

public class Flags {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<Flag> flag;

    public Flags(@JacksonXmlProperty(localName = "flag") final List<Flag> flag) {
        this.flag = nonNull(flag) ? unmodifiableList(flag) : emptyList();
    }

    public List<Flag> getFlag() {
        return unmodifiableList(flag);
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