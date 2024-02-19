package org.example.savetheropa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GuardaRopa {
    private final Map<Integer, ArrayList<Prenda>> prendas;
    private int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = -1;
    }

    public int getContador() {
        return contador;
    }

    public int guardarRopa(ArrayList<Prenda> prendas){
        this.contador++;
        this.prendas.put(contador,prendas);
        return contador;
    }

    public ArrayList<Prenda> devolverPrenda(int index){
        return this.prendas.get(index);
    }
    public void mostrarPrendas(){
        prendas.forEach((key, prendasGuardadas) -> {
            System.out.println("Index: #" + key + ". Prendas: ");
            prendasGuardadas.forEach(System.out::println);
        });
    }
}
