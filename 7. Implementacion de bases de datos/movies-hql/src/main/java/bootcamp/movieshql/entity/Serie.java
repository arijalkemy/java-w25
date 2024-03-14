package bootcamp.movieshql.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Table(name = "series")
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    @Column(name = "release_date")
    LocalDate releaseDate;

    @Column(name = "end_date")
    LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    Genre genre;

}
