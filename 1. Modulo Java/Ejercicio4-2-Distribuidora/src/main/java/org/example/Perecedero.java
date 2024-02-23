package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double total = super.calcular(cantidadDeProductos);
        if (this.diasPorCaducar == 1){
            total /= 4;
        }
        if (this.diasPorCaducar == 2){
            total /= 3;
        }
        if (this.diasPorCaducar == 3) {
            total /= 2;
        }
        return total;
    }
}
