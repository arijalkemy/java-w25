package ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva;

public class Transporte extends Reserva {
    private String tipo;
    private String destino;
    private String origen;
    private double precio;

    public Transporte(String tipo, String destino, String origen, double precio) {
        this.tipo = tipo;
        this.destino = destino;
        this.origen = origen;
        this.precio = precio;
    }

    @Override
    public double calcularTotal() {
        return this.precio;
    }



}
