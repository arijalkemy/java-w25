package com.example.ejercicioDeportista.services;

import com.example.ejercicioDeportista.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class findSports {
    private List<Deporte> findSport;

    public findSports(List<Deporte> findSport) {
        this.findSport = findSport;
    }

    public List<Deporte> findSports(){
        findSport.add(new Deporte("Futbol", 5));
        findSport.add(new Deporte("Baloncesto", 4));
        findSport.add(new Deporte("Tenis", 3));

        return findSport;
    }
}
