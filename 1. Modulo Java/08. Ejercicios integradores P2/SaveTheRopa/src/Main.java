import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Nike", "Remera");
        Prenda prenda2 = new Prenda("Adidas", "Zapatilla");
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);
        GuardaRopa guardaRopa = new GuardaRopa();
        int codigo = guardaRopa.guardarPrendas(prendas);
        guardaRopa.devolverPrendas(codigo).forEach(System.out::println);
    }
}