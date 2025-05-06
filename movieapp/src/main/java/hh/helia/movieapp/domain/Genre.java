package hh.helia.movieapp.domain;

import java.util.List;


//import org.springframework.data.annotation.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class Genre {

    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre") 
    private List<Movie> movies;

    // Геттеры и сеттеры

    public Genre() {}

    public Genre(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
        public Long getId() {
        return id;
    }

    public void setId(Long genreid) {
        this.id = genreid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return " " + id + ", " + name + " ]";

    }
}
