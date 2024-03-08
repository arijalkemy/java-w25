package com.example.starwars.repository;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> findByName(String word);
}
