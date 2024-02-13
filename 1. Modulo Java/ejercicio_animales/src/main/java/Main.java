import model.Animal;
import model.Gato;
import model.Perro;
import model.Vaca;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        vaca.emitirSonido();
        gato.emitirSonido();
        perro.emitirSonido();

        comerAnimal(vaca);
        comerAnimal(perro);
        comerAnimal(gato);

    }
    public static void comerAnimal(Animal animal){
        animal.comer();
    }
}
