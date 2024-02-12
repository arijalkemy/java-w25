package Solucion2;

public class Reserva {
    String tipo;
    double precio;

    public Reserva(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
}
