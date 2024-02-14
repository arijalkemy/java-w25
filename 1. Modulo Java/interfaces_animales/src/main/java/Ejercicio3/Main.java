package Ejercicio3;

public class Main {
    public static void main(String[] args) {


        Animal gato = new Gato();
        Animal perro = new Perro();
        Animal vaca = new Vaca();

        System.out.println("El gato hace: ");
        gato.emitirSonido();
        System.out.println("y come: ");
        gato.comerAnimal();
        System.out.println();

        System.out.println("El perro hace: ");
        perro.emitirSonido();
        System.out.println("y come: ");
        perro.comerAnimal();
        System.out.println();



        System.out.println("La vaca hace: ");
        vaca.emitirSonido();
        System.out.println("y come: ");
        vaca.comerAnimal();

    }


}