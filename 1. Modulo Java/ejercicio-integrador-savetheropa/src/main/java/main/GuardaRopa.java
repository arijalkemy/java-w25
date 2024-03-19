package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private final Map<Integer, ArrayList<Prenda>> listaPrendas;

    private int contador;

    public Map<Integer, ArrayList<Prenda>> getListaPrendas() {
        return listaPrendas;
    }

    public GuardaRopa() {
        this.listaPrendas = new HashMap<>();
        this.contador = -1;
    }

    public Integer guardaPrendas (ArrayList<Prenda> prendas){
        this.contador = this.contador + 1;
        this.listaPrendas.put(this.contador, prendas);
        return this.contador;
    }

    public void mostrarPrendas(){
        listaPrendas.forEach((index, prendaList) -> {
            System.out.println("id: " + index + "\nPrendas: " );
            prendaList.forEach(System.out::println);
        });
    }

    public ArrayList<Prenda> devolverPrenda(int index){
        return this.listaPrendas.get(index);
    }
}
