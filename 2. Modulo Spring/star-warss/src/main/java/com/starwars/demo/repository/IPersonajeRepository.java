package com.starwars.demo.repository;

import com.starwars.demo.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> getPersonajes();
}
