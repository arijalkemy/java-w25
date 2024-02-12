package com.example.controllerW25.deportistas.model;

public class Deporte {
    private String nombre;
    private int nivel;

    public Deporte(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

}
