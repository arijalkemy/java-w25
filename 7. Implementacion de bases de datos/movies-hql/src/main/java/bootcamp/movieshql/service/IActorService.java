package bootcamp.movieshql.service;

import bootcamp.movieshql.dto.ActorDTO;
import bootcamp.movieshql.dto.response.ActorWithFavoriteMovieDTO;

import java.util.List;

public interface IActorService {

    List<ActorDTO> getAllActors();

    List<ActorWithFavoriteMovieDTO> getActorsWithFavoriteMovie();

    List<ActorDTO> getActorsWithRatingGreaterThanGiven(Double rating);

    List<ActorDTO> getActorWorkedInMovie(String movie);

}
