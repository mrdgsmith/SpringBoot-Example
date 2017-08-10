package com.akross.gateway.property.entity;

import com.akross.gateway.utilities.adaptors.LocalDateTimeAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.of;

public class ExternalLink {

    @XmlElement(name = "description")
    private final String description;
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement(name = "modified")
    private final LocalDateTime modified;
    @XmlElement(name = "url")
    private final String url;

    private ExternalLink() {
        this(null, null, null);
    }

    public ExternalLink(final String description, final LocalDateTime modified, final String url) {
        this.description = description;
        this.modified = Objects.nonNull(modified) ? of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond()) : modified;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExternalLink)) return false;
        ExternalLink that = (ExternalLink) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(modified, that.modified) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, modified, url);
    }

    @Override
    public String toString() {
        return "ExternalLink{" +
                "description='" + description + '\'' +
                ", modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }
}