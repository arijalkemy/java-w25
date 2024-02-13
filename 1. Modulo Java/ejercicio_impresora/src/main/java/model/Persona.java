package model;

import java.util.List;

public class Persona {
    private String nombre, dni;
    private List<String> habilidades;

    public Persona(String nombre, String dni, List<String> habilidades) {
        this.nombre = nombre;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", habilidades=" + habilidades;
    }
}
