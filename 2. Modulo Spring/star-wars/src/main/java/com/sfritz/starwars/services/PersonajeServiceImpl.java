package com.sfritz.starwars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sfritz.starwars.dtos.PersonajeDTO;
import com.sfritz.starwars.entities.Personaje;
import com.sfritz.starwars.repositories.PersonajeRepository;
import com.sfritz.starwars.repositories.PersonajeRepositoryImpl;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    private PersonajeRepository repository;

    public PersonajeServiceImpl(PersonajeRepositoryImpl repository){
        this.repository = repository;
    }

    @Override
    public List<PersonajeDTO> getPersonajesByName(String name) {
        List<Personaje> personajes = repository.getPersonajeByName(name);
        //Transformamos la entidad Personaje a PersonajeDTO
        return new ArrayList<>();
    }

}
