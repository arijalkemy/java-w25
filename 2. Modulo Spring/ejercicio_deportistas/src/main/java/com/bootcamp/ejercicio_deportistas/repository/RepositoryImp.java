package com.bootcamp.ejercicio_deportistas.repository;

import com.bootcamp.ejercicio_deportistas.entity.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RepositoryImp implements IRepository{
    List<Deporte> deportes;

    public RepositoryImp() {
        this.deportes = new ArrayList<>(
                Arrays.asList(
                        new Deporte("Futbol", "Dificil"),
                        new Deporte("Natacion", "Medio"),
                        new Deporte("Croquet", "Facil")
                )
        );
    }

    @Override
    public List<Deporte> getAllSports() {
        return deportes;
    }
}
