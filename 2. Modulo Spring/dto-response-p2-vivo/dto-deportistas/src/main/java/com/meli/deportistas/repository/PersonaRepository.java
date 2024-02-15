package com.meli.deportistas.repository;

import com.meli.deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {
    List<Persona> personas = new ArrayList<>();

    public PersonaRepository() {
        personas.add(new Persona("Erling","Haaland",23));
        personas.add(new Persona("Leo","Messi",36));
        personas.add(new Persona("Rafa","Nadal",23));
        personas.add(new Persona("Nicolas","Chavez",50));

    }

    public List<Persona> findAll(){
        return this.personas;
    }

}
