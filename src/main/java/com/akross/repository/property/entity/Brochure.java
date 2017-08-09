package com.akross.repository.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Brochure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime modified;
    private String url;

    protected Brochure() {
    }

    private Brochure(final Long id, final LocalDateTime modified, final String url) {
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
        if (!(o instanceof Brochure)) return false;
        Brochure brochure = (Brochure) o;
        return Objects.equals(id, brochure.id) &&
                Objects.equals(modified, brochure.modified) &&
                Objects.equals(url, brochure.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modified, url);
    }

    @Override
    public String toString() {
        return "Brochure{" +
                "id=" + id +
                ", modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }


    public static final class BrochureBuilder {
        private Long id;
        private LocalDateTime modified;
        private String url;

        private BrochureBuilder() {
        }

        public static BrochureBuilder aBrochure() {
            return new BrochureBuilder();
        }

        public BrochureBuilder withId(final Long id) {
            this.id = id;
            return this;
        }

        public BrochureBuilder withModified(final LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public BrochureBuilder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public Brochure build() {
            return new Brochure(id, modified, url);
        }
    }
}