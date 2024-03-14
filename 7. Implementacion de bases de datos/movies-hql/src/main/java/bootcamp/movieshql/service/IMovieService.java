package bootcamp.movieshql.service;

import bootcamp.movieshql.dto.MovieDTO;

import java.util.List;

public interface IMovieService {

    List<MovieDTO> getAllMovies();

    List<MovieDTO> getMovieWithActorsWithRatingGreaterThanGiven(Double rating);

}
