package org.example;

public class Distribuidora {
    public static void main(String[] args) {



        Producto a = new Producto("Queso",500);
        Producto b = new Perecedero("Arroz",1000,2);
        Producto c = new NoPerecedero("Dulce de leche",300,"Comida");

        Producto[] productos = {a, b, c};

        double precioTotal = 0;

        for (Producto producto : productos) {
            int cantidadAVender = 5;
            double precioProducto = producto.calcular(cantidadAVender);
            precioTotal += precioProducto;

            System.out.println("Vendiendo " + cantidadAVender + " unidades de " + producto.getNombre());
            System.out.println("Precio unitario: " + producto.getPrecio());
            System.out.println("Precio total: " + precioProducto);
            System.out.println("------------------------");
        }

        System.out.println("Precio total al vender 5 unidades de cada producto: " + precioTotal);



    }
}