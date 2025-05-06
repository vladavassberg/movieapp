package hh.helia.movieapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hh.helia.movieapp.domain.GenreRepository;
import hh.helia.movieapp.domain.Genre;

@RestController
@RequestMapping("/api/genres")
public class GenreRestController {

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping
    public Genre addGenre(@RequestBody Genre genre){
        return genreRepository.save(genre);
    }

    @GetMapping Iterable<Genre> getAllGenres() {
        return genreRepository.findAll();
    }


}
