package com.main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Producto> productosList = new ArrayList<>();
        productosList.add(new Pedecedero("banano",1000,2));
        productosList.add(new Pedecedero("manzana",1300,3));
        productosList.add(new Pedecedero("pera",900,2));
        productosList.add(new Pedecedero("uvas",2000,3));
        productosList.add(new Pedecedero("tomate",800,1));
        productosList.add(new NoPedecedero("atun",2500,"no pedecedero"));
        productosList.add(new NoPedecedero("arroz",15000,"no pedecedero"));
        productosList.add(new NoPedecedero("harina",8000,"no pedecedero"));
        productosList.add(new NoPedecedero("aceite",20000,"no pedecedero"));
        productosList.add(new NoPedecedero("sal",5000,"no pedecedero"));
        productosList.add(new NoPedecedero("spagueti",3500,"no pedecedero"));
        productosList.add(new NoPedecedero("huevos",4000,"no pedecedero"));

        for( Producto producto: productosList){
            double calculoPrecio= producto.calcular(5);
            System.out.println("Nombre "+producto.getNombre()+" Cantidad: "+5+ " Precio Total: "+ calculoPrecio);
        }
    }
}
