package com.main.Clases;

import com.main.Clases.Animal;
import com.main.IHerviboro;

public class Vaca extends Animal implements IHerviboro {
    private String nombre;

    public Vaca(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String emitirSonido() {
        return "muuu";
    }

    @Override
    public String comerHierba() {
        return nombre + " come hierba.";
    }
}
