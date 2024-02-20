package com.example.starWars.service;

import com.example.starWars.dto.PersonajeDTO;
import com.example.starWars.entity.Personaje;
import com.example.starWars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarNombreImpl implements BuscarNombre{

    private final PersonajeRepository personajeRepository;

    public BuscarNombreImpl(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }


    @Override
    public List<PersonajeDTO> BuscarPersonaje(String name) {
        return personajeRepository.buscarNombre(name);
    }
}
