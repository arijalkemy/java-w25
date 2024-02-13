package org.example.ejercicio_2_documentos.documento;

import org.example.ejercicio_2_documentos.auxiliares.Persona;

import java.util.ArrayList;

public class Curriculum extends Documento {
    private Persona persona;

    public Curriculum(int cantPaginas, Persona persona) {
        super(cantPaginas);
        this.persona = persona;
    }

    public Curriculum() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void imprimir() {
        System.out.println("-------------------------");
        System.out.println("       Curriculum        ");
        System.out.println("-------------------------");
        System.out.println("Persona: " + persona.getNombreCompleto());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("DNI: " + persona.getDni());
        System.out.println();
        System.out.println("Habilidades: ");
        for (String habilidad : persona.getHabilidades()) {
            System.out.println(" - " + habilidad);
        }
        System.out.println("-------------------------");
    }
}

