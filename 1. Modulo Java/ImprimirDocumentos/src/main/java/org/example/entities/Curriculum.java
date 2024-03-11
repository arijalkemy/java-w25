package org.example.entities;

import org.example.Interfaces.Imprimible;

public class Curriculum implements Imprimible {
    private Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }
    @Override
    public void imprimir() {
        System.out.println("Impresión de curriculum: ");
        System.out.println(persona.toString());
    }
}
