package com.akross.service.property.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
import java.util.Objects;

public class ExternalLinks {

    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<ExternalLink> externalLink;

    public ExternalLinks(@JacksonXmlProperty(localName = "externalLink") final List<ExternalLink> externalLink) {
        this.externalLink = externalLink;
    }

    public List<ExternalLink> getExternalLink() {
        return externalLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalLinks that = (ExternalLinks) o;
        return Objects.equals(externalLink, that.externalLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalLink);
    }

    @Override
    public String toString() {
        return "ExternalLinks{" +
                "externalLink=" + externalLink +
                '}';
    }
}