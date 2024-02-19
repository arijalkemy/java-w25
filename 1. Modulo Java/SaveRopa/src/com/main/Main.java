package com.main;

import com.main.ClasePrenda.GuardaRopa;
import com.main.ClasePrenda.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Prenda> listPrendas = List.of(new Prenda("vestido","Fashion","Unico"),
                new Prenda("chaqueta","Models","Temporada"));
        Map<Integer,List<Prenda>> mapPrendas = new HashMap<>();
        mapPrendas.put(1,listPrendas);

        GuardaRopa guardar = new GuardaRopa(mapPrendas);
        int numConsulta = guardar.guardarPrendas(listPrendas);
        List<Prenda> prendaConsulta = guardar.devolverPrendas(1);
        System.out.println("El numero de codigo es :"+numConsulta);
        System.out.println("Sus prendas son :"+ prendaConsulta);

    }
}
