package Ejercicio3.classes;

import Ejercicio3.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba.");
    }
}
