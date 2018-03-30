package com.codecool.netflix.genre;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/genre")
public class GenreController {

    private GenreServiceImpl service;

    public GenreController(GenreServiceImpl service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public Iterable<Genre> index(){

        return service.findAllByArchived();
    }

    @PostMapping(path = "")
    public Genre create(@RequestBody Genre genre){

        service.save(genre);
        return genre;
    }

    @GetMapping(path = "/{id}")
    public Genre show(@PathVariable Integer id) {

        return service.findOneByArchived(id);
    }

    @PutMapping(path = "/{id}")
    public Genre update(@PathVariable Integer id, @RequestBody Genre genre){

        service.save(id, genre);
        return genre;
    }

    @DeleteMapping(path= "/{id}")
    public void delete(@PathVariable Integer id) {

        service.archive(id);
    }
}
