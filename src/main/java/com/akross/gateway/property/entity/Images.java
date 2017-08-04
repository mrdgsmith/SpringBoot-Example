package com.akross.gateway.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static java.util.Objects.nonNull;

public class Images {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<Image> image;

    public Images(@JacksonXmlProperty(localName = "image") final List<Image> image) {
        this.image = nonNull(image) ? unmodifiableList(image) : emptyList();
    }

    public List<Image> getImage() {
        return unmodifiableList(image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Images images = (Images) o;
        return Objects.equals(image, images.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image);
    }

    @Override
    public String toString() {
        return "Images{" +
                "image=" + image +
                '}';
    }
}