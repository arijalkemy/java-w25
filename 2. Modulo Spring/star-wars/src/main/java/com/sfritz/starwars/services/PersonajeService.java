package com.sfritz.starwars.services;

import java.util.List;

import com.sfritz.starwars.dtos.PersonajeDTO;

public interface PersonajeService {

    List<PersonajeDTO> getPersonajesByName(String name);
}
