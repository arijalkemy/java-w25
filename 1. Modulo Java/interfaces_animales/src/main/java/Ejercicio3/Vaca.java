package Ejercicio3;

public class Vaca extends Animal implements IHervibora{

    @Override
    public void emitirSonido(){
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca alimentada");
    }

    @Override
    public void comerAnimal(){
        comerHierba();
    }



}
