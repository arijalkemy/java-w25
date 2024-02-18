import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("DC", "Zapatillas");
        Prenda prenda2 = new Prenda("Nike", "Zapatillas");
        Prenda prenda3 = new Prenda("Levis", "Remera");
        Prenda prenda4 = new Prenda("Adidas", "Pantalon");

        int codigo1 = guardaRopa.guardarPrendas(Arrays.asList(prenda1, prenda2));
        int codigo2 = guardaRopa.guardarPrendas(Arrays.asList(prenda3, prenda4));

        System.out.println("\n----------------------------");
        System.out.println("Consultar por las prendas guardadas:");
        guardaRopa.mostrarPrendas();
    }
}
