package com.example.ejemplo_jpa.controller;

import com.example.ejemplo_jpa.model.Movie;
import com.example.ejemplo_jpa.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{name}")
    public List<Movie> findMoviesByTitle(
            @PathVariable String name
    ) {
        return movieService.getMoviesByName(name);
    }
}
