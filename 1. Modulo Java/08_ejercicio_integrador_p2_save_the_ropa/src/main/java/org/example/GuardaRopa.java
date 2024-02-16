package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private static int contador = 0;
    private static Map<Integer, List<Prenda>> guardaRopa = new HashMap<>();

    //p.3
    public int guardarPrendas(List<Prenda> listaDePrenda) {
        guardaRopa.put(++contador, listaDePrenda);
        return contador;
    }

    //p.5
    public static List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prenda = guardaRopa.remove(numero);
        return prenda;
    }

    //p.4
    public static void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : guardaRopa.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " Lista Ropa: " + entry.getValue());
        }
    }
}
