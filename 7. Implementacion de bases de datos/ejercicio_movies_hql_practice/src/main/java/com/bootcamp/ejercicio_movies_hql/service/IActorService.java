package com.bootcamp.ejercicio_movies_hql.service;

import com.bootcamp.ejercicio_movies_hql.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorService {

    List<Actor> findActorsWithFavoriteMovie();
    List<Actor> findActorsByRatingGreaterThan( Double rating);
    List<Actor> findActorByMovie(Integer id);
}
