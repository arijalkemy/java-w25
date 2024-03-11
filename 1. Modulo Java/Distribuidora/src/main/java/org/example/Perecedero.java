package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero() {
    }

    public Perecedero(String nombre, Double precio) {
        super(nombre, precio);
    }

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
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

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double total = super.calcular(cantidadDeProductos);
        return switch (diasPorCaducar) {
            case 1 -> total / 4;
            case 2 -> total / 3;
            case 3 -> total / 2;
            default -> total;
        };
    }
}
