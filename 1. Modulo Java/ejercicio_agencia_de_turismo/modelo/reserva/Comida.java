package ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva;

public class Comida extends Reserva {
    private String comida;
    private double precio;
    private int porcionesPorDia;


    public Comida(String comida, double precio, int porcionesPorDia) {
        this.comida = comida;
        this.precio = precio;
        this.porcionesPorDia = porcionesPorDia;
    }

    @Override
    public double calcularTotal() {
        return this.porcionesPorDia * this.precio;
    }
}
