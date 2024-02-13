package Ejercicio3;

public class Gato extends Animal implements ICarnivora{

    @Override
    public void emitirSonido() {
        System.out.println("Meow meow ");
    }

    @Override
    public void comerCarne(){
        System.out.println("Que rica carne");
    }


    @Override

    public void comerAnimal(){
        comerCarne();
    }

}
