package hh.helia.movieapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.helia.movieapp.domain.Genre;
import hh.helia.movieapp.domain.GenreRepository;
import hh.helia.movieapp.domain.Movie;
import hh.helia.movieapp.domain.MovieRepository;

@SpringBootApplication
public class MovieappApplication {
	private static final Logger log = LoggerFactory.getLogger(MovieappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MovieappApplication.class, args);
	}

	@Bean
	public CommandLineRunner movieDemo(MovieRepository movieRepository, GenreRepository genreRepository) {
		return (args) -> {
			log.info("save a couple of movies");

			Genre horror = genreRepository.save(new Genre(null, "Horror"));
			Genre action = genreRepository.save(new Genre(null, "Action"));
			Genre comedy = genreRepository.save(new Genre(null, "Comedy"));
			Genre drama = genreRepository.save(new Genre(null, "Drama"));

			movieRepository.save(new Movie(null, "Titanic","Romantic disaster film", drama));
			movieRepository.save(new Movie(null, "The Godfather", "Crime film", action));
			movieRepository.save(new Movie(null, "22 Jump Street", "Action comedy sequel", comedy));
			movieRepository.save(new Movie(null, "La La Land", "Love and dreams collide in Hollywood", drama));
			movieRepository.save(new Movie(null, "Skyfall", "James Bond faces a ghost from M's past", action));
			movieRepository.save(new Movie(null, "Get Out", "A chilling visit to meet the parents", horror));

			log.info("fetch all moveis");
			movieRepository.findAll().forEach(movie -> log.info(movie.toString()));
		};
	}

}
