package org.example;

import java.util.ArrayList;

public class Curriculum extends Documento{
    private String nombre;
    private String apellido;
    private String email;
    private String profesion;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String email, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.profesion = profesion;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("email: "+email);
        System.out.println("Profesión: "+profesion);
        for (String habilidad : habilidades){
            System.out.println("Habilidades: "+habilidad);
        }
    }
}
