package com.bootcamp.StarWars.service;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import java.io.FileNotFoundException;
import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> buscarPersonajesPorNombre(String nombre) throws FileNotFoundException;
}
