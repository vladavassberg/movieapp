package hh.helia.movieapp.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.helia.movieapp.domain.Genre;
import hh.helia.movieapp.domain.GenreRepository;
import hh.helia.movieapp.domain.Movie;
import hh.helia.movieapp.domain.MovieRepository;



@Controller
@EnableMethodSecurity(securedEnabled = true)
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    // login page
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/movielist")
    public String movielist(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movielist";
    }

    @RequestMapping(value = "/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("genres", genreRepository.findAll());
        return "addmovie";
    }

    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String save(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movielist";
    }

    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
        movieRepository.deleteById(movieId);
        return "redirect:/movielist";
    }

    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String editMovie(@PathVariable("id") Long id, Model model) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));
        model.addAttribute("movie", movie);
        model.addAttribute("genres", genreRepository.findAll());
        return "editmovie";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateMovie(@PathVariable("id") Long id, @ModelAttribute Movie movie) {
        movie.setId(id);
        movieRepository.save(movie);
        return "redirect:/movielist";
    }
}
