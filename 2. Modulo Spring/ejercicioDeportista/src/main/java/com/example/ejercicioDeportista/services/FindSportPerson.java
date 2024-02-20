package com.example.ejercicioDeportista.services;

import com.example.ejercicioDeportista.dto.PersonasDeportistaDTO;

import java.util.List;

public class FindSportPerson {
    List<PersonasDeportistaDTO> listadoPersonasDeportistas;


    public FindSportPerson(List<PersonasDeportistaDTO> listadoPersonasDeportistas) {
        this.listadoPersonasDeportistas = listadoPersonasDeportistas;
    }
    public List<PersonasDeportistaDTO> FindSportPersons() {
        listadoPersonasDeportistas.add(new PersonasDeportistaDTO("Juan", "Perez", "Tenis"));
        listadoPersonasDeportistas.add(new PersonasDeportistaDTO("María", "González", "Fulbol"));
        listadoPersonasDeportistas.add(new PersonasDeportistaDTO("Pedro", "López", "Baloncesto"));

        return listadoPersonasDeportistas;
    }
}
