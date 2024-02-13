package dakar;

import java.util.Arrays;
import java.util.List;

public class Dakar {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = Arrays.asList(
                new Moto(100.00, 1000.00, 23.00, "KKX096"),
                new Auto(200.00, 1200.00, 35.00, "AD695HX")
        );

        Carrera dunas = new Carrera(3000.00, 12000.00, "Dunas", 3, vehiculos);
        System.out.println(dunas.obtenerGanador().toString());
    }
}
