package com.example.controllerW25.deportistas.model;

public class PersonaDeporte {
    private Deporte deporte;
    private Persona persona;

    public PersonaDeporte(Deporte deporte, Persona persona) {
        this.deporte = deporte;
        this.persona = persona;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public Persona getPersona() {
        return persona;
    }
}
