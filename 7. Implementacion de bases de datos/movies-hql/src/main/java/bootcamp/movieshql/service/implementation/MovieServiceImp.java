package bootcamp.movieshql.service.implementation;

import bootcamp.movieshql.dto.MovieDTO;
import bootcamp.movieshql.repository.IMovieRepository;
import bootcamp.movieshql.service.IMovieService;
import bootcamp.movieshql.util.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(MovieMapper::getMovieDTO).toList();
    }

    @Override
    public List<MovieDTO> getMovieWithActorsWithRatingGreaterThanGiven(Double rating) {
        return movieRepository.getMovieWithActorsWithRatingGreaterThanGiven(rating).stream().map(MovieMapper::getMovieDTO).toList();
    }

}
