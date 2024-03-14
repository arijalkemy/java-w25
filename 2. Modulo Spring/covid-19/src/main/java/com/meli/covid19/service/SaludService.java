package com.meli.covid19.service;

import com.meli.covid19.dto.PersonaRiesgoDTO;
import com.meli.covid19.entity.Persona;
import com.meli.covid19.entity.Sintoma;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaludService {
    private List<Persona> personas = new ArrayList<>();
    private List<Sintoma> sintomas = new ArrayList<>();

    @PostConstruct
    public void initData() {
        sintomas.add(new Sintoma("S001", "Tos seca", 2));
        sintomas.add(new Sintoma("S002", "Fiebre", 3));
        sintomas.add(new Sintoma("S003", "Dificultad para respirar", 4));

        personas.add(new Persona(1L, "Juan", "Pérez", 65));
        personas.add(new Persona(2L, "María", "González", 72));
        personas.add(new Persona(3L, "Carlos", "Fernández", 58));
        personas.add(new Persona(4L, "Laura", "Martínez", 70));
    }

    public List<Sintoma> findAllSymptoms() {
        return sintomas;
    }

    public Sintoma findSymptomByName(String name) {
        return sintomas.stream().filter(s -> s.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public List<PersonaRiesgoDTO> findRiskPersons() {
        return personas.stream().filter(p -> p.getEdad() > 60)
                .map(p -> new PersonaRiesgoDTO(p.getNombre(), p.getApellido()))
                .collect(Collectors.toList());
    }
}