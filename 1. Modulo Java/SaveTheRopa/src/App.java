import java.util.Arrays;

import models.GuardaRopa;
import models.Prenda;

public class App {
    public static void main(String[] args) throws Exception {
        GuardaRopa gR = new GuardaRopa();

        gR.guardarPrendas(
            Arrays.asList(
                new Prenda("asd", "asd"),
                new Prenda("asdd", "aasd"),
                new Prenda("asddd", "aaasd"),
                new Prenda("asdddd", "aaaasd"),
                new Prenda("asddddd", "aaaaasd")));

        gR.guardarPrendas(
            Arrays.asList(
                new Prenda("asd", "asd"),
                new Prenda("asdd", "aasd"),
                new Prenda("asddd", "aaasd"),
                new Prenda("asdddd", "aaaasd"),
                new Prenda("asddddd", "aaaaasd")));

        gR.guardarPrendas(
            Arrays.asList(
                new Prenda("asd", "asd"),
                new Prenda("asdd", "aasd"),
                new Prenda("asddd", "aaasd"),
                new Prenda("asdddd", "aaaasd"),
                new Prenda("asddddd", "aaaaasd")));

        gR.mostrarPrendas();

        System.out.println(gR.devolverPrendas(2));

        gR.mostrarPrendas();
    }
}
