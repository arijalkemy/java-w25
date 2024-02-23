package com.codigoMorse.CodigoMorse.Model;

import lombok.Getter;
import lombok.Setter;

public class Deporte {

    private String nombre;
    private String nivel;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
