package com.example.controllerW25.covid.service;

import com.example.controllerW25.covid.dto.PersonaDeRiesgoDTO;
import com.example.controllerW25.covid.entity.Persona;
import com.example.controllerW25.covid.entity.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CovidService {
    private final List<Persona> personas;
    private final List<Sintoma> sintomas;

    public CovidService() {
        this.sintomas = new ArrayList<>(List.of(
                new Sintoma("Fiebre", "Fiebre", 5),
                new Sintoma("Dolor de cabeza", "Dolor de cabeza", 3),
                new Sintoma("Dolor de garganta", "Dolor de garganta", 3)
        ));
        this.personas = new ArrayList<>(List.of(
                new Persona(1, "Juan", "Perez", 63,
                        List.of(sintomas.get(0))),
                new Persona(2, "Maria", "Gomez", 25,
                        List.of(sintomas.get(1), sintomas.get(2))),
                new Persona(3, "Pedro", "Rodriguez", 30,
                        List.of(sintomas.get(0), sintomas.get(1), sintomas.get(2))),
                new Persona(3, "Pedro", "Rodriguez", 75,
                        List.of())
                ));
    }
    public List<Sintoma> findAllSymptoms() {
        return sintomas;
    }
    public Sintoma findSymptom(String name) {
        return sintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    public List<PersonaDeRiesgoDTO> findGrupoDeRiesgo() {
        return personas.stream()
                .filter(persona -> !persona.getSintomas().isEmpty() && persona.getEdad() > 60)
                .map(PersonaDeRiesgoDTO::fromPersona)
                .toList();
    }
}
