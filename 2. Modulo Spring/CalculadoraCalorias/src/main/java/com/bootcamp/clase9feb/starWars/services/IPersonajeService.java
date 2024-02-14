package com.bootcamp.clase9feb.starWars.services;

import com.bootcamp.clase9feb.starWars.dto.response.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> getByName(String name);
}
