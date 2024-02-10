package org.example.Documentos;

import org.example.Interfaces.Imprimible;

import java.util.ArrayList;

public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    private String descripcion;
    private String experienciaLaboral;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String descripcion, String experienciaLaboral, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.experienciaLaboral = experienciaLaboral;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Experiencia Laboral: " + experienciaLaboral);
        System.out.println("Habilidades: " + habilidades);
        System.out.println();
    }
}
