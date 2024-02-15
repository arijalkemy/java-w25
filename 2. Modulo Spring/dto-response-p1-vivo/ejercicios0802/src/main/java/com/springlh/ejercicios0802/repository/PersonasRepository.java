package com.springlh.ejercicios0802.repository;

import com.springlh.ejercicios0802.model.Deporte;
import com.springlh.ejercicios0802.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PersonasRepository {
    List<Persona> personas = Arrays.asList(
            new Persona("Fulano", "Fulanez",19),
            new Persona("Mengano", "Menganios",25),
            new Persona("Agnostico", "Corasao",17),
            new Persona("Alejandro", "Skyrzuchk",36),
            new Persona("Hefesto", "Olimpo",43),
            new Persona("Rigoberta", "Legrand",55),
            new Persona("Serralima", "Martaserra",64)
    );

    public List<Persona> getPersonas() {
        return personas;
    }
}
