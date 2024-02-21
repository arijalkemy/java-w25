package Ejercicio_Vehiculos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> lista = new ArrayList<>();

        lista.stream().findFirst().filter(v -> v.getMarca().equalsIgnoreCase(new Scanner(System.in).next())).get().getCosto();
    }
}
