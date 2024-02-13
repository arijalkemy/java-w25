package com.bootcamp.StarWars.repository;

import com.bootcamp.StarWars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.List;
@Repository
public class PersonajeRepositorio {

    private List<Personaje> personajes;

    public PersonajeRepositorio() throws FileNotFoundException {
        personajes = LecturaJson.leerArchivoJson();
    }

    public void mostrarPersonajes() {
        for(Personaje pj: personajes){
            System.out.println(pj.getName());
        }
    }

    public List<Personaje> getPersonajes() {
        return this.personajes;
    }
}
