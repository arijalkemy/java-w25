package meliboot;

public class Main {
    public static void main(String[] args) {
        IHerviboro vaca = new Vaca();
        ICarnivoro perro = new Perro();
        ICarnivoro gato = new Gato();


        vaca.comerHierva();
        perro.comerCarne();
        gato.comerCarne();
        Animal perroLobo = (Animal) perro;
        perroLobo.emitirSonido();
        gato.comerAnimal(perroLobo);
    }
}