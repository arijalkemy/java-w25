package com.main.Clases;

import com.main.Clases.Animal;
import com.main.ICornivoro;

public class Perro extends Animal implements ICornivoro {
    private String nombre;

    public Perro(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String emitirSonido() {
        return "guau";
    }

    @Override
    public String comerCarne() {
        return nombre + " come carne.";
    }
}
