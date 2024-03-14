package bootcamp.movieshql.repository;

import bootcamp.movieshql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> getActorsWithRatingGreaterThanGiven(@Param("rating") Double rating);

    @Query("SELECT a FROM Actor a JOIN a.movies m WHERE m.title = :movie")
    List<Actor> getActorWorkedInMovie(@Param("movie") String movie);

}
