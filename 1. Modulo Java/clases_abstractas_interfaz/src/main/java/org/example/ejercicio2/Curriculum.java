package org.example.ejercicio2;

import java.util.Arrays;

public class Curriculum implements Imprimible{
    private String nombre;
    private String nacionalidad;
    private String[] habilidades;

    public Curriculum(String nombre, String nacionalidad, String[] habilidades) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}');
    }
}
