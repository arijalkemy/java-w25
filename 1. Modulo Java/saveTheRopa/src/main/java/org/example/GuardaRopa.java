package org.example;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private static Integer contador;
    private HashMap<Integer, List<Prenda>> container;
    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        this.container.put(contador,listaDePrendas).size();
        return ++contador;
    }
}
