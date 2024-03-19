package main;

public class Transporte extends Reserva{

    private int cantidadReservas;
    private double valorTotal;

    public Transporte(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
        this.valorTotal = calcularValorTotal(cantidadReservas);
    }

    @Override
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public double calcularValorTotal(int cantidadReservas) {
        setCantidadReservas(cantidadReservas);
        return 200*cantidadReservas;

    }

    public int getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "cantidadReservas=" + cantidadReservas +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
