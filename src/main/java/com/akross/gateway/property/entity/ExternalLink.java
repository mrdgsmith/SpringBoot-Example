package com.akross.gateway.property.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.Objects;

public class ExternalLink {

    private final String url;
    private final LocalDateTime modified;
    private final String description;

    public ExternalLink(@JacksonXmlProperty(localName = "url") final String url
            , @JacksonXmlProperty(localName = "description") final String description
            , @JsonDeserialize(using = LocalDateTimeDeserializer.class)
                        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                        @JacksonXmlProperty(localName = "modified", isAttribute = true) final LocalDateTime modified) {
        this.url = url;
        this.description = description;
        this.modified = modified;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalLink that = (ExternalLink) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(modified, that.modified) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, modified, description);
    }

    @Override
    public String toString() {
        return "ExternalLink{" +
                "url='" + url + '\'' +
                ", modified=" + modified +
                ", description='" + description + '\'' +
                '}';
    }
}