package bootcamp.movieshql.repository;

import bootcamp.movieshql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m JOIN m.actors a WHERE a.rating > :rating")
    List<Movie> getMovieWithActorsWithRatingGreaterThanGiven(@Param("rating") Double rating);

}
