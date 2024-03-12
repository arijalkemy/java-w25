package com.bootcamp.ejercicio_movies_hql.service;

import com.bootcamp.ejercicio_movies_hql.model.Actor;
import com.bootcamp.ejercicio_movies_hql.model.Movie;
import com.bootcamp.ejercicio_movies_hql.repository.IActorRepository;
import com.bootcamp.ejercicio_movies_hql.repository.IMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService{
    private IMovieRepository movieRepository;
    private IActorRepository actorRepository;
    public ActorServiceImpl(IActorRepository actorRepository, IMovieRepository movieRepository){
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }
    @Override
    public List<Actor> findActorsWithFavoriteMovie() {
        return this.actorRepository.findActorByFavoriteMovieIsNotNull();
    }

    @Override
    public List<Actor> findActorsByRatingGreaterThan(Double rating) {
        return this.actorRepository.findActorByRatingGreaterThan(rating);
    }

    @Override
    public List<Actor> findActorByMovie(Integer movie_id) {
        Movie movie =  this.movieRepository.findById(movie_id).get();

        return this.actorRepository.findActorByMoviesContaining(movie);
    }
}
