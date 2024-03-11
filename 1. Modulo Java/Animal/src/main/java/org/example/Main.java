package org.example;

import org.example.entities.Animal;
import org.example.entities.Gato;
import org.example.entities.Perro;
import org.example.entities.Vaca;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);

    }
    public static void comerAnimal(Animal animal){
        animal.comer();
    }
}