package com.bootcamp.clase9feb.starWars.repositories;

import com.bootcamp.clase9feb.starWars.entities.Personaje;

import java.util.List;


public interface IPersonajeRepository {
    public List<Personaje> getByName(String name);
}
