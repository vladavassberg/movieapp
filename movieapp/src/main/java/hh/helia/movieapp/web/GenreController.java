package hh.helia.movieapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hh.helia.movieapp.domain.Genre;
import hh.helia.movieapp.domain.GenreRepository;

@Controller
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping("/addgenre")
    public String addGenre(@RequestParam String name) {
        Genre genre = new Genre();
        genre.setName(name);
        genreRepository.save(genre);
        return "redirect:/movielist"; 
    }
}

