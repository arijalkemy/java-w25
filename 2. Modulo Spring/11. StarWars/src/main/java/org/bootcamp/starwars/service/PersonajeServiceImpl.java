package org.bootcamp.starwars.service;

import org.bootcamp.starwars.DTO.PersonajeDto;
import org.bootcamp.starwars.entity.Personaje;
import org.bootcamp.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    PersonajeRepository personajeRepository;
    @Override
    public List<PersonajeDto> getAll(){
        personajeRepository.leerPersonajesDesdeJson("src/main/resources/static/3. c. starwars.json");
        List<PersonajeDto> personajesDto = new ArrayList<>();

        personajeRepository.getPersonajes().forEach(personaje -> {
            personajesDto.add(mapPersonaje(personaje));
        });
        return personajesDto;
    }

    public PersonajeDto mapPersonaje(Personaje personaje){
        return new PersonajeDto(personaje.getName(),personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies());
    }



}
