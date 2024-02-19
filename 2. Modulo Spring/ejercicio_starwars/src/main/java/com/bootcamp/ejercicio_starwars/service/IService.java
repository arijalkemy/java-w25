package com.bootcamp.ejercicio_starwars.service;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDTO;

import java.util.List;

public interface IService {
    List<PersonajeDTO> getAll();

    List<PersonajeDTO> getCharactersByName(String name);
}
