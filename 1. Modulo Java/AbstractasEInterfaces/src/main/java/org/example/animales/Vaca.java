package org.example.animales;

public class Vaca extends Animal implements Hervivoro{

    @Override
    public String emitirSonido() {
        return "muuu";
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");;
    }
}
