package bootcamp.movieshql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Table(name = "movies")
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    Double rating;

    Integer awards;

    @Column(name = "release_date")
    LocalDate releaseDate;

    Integer length;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    Genre genre;

    @JsonIgnore
    @OneToMany(mappedBy = "favoriteMovie")
    List<Actor> actorsFavoriteMovie;

    @ManyToMany(mappedBy = "movies")
    List<Actor> actors;

}
