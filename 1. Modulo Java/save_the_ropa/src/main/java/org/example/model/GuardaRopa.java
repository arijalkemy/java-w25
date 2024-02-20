package org.example.model;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private int identificador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.identificador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        identificador++;
        prendas.put(identificador, listaDePrenda);
        return identificador;
    }

    public void mostrarPrendas(){
        System.out.println(prendas);
        prendas.forEach((key,valor)->{
            System.out.println("Identificador: " + key);
            valor.stream().forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero ) {
        return this.prendas.get(numero);
    }

}
