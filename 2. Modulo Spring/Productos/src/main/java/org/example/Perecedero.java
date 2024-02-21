package org.example;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero() {
    }

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public double calcular(int cantidadProductos) {
        double calculo = super.calcular(cantidadProductos);
        if (diasPorCaducar == 1) {
            calculo = (calculo / 4);
        } else if (diasPorCaducar == 2) {
            calculo = (calculo / 3);
        }else if (diasPorCaducar == 3) {
            calculo = (calculo / 2);
        }
        return calculo;
    }

    @Override
    public String toString() {
        return super.toString() + "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
