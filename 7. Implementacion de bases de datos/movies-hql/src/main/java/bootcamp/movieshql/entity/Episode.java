package bootcamp.movieshql.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Table(name = "episodes")
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    Integer number;

    @Column(name = "release_date")
    LocalDate releaseDate;

    Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    Season season;

}
