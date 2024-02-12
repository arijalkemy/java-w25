package org.example;

public class Cliente {

    private String nombre;
    private int dni;

    public Cliente(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nombre='" + nombre + '\'' +
                ", DNI=" + dni +
                '}';
    }
}
