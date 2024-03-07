package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

/*Crear en la clase Main un escenario en el cual alguien guarde dos prendas,
 reciba el código y luego consulta por sus prendas guardadas.*/
        Scanner sc = new Scanner(System.in);

        GuardarRopa guardarRopa = new GuardarRopa();
        Prenda p1 = new Prenda();
        Prenda p2 = new Prenda();

        p1.setMarca("Levis");
        p1.setModelo("Remera ma1");

        p2.setMarca("Wrangler");
        p2.setModelo("Pantalon m2");

        List<Prenda> lPrendas = new ArrayList<>();
        lPrendas.add(p1);
        lPrendas.add(p2);
        int cod = guardarRopa.guardarPrendas(lPrendas);
        System.out.println("Codigo de Deposito: " + cod);

        guardarRopa.mostrarPrendas();
    }


}