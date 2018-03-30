package com.codecool.netflix.serie;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private SeriesService service;

    public SeriesController(SeriesService service) {

        this.service = service;
    }

    @GetMapping(path = "")
    public Iterable<Series> index(){

        return service.findAllByArchived();
    }

    @PostMapping(path = "")
    public Series create(@RequestBody Series series){

        service.save(series);
        return series;
    }

    @GetMapping(path = "/{id}")
    public Series show(@PathVariable Integer id){

        return service.findOneByArchived(id);
    }

    @PutMapping(path = "/{id}/genre/{genreId}")
    public Series update(@PathVariable("id") Integer id, @PathVariable("genreId") Integer genreId, @RequestBody Series series){

        service.save(id, genreId, series);
        return series;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){

        service.archive(id);
    }
}
