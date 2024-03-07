package org.example;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private int index;

    private HashMap<Integer, List<Prenda>> prendas;

    private static GuardaRopa instance;


    private GuardaRopa() {
        this.index = 0;
        this.prendas = new HashMap<>();
    }

    public static GuardaRopa getInstance(){
        if(instance == null){
            instance = new GuardaRopa();

        }
        return instance;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(++this.index,listaDePrenda);
        return this.index;

    }

    public void mostrarPrendas(){
        if(prendas.isEmpty()){
            System.out.println("El guardaropas esta vacio");
        }else{

            this.prendas.forEach((index,data) -> {
                System.out.println(String.format("Key: %d Prendas: %s",index,String.join("-",data.toString())));
            });


            }

        }




    public HashMap<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(HashMap<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public List<Prenda>devolverPrendas(Integer numero){
        return this.prendas.get(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "index=" + index +
                ", prendas=" + prendas +
                '}';
    }
}
