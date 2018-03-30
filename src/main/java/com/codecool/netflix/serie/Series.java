package com.codecool.netflix.serie;

import com.codecool.netflix.genre.Genre;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"seriesName", "archived"}))
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String seriesName;
    private int episodesNum;
    private Date release;
    private int seasonsNum;
    private boolean archived;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getEpisodesNum() {
        return episodesNum;
    }

    public void setEpisodesNum(int episodesNum) {
        this.episodesNum = episodesNum;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public int getSeasonsNum() {
        return seasonsNum;
    }

    public void setSeasonsNum(int seasonsNum) {
        this.seasonsNum = seasonsNum;
    }
}
