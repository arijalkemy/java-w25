package com.example.ejercicio_practica_hql.service;

import com.example.ejercicio_practica_hql.dto.response.ActorDTO;
import com.example.ejercicio_practica_hql.model.Actor;
import com.example.ejercicio_practica_hql.repository.IActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService{

    private final IActorRepository actorRepository;

    public ActorServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDTO> listActorsWithFavMovies() {
        List<Actor> actors = actorRepository.listActors();
        return null;
    }
}
