package com.example.starWars.service;

import com.example.starWars.dto.PersonajeDTO;
import com.example.starWars.entity.Personaje;

import java.util.List;

public interface BuscarNombre {
    public List<PersonajeDTO> BuscarPersonaje(String name);
}
