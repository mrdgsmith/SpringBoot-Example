package com.akross.gateway.property.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.of;

public class Brochure {

    private final LocalDateTime modified;

    @JacksonXmlText
    private final String url;

    public Brochure(@JsonDeserialize(using = LocalDateTimeDeserializer.class)
                    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                    @JacksonXmlProperty(localName = "modified", isAttribute = true) final LocalDateTime modified
            , @JacksonXmlProperty(localName = " ") final String url) {
        this.modified = of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond());
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
        if (o == null || getClass() != o.getClass()) return false;
        Brochure brochure = (Brochure) o;
        return Objects.equals(modified, brochure.modified) &&
                Objects.equals(url, brochure.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, url);
    }

    @Override
    public String toString() {
        return "Brochure{" +
                "modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }
}