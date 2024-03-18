package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.PersonaDeporteDTO;
import com.bootcamp.deportistas.entity.Deporte;
import com.bootcamp.deportistas.repository.DeporteRepository;
import com.bootcamp.deportistas.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaDeporteService {

    DeporteRepository deporteRepository = new DeporteRepository();
    PersonaRepository personaRepository = new PersonaRepository();

    //Servicio para encontrar todos los deportes
    public List<DeporteDTO> findSports(){
        return deporteRepository.getListaDeportes().stream()
                .map(DeporteDTO::new)
                .toList();
    }

    //Servicio para encontrar los deportes por su nombre
    public DeporteDTO findSportsName(String name){
        Deporte deporte = deporteRepository.getListaDeportes().stream()
                .filter(d -> d.getNombre().equals(name))
                .findFirst()
                .orElse(null);
        return new DeporteDTO(deporte);
    }

    //Servicio para encontrar todos los deportistas
    public List<PersonaDeporteDTO> findSportsPersons(){
        return personaRepository.getListaPersonas().stream()
                .filter(persona -> !persona.getDeportes().isEmpty())
                .map(PersonaDeporteDTO::new)
                .toList();

    }
}
