public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        System.out.println("\n----------------------------");
        System.out.println("Gato:");
        gato.emitirSonido();
        gato.comerCarne();

        System.out.println("\n----------------------------");
        System.out.println("Perro:");
        perro.emitirSonido();
        perro.comerCarne();

        System.out.println("\n----------------------------");
        System.out.println("Vaca:");
        vaca.emitirSonido();
        vaca.comerHierba();
    }
}
