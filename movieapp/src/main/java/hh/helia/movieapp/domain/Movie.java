package hh.helia.movieapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String description;


    @ManyToOne
    @JoinColumn(name = "genreid")

    private Genre genre;

    public Movie() {}

    public Movie(Long id, String name, String description, Genre genre){
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
	public String toString() {
		if (this.genre != null)
			return "Movie [id=" + id + ", name=" + name + " genre =" + this.getGenre() + "]";		
		else
			return "Movie [id=" + id + ", name=" + name + ", genre=" + genre;
	}
}

