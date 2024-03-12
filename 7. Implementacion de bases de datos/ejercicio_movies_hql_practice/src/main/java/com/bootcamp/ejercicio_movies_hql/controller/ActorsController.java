package com.bootcamp.ejercicio_movies_hql.controller;

import com.bootcamp.ejercicio_movies_hql.service.ActorServiceImpl;
import com.bootcamp.ejercicio_movies_hql.service.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actor")
public class ActorsController {
    private IActorService actorService;
    public ActorsController(ActorServiceImpl actorService){
        this.actorService = actorService;
    }

    @GetMapping("/with_favorite_movie")
    public ResponseEntity<?> getActorWithFavoriteMovie(){
        return new ResponseEntity<>(this.actorService.findActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getActorsWithRating(@RequestParam Double rating){
        return new ResponseEntity<>(this.actorService.findActorsByRatingGreaterThan(rating), HttpStatus.OK);
    }
    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<?> getActorsByMovie(@PathVariable Integer movie_id){
        return new ResponseEntity<>(this.actorService.findActorByMovie(movie_id), HttpStatus.OK);
    }
}
