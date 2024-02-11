package com.bootcamp.Deportistas.Repository;

import com.bootcamp.Deportistas.Model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {
    final static List<Deporte> deportes = new ArrayList<Deporte>(List.of(new Deporte("Futbol", 1), new Deporte("basquet", 2)));

}
