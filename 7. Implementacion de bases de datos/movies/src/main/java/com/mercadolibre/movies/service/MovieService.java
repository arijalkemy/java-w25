package com.mercadolibre.movies.service;

import com.mercadolibre.movies.model.Movie;
import com.mercadolibre.movies.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService{
    private final IMovieRepository repository;
    @Override
    public List<Movie> getAllMovies(){
        return repository.findAll();
    }
}
