package com.example.classes;

public class Cliente {
    private static int contador = 0;
    private int id;
    private String nombre;
    private String apellido;

    public Cliente(String nombre, String apellido) {
        this.id = ++Cliente.contador;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
    }

}
