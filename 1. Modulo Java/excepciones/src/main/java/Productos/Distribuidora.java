package Productos;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args){
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Manzana ", 100, 5));
        productos.add(new NoPerecedero("Arroz ", 500, "HARINA"));
        productos.add(new Perecedero("Fruta ", 80, 1));
        productos.add(new NoPerecedero("Verdura ", 10, "VERDURA"));
        productos.add(new NoPerecedero("Atun en lata ", 70, "ENLATADO"));
        productos.forEach(producto -> System.out.println("El producto " +producto.getNombre()+"tiene el precio de "+producto.calcular(5)));
    }
}
