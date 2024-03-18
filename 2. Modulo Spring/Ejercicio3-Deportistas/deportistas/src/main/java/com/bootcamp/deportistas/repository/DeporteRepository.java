package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.entity.Deporte;
import com.bootcamp.deportistas.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DeporteRepository {
    List<Deporte> listaDeportes = List.of(
            new Deporte("Futbol", "Intermedio"),
            new Deporte("Futbol", "Avanzado"),
            new Deporte("Natacion", "Basico"),
            new Deporte("Natacion", "Intermedio"),
            new Deporte("Voleyball", "Basico"),
            new Deporte("Volleyball", "Intermedio")
    );

    public List<Deporte> getListaDeportes() {
        return listaDeportes;
    }
}
