package com.example.deportistas.repository;

import com.example.deportistas.model.Persona;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository {

    DeporteRepository deporteRepository = new DeporteRepository();
    @Getter
    List<Persona> personas = List.of(new Persona("Juan", "Perez",deporteRepository.getDeportes().get(1), 25), new Persona("Maria", "Lopez", deporteRepository.getDeportes().get(2), 30), new Persona("Pedro", "Gomez", deporteRepository.deportes.get(3), 20), new Persona("Ana", "Garcia", deporteRepository.deportes.get(4), 35), new Persona("Luis", "Martinez", deporteRepository.deportes.get(1), 40));

}
