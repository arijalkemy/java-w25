package com.bootcamp.ejercicio_starwars.repository;

import com.bootcamp.ejercicio_starwars.entity.Personaje;

import java.util.List;

public interface IRepository {
    List<Personaje> getAll();

    List<Personaje> getCharactersByName(String name);
}
