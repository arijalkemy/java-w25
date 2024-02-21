package org.example;

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
    public String toString() {
        return super.toString() + " Dias por caducar: " + diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        // Obtiene el precio original de la clase base
        double original = super.calcular(cantidadDeProductos);

        // Aplica descuentos según el número de días para caducar
        switch (diasPorCaducar) {
            case 1:
                return original / 4;
            case 2:
                return original / 3;
            case 3:
                return original / 2;
            default:
                // Para 4 días o más, no hay descuento
                return original;
        }
    }

}

