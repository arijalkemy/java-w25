package com.example.personajesdestarwars.repositories;

import com.example.personajesdestarwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findAllByNameContains(String query);
}
