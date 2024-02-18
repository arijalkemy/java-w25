import paquetes.PaqueteTuristico;
import productos.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    // Crear productos
        BoletoViaje boletoViaje = new BoletoViaje("Boleto de Viaje", 1234);
        Comida comida = new Comida("Comida", 544);
        Hotel hotel = new Hotel("Hotel", 685);
        Transporte transporte = new Transporte("Transporte", 6481);

        // Crear clientes
        Cliente clienteJuan = new Cliente("Juan Carlos", "12345678");

        // Crear paquetes
        PaqueteTuristico paqueteCompleto = new PaqueteTuristico(
            new ArrayList<Producto>(Arrays.asList(boletoViaje, comida, hotel, transporte)));
        PaqueteTuristico paqueteDobleHotel = new PaqueteTuristico(
            new ArrayList<Producto>(Arrays.asList(hotel, hotel)));


        // Crear repositorioReserva
        RepositorioReserva repositorioReserva = new RepositorioReserva();

        // Crear reservas y agregarlas al repositorio
        Reserva reserva1 = new Reserva(clienteJuan, paqueteCompleto, repositorioReserva);
        repositorioReserva.agregarReserva(reserva1);

        Reserva reserva2 = new Reserva(clienteJuan, paqueteCompleto, repositorioReserva);
        repositorioReserva.agregarReserva(reserva2);

        Reserva reserva3 = new Reserva(clienteJuan, paqueteCompleto, repositorioReserva);
        repositorioReserva.agregarReserva(reserva3);

        Reserva reserva4 = new Reserva(clienteJuan, paqueteDobleHotel, repositorioReserva);
        repositorioReserva.agregarReserva(reserva4);

        System.out.println("\n----------------------------");
        System.out.println("Primera reserva:");
        System.out.println(reserva1.getTotal());

        System.out.println("\n----------------------------");
        System.out.println("Segunda reserva:");
        System.out.println(reserva2.getTotal());

        System.out.println("\n----------------------------");
        System.out.println("Tercera reserva:");
        System.out.println(reserva3.getTotal());

        System.out.println("\n----------------------------");
        System.out.println("Reserva de 2 hoteles:");
        System.out.println(reserva4.getTotal());
    }
}
