package com.example.controllerW25.deportistas.service;

import com.example.controllerW25.deportistas.dto.PersonaDeportistaDTO;
import com.example.controllerW25.deportistas.model.Deporte;
import com.example.controllerW25.deportistas.model.Persona;
import com.example.controllerW25.deportistas.model.PersonaDeporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportistaService {
    private final List<Deporte> deportes;
    private final List<Persona> personas;
    private final List<PersonaDeporte> personaDeportes;

    public DeportistaService() {
        this.deportes = new ArrayList<>(List.of(
                new Deporte("Futbol", 5),
                new Deporte("Tenis", 3),
                new Deporte("Natacion", 1)));
        this.personas = new ArrayList<>(List.of(
                new Persona("Juan", "Perez", 20),
                new Persona("Maria", "Gomez", 25),
                new Persona("Pedro", "Rodriguez", 30)));
        this.personaDeportes = new ArrayList<>(List.of(
                new PersonaDeporte(deportes.get(0), personas.get(0)),
                new PersonaDeporte(deportes.get(1), personas.get(1)),
                new PersonaDeporte(deportes.get(2), personas.get(0))));
    }

    public List<Deporte> findAllSports() {
        return deportes;
    }

    public Deporte findSport(String name) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<PersonaDeportistaDTO> findSportPersons() {
        return personaDeportes.stream().map(PersonaDeportistaDTO::fromPersonaDeporte).toList();
    }

}
