package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.PersonaDeporteDTO;
import com.bootcamp.deportistas.entity.Deporte;
import com.bootcamp.deportistas.entity.Persona;
import com.bootcamp.deportistas.repository.DeporteRepository;
import com.bootcamp.deportistas.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaDeporteService {

    DeporteRepository deporteRepository = new DeporteRepository();
    PersonaRepository personaRepository = new PersonaRepository();

    //Servicio para encontrar todos los deportes
    public List<Deporte> findSports(){
        return deporteRepository.getListaDeportes();
    }

    //Servicio para encontrar los deportes por su nombre
    public List<Deporte> findSportsName(){

    }

    //Servicio para encontrar todos los deportistas
    public List<PersonaDeporteDTO> findSportsPersons(){
        List<PersonaDeporteDTO> personaDeporteDTOS = new ArrayList<>();

        for (Persona persona : personaRepository.getListaPersonas()) {

        }

    }
}
