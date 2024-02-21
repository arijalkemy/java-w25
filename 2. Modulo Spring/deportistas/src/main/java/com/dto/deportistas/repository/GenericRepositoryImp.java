package com.dto.deportistas.repository;

import com.dto.deportistas.model.Deporte;
import com.dto.deportistas.model.Persona;
import com.dto.deportistas.utils.Nivel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenericRepositoryImp implements IGenericRepository<Persona> {
    // Deportes
    Deporte futbol = new Deporte("Futbol", Nivel.BASICO.name());
    Deporte voley = new Deporte("Voley", Nivel.BASICO.name());
    Deporte hockey = new Deporte("Hockey", Nivel.MODERADO.name());
    Deporte snowboard = new Deporte("Snowboard", Nivel.DIFICIL.name());
    // Personas
    Persona persona1 = new Persona("Sebastian", "Avila", 33, futbol);
    Persona persona2 = new Persona("Pablo", "Kass", 43, voley);
    Persona persona3 = new Persona("Eduardo", "Perez", 31, hockey);
    Persona persona4 = new Persona("Santiago", "Lopez", 25, snowboard);
    Persona persona5 = new Persona("Aurora", "Matulaniec", 27, snowboard);

    @Override
    public List<Persona> getLista() {
        List<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        personas.add(persona5);
        return personas;
    }
}
