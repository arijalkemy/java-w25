package bootcamp.movieshql.controller;

import bootcamp.movieshql.dto.MovieDTO;
import bootcamp.movieshql.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/actors-with-rating-greater-than/{rating}")
    public ResponseEntity<List<MovieDTO>> getMoviesWorkedInMovie(@PathVariable Double rating) {
        return ResponseEntity.ok(movieService.getMovieWithActorsWithRatingGreaterThanGiven(rating));
    }

}
