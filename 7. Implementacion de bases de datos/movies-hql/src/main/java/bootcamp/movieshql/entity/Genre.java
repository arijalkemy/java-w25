package bootcamp.movieshql.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Table(name = "genres")
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Integer ranking;

    Integer active;

    @OneToMany(mappedBy = "genre")
    List<Movie> movies;

    @OneToMany(mappedBy = "genre")
    List<Serie> series;

}
