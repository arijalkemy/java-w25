package com.bootcamp.StarWars.repository;

import com.bootcamp.StarWars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> getPersonajes();
}
