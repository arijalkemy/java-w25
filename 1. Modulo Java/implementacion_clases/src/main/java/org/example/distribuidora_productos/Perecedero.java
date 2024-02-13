package org.example.distribuidora_productos;

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
    public String toString() {
        return super.toString()
                + "\nDÍAS POR CADUCAR: " + this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        if (diasPorCaducar == 3) {
            return (super.getPrecio() / 2) * cantidadDeProductos;
        } else if (diasPorCaducar == 2) {
            return (super.getPrecio() / 3) * cantidadDeProductos;
        } else if (diasPorCaducar == 1) {
            return (super.getPrecio() / 4) * cantidadDeProductos;
        }
        return super.getPrecio() * cantidadDeProductos;
    }
}
