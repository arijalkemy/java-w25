package org.clase02_02_24.primera_parte.ejercicio_3;

public class Perro extends Animal implements Carnivoro
{
    @Override
    void emitirSonido() {
        System.out.println("Guauuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne");
    }
}
