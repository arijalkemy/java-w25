package main.service;

import main.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {

    List<PersonajeDTO> searchCharacter (String character);
}
