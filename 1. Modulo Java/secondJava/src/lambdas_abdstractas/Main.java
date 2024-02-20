package lambdas_abdstractas;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.makeSound();
        perro.comerCarne();
        perro.comerCarne();

        Gato gato = new Gato();
        gato.makeSound();
        gato.comerCarne();

        Vaca vaca = new Vaca();
        vaca.makeSound();
        vaca.comerHierba();

        perro.comerAnimal(perro);
        perro.comerCarne();
    }
}
