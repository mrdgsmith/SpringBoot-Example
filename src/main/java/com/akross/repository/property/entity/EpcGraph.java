package com.akross.repository.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class EpcGraph {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime modified;
    private String url;

    protected EpcGraph() {
    }

    private EpcGraph(final Long id, final LocalDateTime modified, final String url) {
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
        if (!(o instanceof EpcGraph)) return false;
        EpcGraph epcGraph = (EpcGraph) o;
        return Objects.equals(id, epcGraph.id) &&
                Objects.equals(modified, epcGraph.modified) &&
                Objects.equals(url, epcGraph.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modified, url);
    }

    @Override
    public String toString() {
        return "EpcGraph{" +
                "id=" + id +
                ", modified=" + modified +
                ", url='" + url + '\'' +
                '}';
    }

    public static final class EpcGraphBuilder {
        private Long id;
        private LocalDateTime modified;
        private String url;

        private EpcGraphBuilder() {
        }

        public static EpcGraphBuilder anEpcGraph() {
            return new EpcGraphBuilder();
        }

        public EpcGraphBuilder withId(final Long id) {
            this.id = id;
            return this;
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
            return new EpcGraph(id, modified, url);
        }
    }
}