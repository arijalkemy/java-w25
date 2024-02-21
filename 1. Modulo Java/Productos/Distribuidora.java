package Productos;

import java.util.ArrayList;

public class Distribuidora {
    
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Pollo", 15000, 2));
        productos.add(new Perecedero("Carne", 25000, 4));
        productos.add(new NoPerecedero("Atún en lata", 4000, "Enlatado"));
        productos.add(new NoPerecedero("Jabón", 5000, "de baño"));
        
        int contador = 1;

        for (Producto producto : productos) {
            System.out.println(contador+". Producto: " + producto.getNombre() + " Precio: " + producto.calcular(5));
            contador++;
        }


    }

}
