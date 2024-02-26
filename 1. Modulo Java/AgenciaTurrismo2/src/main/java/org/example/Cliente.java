package org.example;

import org.example.repo.RepoLocalizadorImpl;

public class Cliente {
    private String nombre;
    private String dni;
    private String apellido;

    public Cliente(String nombre, String dni, String apellido) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
