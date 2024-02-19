package com.main;

import com.main.Clases.Gato;
import com.main.Clases.Perro;
import com.main.Clases.Vaca;

public class Main {

    public static void main(String[] args) {
        Perro perro = new Perro("Pepe");
        Gato gato = new Gato("Reina");
        Vaca vaca = new Vaca("Lola");

        System.out.println(perro.emitirSonido());
        System.out.println(perro.comerCarne());
        System.out.println(gato.emitirSonido());
        System.out.println(gato.comerCarne());
        System.out.println(vaca.emitirSonido());
        System.out.println(vaca.comerHierba());

    }
}
