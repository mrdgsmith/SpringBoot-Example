package com.akross.repository.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class VirtualTour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime modified;
    private String url;

    protected VirtualTour() {
    }

    private VirtualTour(final Long id, final LocalDateTime modified, final String url) {
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
        if (!(o instanceof VirtualTour)) return false;
        VirtualTour that = (VirtualTour) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(modified, that.modified) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modified, url);
    }

    @Override
    public String toString() {
        return "VirtualTour{" +
                "id=" + id +
                ", modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class VirtualTourBuilder {
        private Long id;
        private LocalDateTime modified;
        private String url;

        private VirtualTourBuilder() {
        }

        public static VirtualTourBuilder aVirtualTour() {
            return new VirtualTourBuilder();
        }

        public VirtualTourBuilder withId(final Long id) {
            this.id = id;
            return this;
        }

        public VirtualTourBuilder withModified(final LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public VirtualTourBuilder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public VirtualTour build() {
            return new VirtualTour(id, modified, url);
        }
    }
}