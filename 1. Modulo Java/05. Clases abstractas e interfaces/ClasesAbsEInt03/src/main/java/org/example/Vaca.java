package org.example;

public class Vaca extends Animal implements IHerviboro{

    @Override
    public void emitirSonido() {
        System.out.println("muu");
    }

    @Override
    public void comer() {
        comerHierba();
    }
    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca comiendo hierba");
    }
}
