package Productos;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Coca", 20, 5));
        productos.add(new NoPerecedero("Pan", 30, "HARINA"));
        productos.add(new Perecedero("Papas", 40, 1));
        productos.add(new NoPerecedero("Verdura", 10, "VERDURA"));
        productos.add(new NoPerecedero("Lata", 5, "ENLATADO"));
        productos.forEach(producto -> System.out.println("El producto " +producto.getNombre()+"tiene el precio de "+producto.calcular(5)));
    }
}
