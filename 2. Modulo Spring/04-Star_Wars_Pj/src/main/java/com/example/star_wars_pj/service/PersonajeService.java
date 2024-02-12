package com.example.star_wars_pj.service;

import com.example.star_wars_pj.dto.PersonajeDto;
import com.example.star_wars_pj.entity.Personaje;
import com.example.star_wars_pj.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {

    PersonajeRepository repository = new PersonajeRepository();


    public List<PersonajeDto> getAll(){


        return repository.getPersonajesSW().stream().map(personaje -> new PersonajeDto(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies())).toList();
    }

    public List<PersonajeDto> getBySearch(String keyword){

        return  repository.getPersonajesSW().stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(keyword.toLowerCase()))
                .map(personaje -> new PersonajeDto(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()))
                .toList();

    }




}
