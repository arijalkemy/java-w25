package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer id;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.id = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        id++;
        prendas.put(id,listaDePrenda);
        return id;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()){
            System.out.println(entry.getKey().toString() + ": " + entry.getValue().toString());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        if(prendas.containsKey(numero)) return prendas.get(numero);
        else System.out.println("Este id no esta registrado");

        return new ArrayList<>();
    }
}
