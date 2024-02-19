package com.bootcamp.ejercicio_starwars.service;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDTO;
import com.bootcamp.ejercicio_starwars.entity.Personaje;
import com.bootcamp.ejercicio_starwars.repository.IRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImp implements IService{
    IRepository repository;

    public ServiceImp(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PersonajeDTO> getAll() {
        List<Personaje> personajeList = repository.getAll();
        return personajeList.stream()
                .map(this::convertCharacterToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonajeDTO> getCharactersByName(String name) {
        List<Personaje> personajeList =  repository.getCharactersByName(name);
        return personajeList.stream()
                .map(this::convertCharacterToDTO)
                .collect(Collectors.toList());
    }

    private PersonajeDTO convertCharacterToDTO(Personaje personaje){
        return new PersonajeDTO(
                personaje.getName(),
                personaje.getGender(),
                personaje.getHomeworld(),
                personaje.getSpecies(),
                personaje.getHeight(),
                personaje.getMass()
        );
    }
}

