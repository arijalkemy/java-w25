package bootcamp.movieshql.util.mapper;

import bootcamp.movieshql.dto.MovieDTO;
import bootcamp.movieshql.entity.Movie;

public class MovieMapper {

    public static MovieDTO getMovieDTO(Movie movie) {
        return MovieDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .rating(movie.getRating())
                .awards(movie.getAwards())
                .releaseDate(movie.getReleaseDate())
                .length(movie.getLength())
                .build();
    }

}
