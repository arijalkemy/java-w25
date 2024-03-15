package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.model.ActorEpisode;
import com.bootcamp.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {


    @Query("SELECT a.favoriteMovie FROM Actor a WHERE a.id = :actorId")
    Movie getFavoriteMovie(Long actorId);


    //  Listar todos los actores que tengan declarada una película favorita.
    List<Actor> findByFavoriteMovieIsNotNull();
    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findByRatingGreaterThan(Double rating);


    //Listar todos los actores que trabajan en la <película recibida por parámetro>

    @Query("SELECT a FROM ActorMovie am JOIN am.actor a WHERE am.id = :movieId")
    List<Actor> findByActorsByMovieId(Long movieId);

}
