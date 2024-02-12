package agencia.reserva;

public class Reserva {

    private int idReserva;
    private String tipo;
    private double precio;

    public Reserva(int idReserva, String tipo, double precio) {
        this.idReserva = idReserva;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
