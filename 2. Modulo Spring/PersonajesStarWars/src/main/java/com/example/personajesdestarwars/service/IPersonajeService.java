package com.example.personajesdestarwars.service;

import com.example.personajesdestarwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> findAllByNameContains(String query);
}
