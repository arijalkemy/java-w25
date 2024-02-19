package com.distribuidora.productos;

import com.distribuidora.productos.*;
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
        return "Perecedero [diasPorCaducar=" + diasPorCaducar + "]";
    }

    @Override
    public void calcular(int cantidad) {
        super.calcular(cantidad);
        switch (this.diasPorCaducar) {
            case 1:
                this.precioTotal /= 4;
                break;
            case 2:
                this.precioTotal /= 3;
                break;
            case 3:
                this.precioTotal /= 2;
                break;
        }
    }
}
