package org.example;

import org.example.model.Gato;
import org.example.model.Perro;
import org.example.model.Vaca;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();
    }
}