package com.sfritz.starwars.repositories;

import java.util.List;

import com.sfritz.starwars.entities.Personaje;

public interface PersonajeRepository {
    
    List<Personaje> getPersonajeByName(String name);
}
