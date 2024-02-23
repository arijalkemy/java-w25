package com.example.deportistas.repository;

import com.example.deportistas.models.Deporte;

import java.util.ArrayList;
import java.util.List;



public class DeporteRepository {
    List<Deporte> deportes = new ArrayList<>(new Deporte("Futbol", 5), new Deporte("Baloncesto", 3), new Deporte("Natacion", 4), new Deporte("Atletismo", 2), new Deporte("Ciclismo", 1));
}
