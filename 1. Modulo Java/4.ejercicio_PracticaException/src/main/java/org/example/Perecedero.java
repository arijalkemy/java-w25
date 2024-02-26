package org.example;

public class Perecedero extends Producto {
    private int diasParaCaducar;

    public Perecedero(String nombre, double precio, int diasParaCaducar) {
        super(nombre, precio);
        this.diasParaCaducar = diasParaCaducar;
    }

    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }

    public void setDiasParaCaducar(int diasParaCaducar) {
        this.diasParaCaducar = diasParaCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio = super.calcular(cantidadDeProductos);
        switch (diasParaCaducar) {
            case 1: return precio / 4;
            case 2: return precio / 3;
            case 3: return precio / 2;
            default: return precio;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Días para caducar: " + diasParaCaducar;
    }
}
