package Animales;


import Interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {

    public Vaca(String nombre){
        super(nombre);
    }

    @Override
    public void emitirSonido(){
        System.out.println("Muuu!");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba...");
    }

}
