package com.codecool.netflix.serie;


import com.codecool.netflix.genre.Genre;
import com.codecool.netflix.genre.GenreRepository;
import com.codecool.netflix.logger.LoggerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SeriesServiceImpl implements SeriesService {

    private SeriesRepository repository;
    private GenreRepository genreRepository;
    private Logger logger;

    public SeriesServiceImpl(SeriesRepository repository, GenreRepository genreRepository, LoggerService logger) {

        this.repository = repository;
        this.genreRepository = genreRepository;
        this.logger = logger.getLogger();

    }

    public Iterable<Series> findAll(){

        logger.info("Get all series");

        return repository.findAll();
    }

    public Iterable<Series> findAllByArchived(){

        logger.info("Get all series");

        return repository.findAllByArchivedIsFalse();
    }

    public Series findOneByArchived(Integer id){

        logger.info("Get serie by id");

        return repository.findByIdAndArchivedIsFalse(id);
    }

    public void save(Series series){

        if (repository.findSeriesBySeriesName(series.getSeriesName()) == null){
            repository.save(series);
            logger.info("new Series created");
        } else {
            logger.error("IllegalArgumentException exception occured");
            throw new IllegalArgumentException("Attempt to create duplicated constraint");
        }
    }

    public void save(Integer id, Integer genresId, Series series){

        series.setId(id);
        Genre genre = genreRepository.findByIdAndArchivedIsFalse(genresId);
        series.setGenre(genre);
        repository.save(series);

        logger.info("Update Series");
    }

    public Series findOne(Integer id){
        return repository.findOne(id);
    }

    public void delete(Integer id){

        repository.delete(id);

        logger.info("Delete Series");
    }

    public void archive(Integer id){

        Series series = repository.findOne(id);
        series.setArchived(true);

        repository.save(series);

        logger.info("Delete Series");

    }
}
