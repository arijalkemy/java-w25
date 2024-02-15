/*
Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos, imprimir
el precio total al vender 5 productos de cada tipo. Crear los elementos del array con los datos que quieras.
*/

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        Producto producto1 = new Producto("Arroz",4);
        Producto producto2 = new Perecedero("Pescado",20,2);
        Producto producto3 = new NoPerecedero("Televisor",500,"Electrodomestico");
        Producto producto4 = new NoPerecedero("Coca-Cola", 1.00, "Bebida");
        Producto producto5=  new NoPerecedero("Papas Fritas", 1.00, "Comida");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        double precioTotal = 0;
        for(Producto producto : productos) {
            precioTotal += producto.calcular(5);
            System.out.println("El precio total al vender 5 productos de cada tipo es: " + precioTotal);

        }
    }
}
