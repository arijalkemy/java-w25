package com.example.deportistas.repository;

import com.example.deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DeporteRepository {
    List<Deporte> deportes = List.of(new Deporte("Futbol", 5), new Deporte("Baloncesto", 3), new Deporte("Natacion", 4), new Deporte("Atletismo", 2), new Deporte("Ciclismo", 1));

    public List<Deporte> getDeportes() {
        return deportes;
    }

}
