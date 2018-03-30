package com.codecool.netflix.genre;

import com.codecool.netflix.logger.LoggerService;
import com.codecool.netflix.serie.Series;
import com.codecool.netflix.serie.SeriesRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository repository;
    private SeriesRepository seriesRepository;
    private Logger logger;

    public GenreServiceImpl(GenreRepository repository, SeriesRepository seriesRepository, LoggerService logger) {
        this.repository = repository;
        this.seriesRepository = seriesRepository;
        this.logger = logger.getLogger();
    }

    public Iterable<Genre> findAll(){

        logger.info("get all genres");

        return repository.findAll();
    }

    public Iterable<Genre> findAllByArchived(){

        logger.info("get all genres");

        return repository.findAllByArchivedIsFalse();
    }

    public Genre findOneByArchived(Integer id){

        logger.info("get genre resource by id");

        return repository.findByIdAndArchivedIsFalse(id);
    }

    public void save(Genre genre){

        if (repository.findGenreByName(genre.getName()) == null){
                repository.save(genre);
            logger.info("new Genre created");
        } else {
            throw new IllegalArgumentException("Attempt to create duplicated constraint");
        }
    }

    public void save(Integer id, Genre genre){

        genre.setId(id);
        repository.save(genre);

        logger.info("update Genre");
    }


    public Genre findOne(Integer id){
        return repository.findOne(id);
    }

    public void delete(Integer id){

        repository.delete(id);

        logger.info("archive genre resource");
    }

    public void archive(Integer id){

        Genre genre = repository.findOne(id);
        genre.setArchived(true);

        if (seriesRepository.findSeriesByGenre(genre) != null){
            Series series = seriesRepository.findSeriesByGenre(genre);
            series.setGenre(null);
        }

        repository.save(genre);
        logger.info("archive genre resource");
    }
}
