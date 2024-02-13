package ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva;

public class Hotel extends Reserva {

    private String hotel;
    private String direccion;
    private double costoPorNoche;
    private int diasHospedaje;
    private String dni;

    public Hotel(String hotel, String direccion, double costoPorNoche, int diasHospedaje, String dni) {
        this.hotel = hotel;
        this.direccion = direccion;
        this.costoPorNoche = costoPorNoche;
        this.diasHospedaje = diasHospedaje;
        this.dni = dni;
    }

    @Override
    public double calcularTotal() {
        return (this.costoPorNoche * this.diasHospedaje);
    }
}
