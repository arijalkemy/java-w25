package com.example.controllerW25.covid.dto;

import com.example.controllerW25.covid.entity.Persona;

import java.util.List;

public class PersonaDeRiesgoDTO {
    private String nombre;
    private String apellido;

    private PersonaDeRiesgoDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static PersonaDeRiesgoDTO fromPersona(Persona persona){
        return new PersonaDeRiesgoDTO(persona.getNombre(), persona.getApellido());
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
