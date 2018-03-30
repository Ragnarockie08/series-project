package com.codecool.netflix.genre;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {

    public Iterable<Genre> findAllByArchivedIsFalse();

    public Genre findByIdAndArchivedIsFalse(Integer id);

    public Genre findGenreByName(String name);

}
