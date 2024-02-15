package org.example.savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int id;

    private Map<Integer, List<Prenda>> mapPrenda;


    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : mapPrenda.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }


    public List<Prenda> devolverPrenda(Integer id){

        return this.mapPrenda.get(id);

    }


    public GuardaRopa() {
        this.id = 0;
        this.mapPrenda = new HashMap<>();
    }


    public Integer guardarRopaUsuario(List<Prenda> prendas){
        this.mapPrenda.put(this.id,prendas);
        int idGuardado = this.id;
        this.id++;
        return idGuardado;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, List<Prenda>> getMapPrenda() {
        return mapPrenda;
    }

    public void setMapPrenda(Map<Integer, List<Prenda>> mapPrenda) {
        this.mapPrenda = mapPrenda;
    }
}
