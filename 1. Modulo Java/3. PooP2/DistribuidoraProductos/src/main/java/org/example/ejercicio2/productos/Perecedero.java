package org.example.ejercicio2.productos;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double calculoProducto =  super.calcular(cantidadDeProductos);
        double ans = calculoProducto;
        switch (this.diasPorCaducar){
            case 1 -> ans *= (1.0 - 1.0/4.0);
            case 2 -> ans *= (1.0 - 1.0/3.0);
            case 3 -> ans *= (1.0/2.0);
        }
        return ans;
    }
}
