package bootcamp.movieshql.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Table(name = "seasons")
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    Integer number;

    @Column(name = "release_date")
    LocalDate releaseDate;

    @Column(name = "end_date")
    LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id")
    Serie serie;

}
