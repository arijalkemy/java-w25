package org.example;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        System.out.println("Que sonidos emiten: ");
        vaca.emitirSonido();
        perro.emitirSonido();
        gato.emitirSonido();
        System.out.println("----------------------");

        System.out.println("La comida que comen: ");
        System.out.println(perro.comerCarne());
        System.out.println(gato.comerCarne());
        System.out.println(vaca.comerHierba());
        System.out.println("----------------------");

        System.out.println("Según animal comen: ");
        String animal1 = comerAnimal(vaca);
        String animal2 = comerAnimal(perro);
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println("----------------------");
    }
    public static String comerAnimal(Animal animal) {
        if (animal instanceof Gato){
            return ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            return ((Perro) animal).comerCarne();
        } else {
            return ((Vaca) animal).comerHierba();
        }
    }
}