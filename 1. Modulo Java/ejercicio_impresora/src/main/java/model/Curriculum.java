package model;

import interfaces.Imprimible;

public class Curriculum implements Imprimible {
    private Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum...");
        System.out.println(persona.toString());
    }
}
