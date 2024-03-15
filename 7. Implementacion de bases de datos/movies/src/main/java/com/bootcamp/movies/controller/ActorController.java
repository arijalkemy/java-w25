package com.bootcamp.movies.controller;

import com.bootcamp.movies.model.ActorEpisode;
import com.bootcamp.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {


    @Autowired
    private ActorService actorService;

    @GetMapping("/favorite/{actorId}")
    public ResponseEntity<?> getActorFavoriteMovie(@PathVariable Long actorId){
        return new ResponseEntity<>(actorService.getFavoriteMovie(actorId), HttpStatus.OK);
    }
    @GetMapping("/favorite")
    public ResponseEntity<?> getActorsByFavoriteMovieIsNotNull(){
        return new ResponseEntity<>(actorService.findActorsByFavoriteMovieIsNotNull(), HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> getActorsByRatingBetterThan(@PathVariable Double rating){
        return new ResponseEntity<>(actorService.findActorsByRatingBetterThan(rating), HttpStatus.OK);
    }
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<?> getActorsByMovieId(@PathVariable Long movieId){
        return new ResponseEntity<>(actorService.findActorsByMovieId(movieId), HttpStatus.OK);
    }
}
