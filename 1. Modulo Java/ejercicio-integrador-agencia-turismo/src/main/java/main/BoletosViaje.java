package main;

public class BoletosViaje extends Reserva{

    private int cantidadReservas;
    private double valorTotal;

    @Override
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BoletosViaje(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
        this.valorTotal = calcularValorTotal(cantidadReservas);
    }

    @Override
    public double calcularValorTotal(int cantidadReservas) {
        setCantidadReservas(cantidadReservas);
        if(cantidadReservas > 1){
            return ((200*cantidadReservas)*0.95);
        }
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
        return "BoletosViaje{" +
                "cantidadReservas=" + cantidadReservas +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
