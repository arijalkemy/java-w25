package com.meli.starwars.repository;

import com.meli.starwars.entity.Personaje;

import java.util.List;

public interface PersonajeRepository {

    List<Personaje> findByName(String name);
}
