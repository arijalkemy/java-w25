package org.clase02_02_24.primera_parte.ejercicio_3;

public class Vaca extends Animal implements Hervíboro{
    String nombre;
    @Override
    void emitirSonido() {
        System.out.println("Muuuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierbas");
    }

    public void algo(){
        System.out.println("algo");
    }

    public Vaca(String nombre) {
        this.nombre = nombre;
    }
}
