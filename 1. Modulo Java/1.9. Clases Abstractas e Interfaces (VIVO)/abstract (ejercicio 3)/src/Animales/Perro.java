package Animales;

import Interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    public Perro(String nombre){
        super(nombre);
    }

    @Override
    public void emitirSonido(){
        System.out.println("Guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }


}
