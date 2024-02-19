package com.main.ClasePrenda;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GuardaRopa {
    Map<Integer, List<Prenda>> prendas;

    public GuardaRopa(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        int numero = this.prendas.entrySet().stream().
                filter( prenda -> prenda.getValue().equals(listaDePrenda))
                .map(Map.Entry::getKey).findFirst().orElse(0);
        return numero;
    }
    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> listPrenda= this.prendas.entrySet().stream()
                .filter( cod -> cod.getKey().equals(numero)).map(Map.Entry::getValue)
                .findFirst().orElse(null);
        return listPrenda;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "prendas=" + prendas +
                '}';
    }
}
