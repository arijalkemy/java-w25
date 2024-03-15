package com.bootcamp.movies.service;


import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.model.Movie;
import com.bootcamp.movies.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {


    @Autowired
    private IActorRepository actorRepository;
    public Movie getFavoriteMovie(Long actorId) {
      Movie movie = actorRepository.getFavoriteMovie(actorId);
    return movie;
    }

    public List<Actor> findActorsByFavoriteMovieIsNotNull() {
      return actorRepository.findByFavoriteMovieIsNotNull();
    }

    public List<Actor> findActorsByRatingBetterThan(Double rating) {
        return actorRepository.findByRatingGreaterThan(rating);
    }

    public List<Actor> findActorsByMovieId(Long movieId) {
        return actorRepository.findByActorsByMovieId(movieId);
    }
}
