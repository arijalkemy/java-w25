package Animales;

import Interfaces.ICarnivoro;
import Interfaces.IHerviboro;

public abstract class Animal {

    protected String nombre;

    public Animal (String nombre){
        this.nombre = nombre;
    }
    public abstract void emitirSonido();

    public static <T> void comerAnimal(T animal){
        if(animal instanceof Gato){
            ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if(animal instanceof Vaca ) {
            ((Vaca) animal).comerHierba();
        } else System.out.println("La accion no es valida.");
    }

    public static void comerAnimal2(Animal animal){
        if(animal instanceof ICarnivoro){
            ((ICarnivoro) animal).comerCarne();
        } else if(animal instanceof IHerviboro) {
            ((IHerviboro) animal).comerHierba();
        } else System.out.println("La accion no es valida.");
    }
}
