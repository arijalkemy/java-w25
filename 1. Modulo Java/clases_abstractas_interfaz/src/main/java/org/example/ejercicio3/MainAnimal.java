package org.example.ejercicio3;

public class MainAnimal {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        System.out.println("-------Gato------");
        gato.emitirSonido();
        gato.comeCarne();
        gato.comerAnimal(perro);

        System.out.println("-------Perro------");
        perro.emitirSonido();
        perro.comeCarne();
        perro.comerAnimal(gato);

        System.out.println("-------Vaca--------");
        vaca.emitirSonido();
        vaca.comeHierba();
    }
}