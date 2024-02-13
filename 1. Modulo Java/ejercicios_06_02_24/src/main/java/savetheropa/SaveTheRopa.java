package savetheropa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveTheRopa {
    public static void main(String[] args) {

        List<Prenda> prendas = Arrays.asList(
                new Prenda("Nike", "Tn"),
                new Prenda("Lacoste", "Polaroid"),
                new Prenda("Fila", "Disruptor"),
                new Prenda("New Balance", "550"),
                new Prenda("Adidas", "Superstar")
        );

        GuardaRopa gr = new GuardaRopa();
        Integer codigo = gr.guardarPrendas(prendas);
        System.out.println("------El código es: " + codigo + "------");

        System.out.println("------Mostrar prendas------");
        gr.mostrarPrendas();

        System.out.println("------Devolver prendas------");
        gr.devolverPrendas(0);

    }
}
