package org.clase01_02_24.poo_p2.ejercicio_2;

public class Perecedero extends Producto{
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        if (diasPorCaducar == 1) return precio/4;
        if (diasPorCaducar == 2) return precio/3;
        if (diasPorCaducar == 3) return precio/2;
        return precio;
    }
}
