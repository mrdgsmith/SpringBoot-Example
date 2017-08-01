package com.akross.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Image {

    private final LocalDateTime modified;
    private final String url;

    private Image(final LocalDateTime modified, final String url) {
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
        Image image = (Image) o;
        return Objects.equals(modified, image.modified) &&
                Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, url);
    }

    @Override
    public String toString() {
        return "Image{" +
                "modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }


    public static final class ImageBuilder {
        private LocalDateTime modified;
        private String url;

        private ImageBuilder() {
        }

        public static ImageBuilder anImage() {
            return new ImageBuilder();
        }

        public ImageBuilder withModified(LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public ImageBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Image build() {
            return new Image(modified, url);
        }
    }
}
