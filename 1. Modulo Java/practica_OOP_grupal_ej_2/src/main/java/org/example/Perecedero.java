package org.example;

public class Perecedero extends Producto {

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
        double valorOriginal = super.calcular(cantidadDeProductos);
        switch (diasPorCaducar){
            case 1: return valorOriginal / 4;
            case 2: return valorOriginal / 3;
            case 3: return valorOriginal / 2;
            default: return valorOriginal;
        }
    }
}
