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

    private PersonajeRepository repository = new PersonajeRepositoryImpl();

    public PersonajeServiceImpl(){}

    @Override
    public List<PersonajeDTO> getPersonajesByName(String name) {
        List<Personaje> personajes = repository.getPersonajeByName(name);
        //Transformamos la entidad Personaje a PersonajeDTO
        return new ArrayList<>();
    }

}
