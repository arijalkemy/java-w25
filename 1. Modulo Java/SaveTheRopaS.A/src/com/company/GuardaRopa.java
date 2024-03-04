package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private int counter;
    public GuardaRopa(){
        this.counter = 1;
        diccionario = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        diccionario.put(counter, listaDePrendas);
        return counter ++;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println("Número identificador: " + entry.getKey());
            System.out.println("Prendas:");
            for (Prenda prenda : entry.getValue()) {
                System.out.println("Marca: " + prenda.getMarca()+ ", Modelo: " + prenda.getModelo());
            }
            System.out.println();
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.get(numero);
    }
}
