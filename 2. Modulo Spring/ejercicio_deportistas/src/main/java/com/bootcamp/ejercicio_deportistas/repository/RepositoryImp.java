package com.bootcamp.ejercicio_deportistas.repository;

import com.bootcamp.ejercicio_deportistas.entity.Deporte;
import com.bootcamp.ejercicio_deportistas.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryImp implements IRepository{
    List<Deporte> deportes;
    List<Persona> personas;

    public RepositoryImp() {
        this.deportes = new ArrayList<>(
                Arrays.asList(
                        new Deporte("Futbol", "Dificil"),
                        new Deporte("Natacion", "Medio"),
                        new Deporte("Croquet", "Facil")
                )
        );
        this.personas = new ArrayList<>(
                Arrays.asList(
                        new Persona("Ramiro", "Balduzzi", 20, deportes.get(0)),
                        new Persona("Luisa", "Paulos", 20, deportes.get(1)),
                        new Persona("Martiniano", "Natale", 20, deportes.get(2))
                )
        );
    }

    @Override
    public List<Deporte> getAllSports() {
        return deportes;
    }

    @Override
    public Optional<Deporte> getSportByName(String name) {
        return deportes.stream()
                .filter(sport -> sport.getNombre().equals(name))
                .findFirst();
    }

    @Override
    public List<Persona> getPeople() {
        return personas;
    }
}
