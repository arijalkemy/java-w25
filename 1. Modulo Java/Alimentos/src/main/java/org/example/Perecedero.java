package org.example;

import lombok.Data;

@Data
public class Perecedero extends Producto{
    int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public double calcular(int cantidad){
        double total;
        total = this.getPrecio() * cantidad;
        if(diasPorCaducar == 1) {
            total = total / 4;
        } else if(diasPorCaducar == 2) {
            total = total / 3;
        } else if(diasPorCaducar == 3) {
            total = total / 2;
        }
        return total;
    }
}


