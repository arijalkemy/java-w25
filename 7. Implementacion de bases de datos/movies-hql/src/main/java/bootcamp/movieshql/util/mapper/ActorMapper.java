package bootcamp.movieshql.util.mapper;

import bootcamp.movieshql.dto.ActorDTO;
import bootcamp.movieshql.dto.response.ActorWithFavoriteMovieDTO;
import bootcamp.movieshql.entity.Actor;

public class ActorMapper {

    public static ActorDTO getActorDTO(Actor actor) {
        return ActorDTO.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .rating(actor.getRating())
                .build();
    }

    public static ActorWithFavoriteMovieDTO getActorWithFavoriteMovieDTO(Actor actor) {
        return ActorWithFavoriteMovieDTO.builder()
                .fullName(actor.getFirstName() + " " + actor.getLastName())
                .build();
    }

}
