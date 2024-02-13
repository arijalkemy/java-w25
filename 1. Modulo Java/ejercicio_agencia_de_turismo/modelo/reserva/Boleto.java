package ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva;

public class Boleto extends Reserva {
    private String destino;
    private String origen;
    private double precio;
    private String dni;

    public Boleto(String destino, String origen, double precio, String dni) {
        this.destino = destino;
        this.origen = origen;
        this.precio = precio;
        this.dni = dni;
    }

    @Override
    public double calcularTotal() {
        return this.precio ;
    }
}
