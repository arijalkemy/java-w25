package bootcamp.movieshql.controller;

import bootcamp.movieshql.dto.ActorDTO;
import bootcamp.movieshql.dto.response.ActorWithFavoriteMovieDTO;
import bootcamp.movieshql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("actors")
public class ActorController {

    @Autowired
    private IActorService actorService;

    @GetMapping
    public ResponseEntity<List<ActorDTO>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/with-favorite-movie")
    public ResponseEntity<List<ActorWithFavoriteMovieDTO>> getActorsWithFavoriteMovie() {
        return ResponseEntity.ok(actorService.getActorsWithFavoriteMovie());
    }

    @GetMapping("/rating-greater-than/{rating}")
    public ResponseEntity<List<ActorDTO>> getActorsWithFavoriteMovie(@PathVariable Double rating) {
        return ResponseEntity.ok(actorService.getActorsWithRatingGreaterThanGiven(rating));
    }

    @GetMapping("/worked-in/{movie}")
    public ResponseEntity<List<ActorDTO>> getActorsWorkedInMovie(@PathVariable String movie) {
        return ResponseEntity.ok(actorService.getActorWorkedInMovie(movie));
    }

}
