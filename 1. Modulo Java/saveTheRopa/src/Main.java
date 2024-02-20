import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Nike", "Tenis");
        Prenda prenda2 = new Prenda("Adidas", "Tenis");
        GuardaRopa.guardarPrendas(new ArrayList<>(List.of(prenda1, prenda2)));
        GuardaRopa.mostrarPrendas();
        System.out.println(GuardaRopa.devolverPrendas(1));
    }
}