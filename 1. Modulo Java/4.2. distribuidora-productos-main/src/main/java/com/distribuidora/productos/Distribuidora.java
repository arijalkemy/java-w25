package com.distribuidora.productos;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    private List<Producto> productosVendidos = new ArrayList<Producto>();
    
    public void venderProducto(Producto producto) {
        this.productosVendidos.add(producto);
    }

    public double precioTotal() {
        double precioTotal = 0.0;
        for (Producto producto : this.productosVendidos) {
            precioTotal += producto.precioTotal;
        }
        return precioTotal;
    }

    public static void main(String[] args) {
        // Productos perecederos
        Producto perecedero1 = new Perecedero("Pan tajado", 4000, 4);
        Producto perecedero2 = new Perecedero("Jamón", 9000, 10);
        Producto perecedero3 = new Perecedero("Durazno", 2000, 1);
        Producto perecedero4 = new Perecedero("Alitas BBQ", 15000, 3);
        Producto perecedero5 = new Perecedero("Queso doble crema", 11000, 2);
        perecedero1.calcular(1);
        perecedero2.calcular(2);
        perecedero3.calcular(3);
        perecedero4.calcular(4);
        perecedero5.calcular(5);

        Producto noPerecedero1 = new NoPerecedero("Atún enlatado", 10000, "Alimento enlatado");
        Producto noPerecedero2 = new NoPerecedero("Salchicas enlatadas", 9000, "Alimento enlatado");
        Producto noPerecedero3 = new NoPerecedero("Frutos secos", 15000, "Alimento deshidatrado");
        Producto noPerecedero4 = new NoPerecedero("Té negro", 5600, "Infusión");
        Producto noPerecedero5 = new NoPerecedero("Yerba mate", 19000, "Infusión");
        noPerecedero1.calcular(1);
        noPerecedero2.calcular(2);
        noPerecedero3.calcular(3);
        noPerecedero4.calcular(4);
        noPerecedero5.calcular(5);

        Distribuidora distribuidora = new Distribuidora();
        distribuidora.venderProducto(perecedero1);
        distribuidora.venderProducto(perecedero2);
        distribuidora.venderProducto(perecedero3);
        distribuidora.venderProducto(perecedero4);
        distribuidora.venderProducto(perecedero5);
        
        distribuidora.venderProducto(noPerecedero1);
        distribuidora.venderProducto(noPerecedero2);
        distribuidora.venderProducto(noPerecedero3);
        distribuidora.venderProducto(noPerecedero4);
        distribuidora.venderProducto(noPerecedero5);

        System.out.println(distribuidora.precioTotal());
    }
}
