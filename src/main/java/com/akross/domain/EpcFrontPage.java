package com.akross.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class EpcFrontPage {

    private final LocalDateTime modified;
    private final String url;

    private EpcFrontPage(final LocalDateTime modified, final String url) {
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
        EpcFrontPage image = (EpcFrontPage) o;
        return Objects.equals(modified, image.modified) &&
                Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, url);
    }

    @Override
    public String toString() {
        return "EpcFrontPage" +
                "modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class EpcFrontPageBuilder {
        private LocalDateTime modified;
        private String url;

        private EpcFrontPageBuilder() {
        }

        public static EpcFrontPageBuilder anEpcFrontPage() {
            return new EpcFrontPageBuilder();
        }

        public EpcFrontPageBuilder withModified(LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public EpcFrontPageBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public EpcFrontPage build() {
            return new EpcFrontPage(modified, url);
        }
    }
}
