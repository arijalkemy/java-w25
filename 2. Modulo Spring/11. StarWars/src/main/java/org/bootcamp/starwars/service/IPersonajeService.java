package org.bootcamp.starwars.service;

import org.bootcamp.starwars.DTO.PersonajeDto;
import org.bootcamp.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> getAll();
}
