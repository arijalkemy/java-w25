import model.NoPerecedero;
import model.Perecedero;
import model.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

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

        double total = 0;

        for (Producto producto : productos){
            total += producto.calcular(1);
            System.out.println(producto.toString());
        }

        System.out.println("El precio total es de: " + total);
    }
}
