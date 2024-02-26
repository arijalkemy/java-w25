package org.example;

public class Curriculum implements Imprimible{
    String persona;
    String habilidades;

    public Curriculum(String persona, String habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum de : " + persona);
        System.out.println("Habilidades : " + habilidades);
    }
}
