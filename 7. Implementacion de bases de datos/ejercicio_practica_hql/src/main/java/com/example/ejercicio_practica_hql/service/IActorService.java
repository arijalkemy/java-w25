package com.example.ejercicio_practica_hql.service;

import com.example.ejercicio_practica_hql.dto.response.ActorDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> listActorsWithFavMovies();
}
