package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        List<Producto> nombreProductos = new ArrayList<>();
        nombreProductos.add(new Perecedero("banano", 200.0, 2));
        nombreProductos.add (new NoPerecedero("atun", 3000.0, "no peceredero"));
        nombreProductos.add(new Perecedero("manzana", 500.0, 1));
        nombreProductos.add (new NoPerecedero("arroz", 2000.0, "no peceredero"));
        nombreProductos.add(new Perecedero("papaya", 400.0, 3));



        for(Producto producto: nombreProductos){
            double sumaTotal = producto.calcular(5);
            System.out.println("precio Total = $" +sumaTotal + " del producto: " +producto.getNombre());
            System.out.println((Producto) producto);
        }


    }
}