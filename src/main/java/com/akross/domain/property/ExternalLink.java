package com.akross.domain.property;

import java.time.LocalDateTime;
import java.util.Objects;

public class ExternalLink {

    private final LocalDateTime modified;
    private final String url;
    private final String description;

    private ExternalLink(final LocalDateTime modified, final String url, final String description) {
        this.modified = LocalDateTime.of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond());
        this.url = url;
        this.description = description;
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
        if (o == null || getClass() != o.getClass()) return false;
        ExternalLink that = (ExternalLink) o;
        return Objects.equals(modified, that.modified) &&
                Objects.equals(url, that.url) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, url, description);
    }

    @Override
    public String toString() {
        return "ExternalLink{" +
                "modified=" + modified +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static final class ExternalLinkBuilder {
        private LocalDateTime modified;
        private String url;
        private String description;

        private ExternalLinkBuilder() {
        }

        public static ExternalLinkBuilder anExternalLink() {
            return new ExternalLinkBuilder();
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
            return new ExternalLink(modified, url, description);
        }
    }
}