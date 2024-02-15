package com.company;

public class Vaca extends Animal implements Herviboro{
    @Override
    protected void emitirSonido() {
        System.out.println("Muuuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca comiendo hierba");
    }
}
