package com.example.controllerW25.deportistas.dto;

import com.example.controllerW25.deportistas.model.PersonaDeporte;

public class PersonaDeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;

    public PersonaDeportistaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDeporte() {
        return deporte;
    }

    public static PersonaDeportistaDTO fromPersonaDeporte(PersonaDeporte personaDeporte) {
        return new PersonaDeportistaDTO(personaDeporte.getPersona().getNombre(), personaDeporte.getPersona().getApellido(), personaDeporte.getDeporte().getNombre());
    }
}
