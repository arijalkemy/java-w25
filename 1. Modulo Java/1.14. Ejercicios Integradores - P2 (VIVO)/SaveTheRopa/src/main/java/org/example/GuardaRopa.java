package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario = new HashMap<>();
    private int contador = 0;

    public List<Prenda> devolverPrendas(Integer id) {
        return diccionario.get(id);
    }

    public void mostrarPrendas() {
        diccionario.forEach((id, prendas) -> {
            System.out.println("Identificador: " + id);
            prendas.forEach(System.out::println);
        });
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas) {
        diccionario.put(contador, listaPrendas);
        return contador++;
    }



}
