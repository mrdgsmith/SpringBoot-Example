package com.akross.repository.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class ExternalLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime modified;
    private String url;
    private String description;

    protected ExternalLink() {
    }

    private ExternalLink(final Long id, final LocalDateTime modified, final String url, final String description) {
        this.id = id;
        this.modified = LocalDateTime.of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond());
        this.url = url;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getModified() {
        return LocalDateTime.of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond());
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExternalLink)) return false;
        ExternalLink that = (ExternalLink) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(modified, that.modified) &&
                Objects.equals(url, that.url) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modified, url, description);
    }

    @Override
    public String toString() {
        return "ExternalLink{" +
                "id=" + id +
                ", modified=" + modified +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static final class ExternalLinkBuilder {
        private Long id;
        private LocalDateTime modified;
        private String url;
        private String description;

        private ExternalLinkBuilder() {
        }

        public static ExternalLinkBuilder anExternalLink() {
            return new ExternalLinkBuilder();
        }

        public ExternalLinkBuilder withId(final Long id) {
            this.id = id;
            return this;
        }

        public ExternalLinkBuilder withModified(final LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public ExternalLinkBuilder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public ExternalLinkBuilder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public ExternalLink build() {
            return new ExternalLink(id, modified, url, description);
        }
    }
}