import Animales.*;

public class Main {
    public static void main(String[] args) {
        Animal gato1 = new Gato("Gatito");
        Animal perro1 = new Perro("Perrito");
        Animal vaca1 = new Vaca("Vaquita");

        gato1.emitirSonido();
        perro1.emitirSonido();
        vaca1.emitirSonido();

        Animal.comerAnimal(gato1);
        Animal.comerAnimal(perro1);
        Animal.comerAnimal(vaca1);

        Animal.comerAnimal2(gato1);
        Animal.comerAnimal2(perro1);
        Animal.comerAnimal2(vaca1);
    }
}