package com.akross.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Brochure {

    private final LocalDateTime modified;
    private final String url;

    private Brochure(final LocalDateTime modified, final String url) {
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
        Brochure image = (Brochure) o;
        return Objects.equals(modified, image.modified) &&
                Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, url);
    }

    @Override
    public String toString() {
        return "Brochure" +
                "modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }


    public static final class BrochureBuilder {
        private LocalDateTime modified;
        private String url;

        private BrochureBuilder() {
        }

        public static BrochureBuilder aBrochure() {
            return new BrochureBuilder();
        }

        public BrochureBuilder withModified(LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public BrochureBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Brochure build() {
            return new Brochure(modified, url);
        }
    }
}
