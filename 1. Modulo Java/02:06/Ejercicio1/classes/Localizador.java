package com.example.classes;

public class Localizador {
    private static int contador = 0;
    private int id;
    private boolean comida;
    private int cantidadBoletos;
    private int cantidadReservas;
    private double total;

    public Localizador(boolean comida, int cantidadBoletos, int cantidadReservas, double total) {
        this.id = ++Localizador.contador;
        this.comida = comida;
        this.cantidadBoletos = cantidadBoletos;
        this.cantidadReservas = cantidadReservas;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public int getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador [id=" + id + ", comida=" + comida + ", cantidadBoletos=" + cantidadBoletos
                + ", cantidadReservas=" + cantidadReservas + "]";
    }

}
