package com.akross.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class VirtualTour {

    private final LocalDateTime modified;
    private final String url;

    private VirtualTour(final LocalDateTime modified, final String url) {
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
        VirtualTour image = (VirtualTour) o;
        return Objects.equals(modified, image.modified) &&
                Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, url);
    }

    @Override
    public String toString() {
        return "VirtualTour" +
                "modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class VirtualTourBuilder {
        private LocalDateTime modified;
        private String url;

        private VirtualTourBuilder() {
        }

        public static VirtualTourBuilder aVirtualTour() {
            return new VirtualTourBuilder();
        }

        public VirtualTourBuilder withModified(LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public VirtualTourBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public VirtualTour build() {
            return new VirtualTour(modified, url);
        }
    }
}
