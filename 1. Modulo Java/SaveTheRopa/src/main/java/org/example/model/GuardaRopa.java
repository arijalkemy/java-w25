package org.example.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int id;

    private Map<Integer, List<Prenda>> ropas;

    public GuardaRopa() {
        this.id = 0;
        ropas = new HashMap<>();
    }

    public void mostrarPrendas(){
        ropas.forEach((id, prendas) -> {
            System.out.println("Identificador: " + id);
            prendas.forEach(System.out::println);
        });
    }
    public Integer guardarPrendas(List<Prenda> prendas){
        this.id++;
        ropas.put(id,prendas);
        return id;
    }

    public List<Prenda> devolverPrendas(Integer id){
        return ropas.getOrDefault(id,null);
    }
}
