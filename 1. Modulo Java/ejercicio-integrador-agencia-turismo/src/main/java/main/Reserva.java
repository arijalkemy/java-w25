package main;

public abstract class Reserva {

    private int cantidadReservas;
    private double valorTotal;

    public int getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public abstract double calcularValorTotal(int cantidadreservas);

    @Override
    public String toString() {
        return "Reserva{" +
                "cantidadReservas=" + cantidadReservas +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
