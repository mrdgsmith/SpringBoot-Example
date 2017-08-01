package com.akross.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Floorplan {

    private final LocalDateTime modified;
    private final String url;

    private Floorplan(final LocalDateTime modified, final String url) {
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
        Floorplan image = (Floorplan) o;
        return Objects.equals(modified, image.modified) &&
                Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, url);
    }

    @Override
    public String toString() {
        return "Floorplan{" +
                "modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class FloorplansBuilder {
        private LocalDateTime modified;
        private String url;

        private FloorplansBuilder() {
        }

        public static FloorplansBuilder aFloorplan() {
            return new FloorplansBuilder();
        }

        public FloorplansBuilder withModified(LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public FloorplansBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Floorplan build() {
            return new Floorplan(modified, url);
        }
    }
}
