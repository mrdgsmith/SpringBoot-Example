package com.akross.domain.property;

import java.time.LocalDateTime;
import java.util.Objects;

public class EpcGraph {

    private final LocalDateTime modified;
    private final String url;

    private EpcGraph(final LocalDateTime modified, final String url) {
        this.modified = LocalDateTime.of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond());
        this.url = url;
    }

    public LocalDateTime getModified() {
        return LocalDateTime.of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond());
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpcGraph image = (EpcGraph) o;
        return Objects.equals(modified, image.modified) &&
                Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, url);
    }

    @Override
    public String toString() {
        return "EpcGraph" +
                "modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class EpcGraphBuilder {
        private LocalDateTime modified;
        private String url;

        private EpcGraphBuilder() {
        }

        public static EpcGraphBuilder anEpcGraph() {
            return new EpcGraphBuilder();
        }

        public EpcGraphBuilder withModified(final LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public EpcGraphBuilder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public EpcGraph build() {
            return new EpcGraph(modified, url);
        }
    }
}