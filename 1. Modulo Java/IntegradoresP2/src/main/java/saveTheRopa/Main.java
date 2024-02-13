package saveTheRopa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* Crear en la clase Main un escenario en el cual alguien guarde dos prendas,
         * reciba el código
         * y luego consulta por sus prendas guardadas.
         */
        List<Prenda> prendas = List.of(
                new Pantalon("Adidas", "Buzo xl"),
                new Calzado("Nike", "Zapatillas talle 10")
        );
        GuardaRopa guardaRopa = new GuardaRopa();

        int codigo = guardaRopa.guardarPrendas(prendas);

        System.out.println(guardaRopa.devolverPrendas(codigo));

    }
}