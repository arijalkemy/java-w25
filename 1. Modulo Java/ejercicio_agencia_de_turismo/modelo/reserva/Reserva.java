package ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva;

public abstract class Reserva {
    private int descuento = 0;
    public abstract double calcularTotal ();

    public double calcularDescuento (){
        return  getDescuento() * calcularTotal();//this.descuento * this.calcularTotal() / 100;
    }

    public int getDescuento() {
        return this.descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
