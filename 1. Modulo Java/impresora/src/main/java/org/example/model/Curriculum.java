package org.example.model;

import java.util.List;

public class Curriculum extends Documento{

    private String nombre;
    private String apellido;
    private Integer telefono;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, Integer telefono, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum de la persona: " + nombre + " " + apellido);
        System.out.println("Telefono: " + telefono);
        System.out.println("Habilidades:");
        for (String habilidade : habilidades) {
            System.out.println(" - " + habilidade);
        }
    }
}
