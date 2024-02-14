package com.deportistas.EjercicioPracticoSpringEnVivo2.service;

import com.deportistas.EjercicioPracticoSpringEnVivo2.model.Deporte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class DeporteService {

    private List<Deporte> deportes = Arrays.asList(
            new Deporte("Futbol",2),
            new Deporte("Voley",7),
            new Deporte("Basquet",4)
    );

    public List<Deporte> returnDeportes(){
        return deportes;
    }

    public Integer existsDeporte(String nombre){
        Optional<Deporte> deporte = deportes.stream()
                .filter(sport -> sport.getNombre().equals(nombre))
                .findFirst();
        if(deporte.isEmpty()){
            return 0;
        }
        return deporte.get().getNivel();
    }



}
