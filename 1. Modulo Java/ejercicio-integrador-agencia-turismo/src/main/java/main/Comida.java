package main;

public class Comida extends Reserva{

    private int cantidadReservas;
    private double valorTotal;

    @Override
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Comida(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
        this.valorTotal = calcularValorTotal(cantidadReservas);
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
        return "Comida{" +
                "cantidadReservas=" + cantidadReservas +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
