package com.deportistas.EjercicioPracticoSpringEnVivo2.service;

import com.deportistas.EjercicioPracticoSpringEnVivo2.controller.DTOs.DeportistaDTO;
import com.deportistas.EjercicioPracticoSpringEnVivo2.model.Deporte;
import com.deportistas.EjercicioPracticoSpringEnVivo2.model.Deportista;
import com.deportistas.EjercicioPracticoSpringEnVivo2.model.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeportistaService {


    private List<Deporte> deportes = Arrays.asList(
            new Deporte("Futbol",2),
            new Deporte("Voley",7),
            new Deporte("Basquet",4)
    );

    private List<Persona> personas = Arrays.asList(
            new Persona("Juan","Restrepo",22),
            new Persona("Daniel","Rosdriguez",25),
            new Persona("Leo","Messi",27)
    );
    private List<Deportista> deportistas = Arrays.asList(
            new Deportista(personas.get(0),deportes.get(0)),
            new Deportista(personas.get(1),deportes.get(1)),
            new Deportista(personas.get(2),deportes.get(2))
    );

    public List<DeportistaDTO> findDeportistas(){
        List<DeportistaDTO> deportistasResponse = new ArrayList<>();
        for (Deportista deportista:
             deportistas) {
            deportistasResponse.add(new DeportistaDTO(deportista.getPersona().getNombre()
            ,deportista.getPersona().getApellido()
            ,deportista.getDeporte().getNombre()));
        }
        return deportistasResponse;
    }
}
