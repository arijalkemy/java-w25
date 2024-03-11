package org.example.entities;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;

    public Persona(java.lang.String nombre, java.lang.String apellido, java.lang.String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Persona{" +
                "nombre=" + nombre +
                ", apellido=" + apellido +
                ", dni=" + dni +
                '}';
    }
}
