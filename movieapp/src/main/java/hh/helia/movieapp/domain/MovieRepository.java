package hh.helia.movieapp.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findByGenre(Genre genre);

    List<Movie> findByName(String name);
}
