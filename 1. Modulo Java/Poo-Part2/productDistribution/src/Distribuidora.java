import product.NoPerecedero;
import product.Perecedero;
import product.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Manzana", 2500, 1));
        productos.add(new NoPerecedero("Mesa", 250000, "Mueble"));
        productos.add(new Perecedero("Arroz", 5000, 10));
        productos.add(new NoPerecedero("Cuaderno", 6000, "Escolar"));
        productos.add(new Perecedero("Pasta", 3000, 2));
        productos.add(new NoPerecedero("Portatil", 250000, "Tecnologia"));

        for (Producto producto: productos){
            System.out.println("Precio de 5 items de " + producto.getNombre() + " en COP: $"+ producto.calcular(5));
        }

    }
}