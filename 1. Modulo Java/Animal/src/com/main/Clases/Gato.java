package com.main.Clases;

import com.main.Clases.Animal;
import com.main.ICornivoro;

public class Gato extends Animal implements ICornivoro {
    private String nombre;

    public Gato(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String emitirSonido() {
        return "miau";
    }

    @Override
    public String comerCarne() {
        return nombre + " come carne.";
    }
}
