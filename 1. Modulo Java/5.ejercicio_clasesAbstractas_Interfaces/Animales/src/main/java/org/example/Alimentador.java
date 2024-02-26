package org.example;

public class Alimentador {
    static void alimentarAnimal(Animal animal){
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }else if(animal instanceof Herbivoro){
            ((Herbivoro) animal).comerHierba();
        }
    }
}
