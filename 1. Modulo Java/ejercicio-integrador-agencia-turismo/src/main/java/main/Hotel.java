package main;

public class Hotel extends Reserva{ ;
    private int cantidadReservas;
    private double valorTotal;

    public Hotel(int cantidadReservas) {
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
        return "Hotel{" +
                "cantidadReservas=" + cantidadReservas +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
