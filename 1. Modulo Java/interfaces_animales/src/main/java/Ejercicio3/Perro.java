package Ejercicio3;

public class Perro extends Animal implements ICarnivora{

    @Override
    public void emitirSonido(){
        System.out.println("Guau");
    }

    @Override
    public void comerAnimal() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro come carne");
    }


}
