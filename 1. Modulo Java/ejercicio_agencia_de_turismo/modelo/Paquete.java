package ejerciciosIntegradores.agenciaDeTurismo.modelo;

import ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Paquete {
    private List<Reserva> reservas;
    private String dni;

    public Paquete() {
    }

    public List<Reserva> getReservas () {
        return this.reservas;
    }

    public double calcularTotal () {
        return this.getReservas().stream().mapToDouble(Reserva::calcularTotal).sum();
    }

    public boolean seReservoHotel () {
        return !this.reservas.stream().filter(r -> r.getClass().equals(Hotel.class)).toList().isEmpty();
    }

    public boolean seReservoBoleto () {
        return !this.reservas.stream().filter(r -> r.getClass().equals(Boleto.class)).toList().isEmpty();
    }
    public boolean seReservoTransporte () {
        return !this.reservas.stream().filter(r -> r.getClass().equals(Transporte.class)).toList().isEmpty();
    }
    public boolean seReservoComida() {
        return !this.reservas.stream().filter(r -> r.getClass().equals(Comida.class)).toList().isEmpty();
    }

    public boolean esPaqueteCompleto (){
        return (this.seReservoComida() &&
                this.seReservoTransporte() &&
                this.seReservoBoleto() &&
                this.seReservoHotel());
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        String resultadoPaquete = "Paquete para DNI: " + this.getDni() + " \n";
        if(this.seReservoHotel()) resultadoPaquete += "Hotel: Adquirido \n";
        if(this.seReservoBoleto()) resultadoPaquete += "Boleto: Adquirido \n";
        if(this.seReservoTransporte()) resultadoPaquete += "Transporte: Adquirido \n";
        if(this.seReservoComida()) resultadoPaquete += "Comida: Adquirido \n";
        if(this.esPaqueteCompleto()) resultadoPaquete += "Es paquete completo";
        return resultadoPaquete;
    }
}
