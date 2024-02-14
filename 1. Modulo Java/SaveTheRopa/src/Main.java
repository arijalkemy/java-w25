import Model.GuardaRopa;
import Model.Prenda;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            List<Prenda> prendasAGuardar = Arrays.asList(
                    new Prenda("Adidas","runnner"),
                    new Prenda("Puma", "Pantalon")
            );

            GuardaRopa guardaRopa = new GuardaRopa();

            guardaRopa.guardarPrendas(prendasAGuardar);

            List<Prenda> ropasGuardadas = guardaRopa.devolverPrendas(1);
            ropasGuardadas
                    .forEach(prenda -> System.out.println(prenda.toString()));

            guardaRopa.mostrarPrendas();
    }
}
