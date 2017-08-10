package com.akross.gateway.property.entity;

import com.akross.gateway.utilities.adaptors.LocalDateTimeAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.of;

public abstract class UrlModified {

    @XmlAttribute(name = "modified")
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    private final LocalDateTime modified;

    @XmlValue
    private final String url;

    private UrlModified() {
        this(null, null);
    }

    protected UrlModified(final LocalDateTime modified, final String url) {
        this.modified = Objects.nonNull(modified) ? of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond()) : modified;
        this.url = url;
    }

    public LocalDateTime getModified() {
        return of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond());
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UrlModified)) return false;
        UrlModified that = (UrlModified) o;
        return Objects.equals(modified, that.modified) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, url);
    }

    @Override
    public String toString() {
        return "UrlModified{" +
                "modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }
}