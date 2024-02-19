import model.GuardaRopa;
import model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa armario = new GuardaRopa();

        Prenda prenda1 = new Prenda(
                "Versace",
                "Camisa"
        ), prenda2 = new Prenda(
                "Arturo Calle",
                "Pantalon"
        );

        List<Prenda> prendas = new ArrayList<>(List.of(prenda1, prenda2));

        armario.guardarPrendas(prendas);

        armario.mostrarPrendas();

        System.out.println(armario.devolverPrendas(1));



    }
}