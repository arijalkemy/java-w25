package com.mercadolibre.movies.service;

import com.mercadolibre.movies.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IMovieService {

    List<Movie> getAllMovies();
}
