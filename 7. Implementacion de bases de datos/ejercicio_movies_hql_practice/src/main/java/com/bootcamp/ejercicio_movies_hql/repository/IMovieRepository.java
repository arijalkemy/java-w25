package com.bootcamp.ejercicio_movies_hql.repository;

import com.bootcamp.ejercicio_movies_hql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
}
