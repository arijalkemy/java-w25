package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendasList;
    private int identificador = 0;

    public GuardaRopa() {
        this.prendasList = new HashMap<>();
        this.identificador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        //El toc de david
        identificador ++;
        prendasList.put(identificador, listaDePrenda);
        return identificador;

    }

    public void mostrarPrendas(){
        prendasList.entrySet().forEach(System.out::println);
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendasList.get(numero);
    }
}
