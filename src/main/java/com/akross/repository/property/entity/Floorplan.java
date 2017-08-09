package com.akross.repository.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Floorplan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime modified;
    private String url;

    protected Floorplan() {
    }

    private Floorplan(final Long id, final LocalDateTime modified, final String url) {
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
        if (!(o instanceof Floorplan)) return false;
        Floorplan floorplan = (Floorplan) o;
        return Objects.equals(id, floorplan.id) &&
                Objects.equals(modified, floorplan.modified) &&
                Objects.equals(url, floorplan.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modified, url);
    }

    @Override
    public String toString() {
        return "Floorplan{" +
                "id=" + id +
                ", modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class FloorplanBuilder {
        private Long id;
        private LocalDateTime modified;
        private String url;

        private FloorplanBuilder() {
        }

        public static FloorplanBuilder aFloorplan() {
            return new FloorplanBuilder();
        }

        public FloorplanBuilder withId(final Long id) {
            this.id = id;
            return this;
        }

        public FloorplanBuilder withModified(final LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public FloorplanBuilder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public Floorplan build() {
            return new Floorplan(id, modified, url);
        }
    }
}