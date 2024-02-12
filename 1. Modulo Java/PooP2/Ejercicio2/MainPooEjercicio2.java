package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class MainPooEjercicio2{

    public static void main(String[] args) {


        List<Product> productos = new ArrayList<>();

        productos.add(new NoPerecedero("Jabon", 50, "Perfumería"));
        productos.add(new NoPerecedero("Shampoo", 75, "Perfumería"));
        productos.add(new NoPerecedero("Acondicionador", 100, "Perfumería"));
        productos.add(new NoPerecedero("Lavandina", 100, "Perfumería"));
        productos.add(new NoPerecedero("Talco", 100, "Perfumería"));
        productos.add(new Perecedero("Fideos", 100, 3));
        productos.add(new Perecedero("Arroz", 100, 3));
        productos.add(new Perecedero("Carne", 100, 1));
        productos.add(new Perecedero("Pollo", 100, 1));
        productos.add(new Perecedero("Leche", 100, 2));

        for (Product producto : productos){
        
            System.out.println( " El monto es: " + producto.calcular(5));

        }


    }




}
