package com.codecool.netflix.serie;

import com.codecool.netflix.genre.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends CrudRepository<Series, Integer> {

    public Iterable<Series> findAllByArchivedIsFalse();

    public Series findByIdAndArchivedIsFalse(Integer id);

    public Series findSeriesByGenre(Genre genre);

    public Series findSeriesBySeriesName(String seriesName);
}
