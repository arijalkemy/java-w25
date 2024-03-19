package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaqueteTuristico {

    List<Reserva> reserva;

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> paqueteCompleto(){
        reserva = new ArrayList<>();
        int cantidad = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Indique la cantidad de reservas por Hotel que desea:");
        cantidad = keyboard.nextInt();
        if(cantidad > 0){
            reserva.add(new Hotel(cantidad));
        }
        System.out.println("Indique la cantidad de reservas por Comida que desea:");
        cantidad = keyboard.nextInt();
        if(cantidad > 0){
            reserva.add(new Comida(cantidad));
        }
        System.out.println("Indique la cantidad de reservas por Transporte que desea:");
        cantidad = keyboard.nextInt();
        if(cantidad > 0){
            reserva.add(new Transporte(cantidad));
        }
        System.out.println("Indique la cantidad de reservas por Boletos de viaje que desea:");
        cantidad = keyboard.nextInt();
        if(cantidad > 0){
            reserva.add( new BoletosViaje(cantidad));
        }
        return reserva;
    }

    public double totalValor(){
        return reserva.stream().mapToDouble(Reserva::getValorTotal).sum();
    }

}
