package org.example.clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> diccionario = new HashMap<>();
    private Integer contador = 0;

    public GuardaRopa(Map<Integer, List<Prenda>> diccionario, Integer contador) {
        this.diccionario = diccionario;
        this.contador = contador;
    }

    public GuardaRopa() {

    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        Integer clave = contador;
        diccionario.put(clave,listaDePrenda);
        contador++;
        return clave;
    }
    public void mostrarPrendas(){
        for (Integer clave: diccionario.keySet()){
            List<Prenda> listaDePrenda = diccionario.get(clave);
            System.out.println(listaDePrenda);

        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> devolverPrenda = diccionario.remove(numero);
        return devolverPrenda;
    }
}
