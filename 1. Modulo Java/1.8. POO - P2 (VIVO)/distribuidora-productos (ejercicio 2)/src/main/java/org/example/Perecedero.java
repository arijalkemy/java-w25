package org.example;

public class Perecedero extends Producto
{
    private int diasParaCaducar;

    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }

    public void setDiasParaCaducar(int diasParaCaducar) {
        this.diasParaCaducar = diasParaCaducar;
    }

    public Perecedero(String nombre, double precio, int diasParaCaducar) {
        super(nombre, precio);
        this.diasParaCaducar = diasParaCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                super.toString() +
                "diasParaCaducar=" + diasParaCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioTotal = super.calcular(cantidadDeProductos);
        switch (diasParaCaducar) {
            case 1 -> precioTotal /= 4;
            case 2 -> precioTotal /= 3;
            case 3 -> precioTotal /= 2;
        }
        return precioTotal;
    }
}
