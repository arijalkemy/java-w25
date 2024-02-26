package org.example;

public class Vaca extends Animal implements IHerbivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public String comerHierba() {
        return "Este animal come hierba";
    }
}
