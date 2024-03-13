package com.mercadolibre.movies.controller;

import com.mercadolibre.movies.model.Movie;
import com.mercadolibre.movies.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final IMovieService service;
    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(service.getAllMovies());
    }
}
