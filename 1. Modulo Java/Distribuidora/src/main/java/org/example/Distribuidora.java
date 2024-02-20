package src.main.java.org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Distribuidora {
    List<Producto> productos = new ArrayList<>();

    public void imprimir(){

        productos.add(new Perecedero("Leche",3000,2));
        productos.add(new NoPerecedero("Arroz",5000,"Granos"));
        productos.add(new Perecedero("Carne",10000,3));
        productos.add(new Perecedero("Verduras",8500,1));
        productos.add(new NoPerecedero("Atun",7000,"Enlatados"));

        double precioTotal = 0;
        for (Producto producto : productos){
                precioTotal = precioTotal + producto.calcular(3);
        }
        System.out.println("Precio total: $" + precioTotal);
    }
}
