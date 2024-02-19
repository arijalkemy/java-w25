package com.main;

import java.util.List;

public class Curriculum implements IImprimible{
    private String nombrePersona;
    private String dni;
    private int edad;
    private List<String> habilidades;

    public Curriculum(String nombrePersona, String dni, int edad, List<String> habilidades) {
        this.nombrePersona = nombrePersona;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimirDocumeto() {
        System.out.println("--- Curriculum ---");
        System.out.println("Persona: "+nombrePersona);
        System.out.println("DNI: "+dni);
        System.out.println("Edad: "+edad);
        System.out.println("Habilidades: ");
        habilidades.stream().forEach(x-> System.out.println(x));
    }
}
