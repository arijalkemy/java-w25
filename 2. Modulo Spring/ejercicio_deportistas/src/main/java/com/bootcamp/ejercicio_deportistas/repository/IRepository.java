package com.bootcamp.ejercicio_deportistas.repository;

import com.bootcamp.ejercicio_deportistas.entity.Deporte;
import com.bootcamp.ejercicio_deportistas.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IRepository {
    List<Deporte> getAllSports();
    Optional<Deporte> getSportByName(String name);
    List<Persona> getPeople();
}
