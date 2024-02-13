package org.example.ejercicio_2_documentos.auxiliares;

import java.util.ArrayList;

public class Persona {
    private String nombreCompleto;
    private int edad;
    private int dni;
    private ArrayList<String> habilidades;

    public Persona(String nombreCompleto, int edad, int dni, ArrayList<String> habilidades) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    public Persona() {
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void addHabilidad(String habilidad) {
        if (!this.habilidades.contains(habilidad)) {
            this.habilidades.add(habilidad);
        } else {
            System.out.println("La habilidad ya existe en la lista.");
        }
    }
}
