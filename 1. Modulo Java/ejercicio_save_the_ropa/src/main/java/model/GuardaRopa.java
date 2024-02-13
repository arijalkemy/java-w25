package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private int identificador = 0;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.identificador = 0;
    }
    public Integer guardarPrendas (List<Prenda> listaDePrendas) {
        identificador++;
        this.prendas.put(identificador, listaDePrendas);
        return identificador;
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }
    public void mostrarPrendas(){
        prendas.entrySet().forEach(System.out::println);
    }
}
