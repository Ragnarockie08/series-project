package com.codecool.netflix.serie;

import com.codecool.netflix.genre.Genre;
import org.springframework.data.repository.CrudRepository;

public interface SeriesService {

    public Iterable<Series> findAll();

    public Iterable<Series> findAllByArchived();

    public Series findOneByArchived(Integer id);

    public void save(Series series);

    public Series findOne(Integer id);

    public void delete(Integer id);

    public void save(Integer id, Integer genresId, Series series);

    public void archive(Integer id);



}
