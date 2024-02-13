package org.example.models;

public class Perecedero extends Producto{
    public int diasPorCaducar;

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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioSinDescuento = super.precio*cantidadDeProductos;
        switch (diasPorCaducar){
            case 1:
                return precioSinDescuento/4;
            case 2:
                return precioSinDescuento/3;
            case 3:
                return precioSinDescuento/2;
            default:
                return precioSinDescuento;
        }
    }
}
