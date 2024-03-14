package bootcamp.movieshql.service.implementation;

import bootcamp.movieshql.dto.ActorDTO;
import bootcamp.movieshql.dto.response.ActorWithFavoriteMovieDTO;
import bootcamp.movieshql.repository.IActorRepository;
import bootcamp.movieshql.service.IActorService;
import bootcamp.movieshql.util.mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImp implements IActorService {

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public List<ActorDTO> getAllActors() {
        return actorRepository.findAll().stream().map(ActorMapper::getActorDTO).toList();
    }

    @Override
    public List<ActorWithFavoriteMovieDTO> getActorsWithFavoriteMovie() {
        return actorRepository.findAll().stream().filter(a -> a.getFavoriteMovie() != null).map(ActorMapper::getActorWithFavoriteMovieDTO).toList();
    }

    @Override
    public List<ActorDTO> getActorsWithRatingGreaterThanGiven(Double rating) {
        return actorRepository.getActorsWithRatingGreaterThanGiven(rating).stream().map(ActorMapper::getActorDTO).toList();
    }

    @Override
    public List<ActorDTO> getActorWorkedInMovie(String movie) {
        return actorRepository.getActorWorkedInMovie(movie).stream().map(ActorMapper::getActorDTO).toList();
    }

}
