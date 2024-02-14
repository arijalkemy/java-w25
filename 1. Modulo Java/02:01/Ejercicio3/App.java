import classes.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Producto producto1 = new Perecedero("CARNE", 2, 10);
        Producto producto2 = new NoPerecedero("Avena", 5, "Cereales");

        System.err.println(producto1);
        System.out.println("$" + producto1.calcular(10));

        System.err.println(producto2);
        System.out.println("$" + producto2.calcular(10));

        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        for (Producto producto : listaProductos) {
            System.out.println(producto.getNombre() + " Total: $" + producto.calcular(5));
        }

    }
}
