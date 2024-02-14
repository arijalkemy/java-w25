package main.service;

import java.util.List;

import main.dto.PersonajeDTO;

public interface IPersonajeService {
    public List<PersonajeDTO> starWarsName(String name);
}
