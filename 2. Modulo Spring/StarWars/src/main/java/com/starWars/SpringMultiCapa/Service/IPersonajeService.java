package com.starWars.SpringMultiCapa.Service;

import com.starWars.SpringMultiCapa.Controller.DTOs.PersonajeDTO;

import java.io.FileNotFoundException;
import java.util.List;

public interface IPersonajeService {

    public List<PersonajeDTO> obtenerPersonajes(String nombre) throws FileNotFoundException;
}
