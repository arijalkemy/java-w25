package org.example;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private int id = 0;
    private HashMap<Integer, List<Prenda>> armario = new HashMap<>();

    public GuardaRopa(HashMap<Integer, List<Prenda>> armario) {
        this.armario = armario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, List<Prenda>> getArmario() {
        return armario;
    }

    public GuardaRopa() {
    }

    public void setArmario(HashMap<Integer, List<Prenda>> armario) {
        this.armario = armario;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "id=" + id +
                ", armario=" + armario +
                '}';
    }

    public int guardarPrenda(List<Prenda> listaDePrenda){
        int idActual = id;
        armario.put(idActual, listaDePrenda);
        setId(idActual + 1);
        return idActual;
    }

    public void mostrarPrendas(){
        System.out.println(armario.toString());
    }

    public List<Prenda> devolverPrenda(int numero){
        return armario.get(numero);
    }
}
