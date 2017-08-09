package com.akross.repository.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime modified;
    private String url;

    protected Image() {
    }

    private Image(final Long id,
                  final LocalDateTime modified
            , final String url) {
        this.id = id;
        this.modified = LocalDateTime.of(modified.getYear(), modified.getMonth(), modified.getDayOfMonth()
                , modified.getHour(), modified.getMinute(), modified.getSecond());
        this.url = url;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) &&
                Objects.equals(modified, image.modified) &&
                Objects.equals(url, image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modified, url);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class ImageBuilder {
        private Long id;
        private LocalDateTime modified;
        private String url;

        private ImageBuilder() {
        }

        public static ImageBuilder anImage() {
            return new ImageBuilder();
        }

        public ImageBuilder withId(final Long id) {
            this.id = id;
            return this;
        }

        public ImageBuilder withModified(final LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public ImageBuilder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public Image build() {
            return new Image(id, modified, url);
        }
    }
}