package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.model.Movie;
import com.example.ejemplo_jpa.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMoviesByName(String name) {
        return movieRepository.findMovieByTitle(name);
    }

}
