package com.codecool.netflix.genre;

public interface GenreService {

    public Iterable<Genre> findAll();

    public Iterable<Genre> findAllByArchived();

    public Genre findOneByArchived(Integer id);

    public void save(Genre genre);

    public Genre findOne(Integer id);

    public void delete(Integer id);

    public void save(Integer id, Genre genre);

    public void archive(Integer id);

}
