package models;

public class Reserva {

    private int id;
    private TipoReserva tipo;
    private double price;

    private int cantidad;

    public Reserva(int id, TipoReserva tipo, double price) {
        this.id = id;
        this.tipo = tipo;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
