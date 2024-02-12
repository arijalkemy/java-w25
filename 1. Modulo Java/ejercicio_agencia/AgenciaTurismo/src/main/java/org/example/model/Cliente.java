package org.example.model;

public class Cliente {

    private Integer DNI;
    private String nombre;

    public Cliente(int dni, String nombre) {
        this.DNI = dni;
        this.nombre = nombre;
    }

    public Integer getDni() {
        return DNI;
    }

    public void setDni(Integer DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
