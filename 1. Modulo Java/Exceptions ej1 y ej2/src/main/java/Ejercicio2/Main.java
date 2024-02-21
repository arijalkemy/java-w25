package Ejercicio2;

import java.util.ArrayList;

public class Main { //Distribuidora
    public static void main(String[] args){
        double precioTotal = 0;

        ArrayList<Producto> productos = new ArrayList<>();

        Producto producto1 = new Producto("Arroz", 300);
        Producto perecedero1 = new Perecedero("Leche", 300, 1);
        Producto perecedero2 = new Perecedero("Leche", 300, 2);
        Producto perecedero3 = new Perecedero("Leche", 300, 3);
        Producto noPerecedero = new NoPerecedero("Lentejas", 500, "Legumbres");

        productos.add(producto1);
        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(perecedero3);
        productos.add(noPerecedero);
        productos.add(new NoPerecedero("Frijoles", 500, "Legumbres"));

        for(Producto producto : productos ) {
            // System.out.println(producto.toString());
            System.out.println(producto.calcular((5)) + " " + producto.getNombre());
            precioTotal += producto.calcular(5);
        }

        System.out.println(precioTotal);
    }
}
