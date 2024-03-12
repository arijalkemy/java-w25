package com.bootcamp.ejercicio_movies_hql.repository;

import com.bootcamp.ejercicio_movies_hql.model.Actor;
import com.bootcamp.ejercicio_movies_hql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
    @Query("select a from Actor a where a.favoriteMovie != null")
    List<Actor> findActorByFavoriteMovieIsNotNull();

    @Query("select a from Actor a where a.rating >:rating")
    List<Actor> findActorByRatingGreaterThan(@Param("rating") Double rating);

    @Query("select a from Actor a where :movie member of a.movies")
    List<Actor> findActorByMoviesContaining(@Param("movie") Movie movie);
}
