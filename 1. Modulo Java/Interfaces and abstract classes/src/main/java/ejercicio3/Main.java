package ejercicio3;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();
        System.out.println("*** PERRO ***");
        perro.emitirSonido();
        perro.comerAnimal();

        System.out.println("*** GATO ***");
        gato.emitirSonido();
        gato.comerAnimal();

        System.out.println("*** VACA ***");
        vaca.emitirSonido();
        vaca.comerAnimal();

    }
}



