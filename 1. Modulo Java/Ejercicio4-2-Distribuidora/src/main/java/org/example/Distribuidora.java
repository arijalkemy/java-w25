package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> listaProducto = new ArrayList<>();
        //Producto
        listaProducto.add(new Producto("Escoba", 5500));
        listaProducto.add(new Producto("Licuadora", 115000));
        listaProducto.add(new Producto("Panales", 15000));
        listaProducto.add(new Producto("Gel", 3400));
        listaProducto.add(new Producto("Desechables", 2100));
        //No Perecedero
        listaProducto.add(new NoPerecedero("Arvejas", 3400, "Enlatados"));
        listaProducto.add(new NoPerecedero("Atun", 8600, "Enlatados"));
        listaProducto.add(new NoPerecedero("Cheetos", 2200, "Paqueticos"));
        listaProducto.add(new NoPerecedero("Aceite", 12900, "Liquidos"));
        listaProducto.add(new NoPerecedero("Gaseosa", 8300, "Bebidas"));
        //Perecedero
        listaProducto.add(new Perecedero("Leche", 3500, 1));
        listaProducto.add(new Perecedero("Carne", 11500, 3));
        listaProducto.add(new Perecedero("Pollo", 9500, 2));
        listaProducto.add(new Perecedero("Fresas", 14700, 1));
        listaProducto.add(new Perecedero("Bananos", 7300, 2));

        double sumaProducto = 0;
        double sumaPerecedero = 0;
        double sumaNoPerecedero = 0;
        for (Producto producto : listaProducto){
            if (producto instanceof Perecedero){
                sumaPerecedero += producto.calcular(1);
            } else if (producto instanceof NoPerecedero) {
                sumaNoPerecedero += producto.calcular(1);
            } else if (producto instanceof Producto) {
                sumaProducto += producto.calcular(1);
            }
        }
        System.out.println("El valor total de los productos es: "+sumaProducto);
        System.out.println("El valor total de los perecederos es: "+sumaPerecedero);
        System.out.println("El valor total de los no perecederos es: "+sumaNoPerecedero);
    }
}