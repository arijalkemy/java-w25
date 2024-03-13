package com.mercadolibre.movies.repository;

import com.mercadolibre.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
}
