package hh.helia.movieapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.helia.movieapp.domain.MovieRepository;
import hh.helia.movieapp.domain.Movie;

@CrossOrigin
@Controller
public class MovieRestController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public @ResponseBody List<Movie> getAllMoviesRest(){
        return (List<Movie>) movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public @ResponseBody Optional<Movie> getMovieById(@PathVariable(name = "id")Long movieId) {
        return movieRepository.findById(movieId);
    }

    @PostMapping("/movies")
    public @ResponseBody Movie addNewMovieRest(@RequestBody Movie NewMovie){
        return movieRepository.save(NewMovie);
    }

}
