package org.example;

import org.example.savetheropa.GuardaRopa;
import org.example.savetheropa.Prenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Gucci","Camisa"));
        prendas.add(new Prenda("Nike","Zapatos"));

        Map<Integer,List<Prenda>> mapPrendas = new HashMap<>();
        mapPrendas.put(1,prendas);

        GuardaRopa guardaRopa = new GuardaRopa();
        int idguardado = guardaRopa.guardarRopaUsuario(prendas);
        int idguardado2 = guardaRopa.guardarRopaUsuario(prendas);
        guardaRopa.mostrarPrendas();

        System.out.println(idguardado2);

        System.out.println("reclamar prendas " + guardaRopa.devolverPrenda(idguardado));



    }
}