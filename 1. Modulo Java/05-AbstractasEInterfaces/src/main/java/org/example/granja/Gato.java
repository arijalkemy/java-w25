package org.example.granja;

import org.example.granja.iterfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau Miau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println(this.getClass()+": nombre "+this.getNombre()+"Se comio a: "+animal.getNombre()+" : clase "+animal.getClass());
    }

}
