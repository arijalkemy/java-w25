package com.practicaEjerciciosp1Vivo.deportistas.repositories;

import com.practicaEjerciciosp1Vivo.deportistas.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {
    List<Deporte> deportes = new ArrayList<>();

    public DeporteRepository() {
        Deporte deporte1 = new Deporte("Futbol", "1");
        Deporte deporte2 = new Deporte("Basquet", "2");
        Deporte deporte3 = new Deporte("Tenis", "3");
        this.deportes.add(deporte1);
        this.deportes.add(deporte2);
        this.deportes.add(deporte3);
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void addDeporte(Deporte deporte){
        this.deportes.add(deporte);
    }
}
