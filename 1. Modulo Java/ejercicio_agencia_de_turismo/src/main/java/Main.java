import model.Cliente;
import model.Localizador;
import model.Paquete;
import model.Reserva;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente("123", "Juan Perez", 26);
        Localizador locCompleto = new Localizador(
                c,
                List.of(
                        new Reserva(Paquete.HOTEL, 100),
                        new Reserva(Paquete.TRANSPORTE, 20),
                        new Reserva(Paquete.COMIDA, 80),
                        new Reserva(Paquete.BOLETOS_VIAJE, 40)
                ));
        System.out.println("Precio del paquete completo: " + locCompleto.getPrecioTotal());

        Localizador locHotelBoleto = new Localizador(
                c,
                List.of(
                        new Reserva(Paquete.HOTEL, 100),
                        new Reserva(Paquete.HOTEL, 20),
                        new Reserva(Paquete.BOLETOS_VIAJE, 80),
                        new Reserva(Paquete.BOLETOS_VIAJE, 40)
                ));
        System.out.println("Precio de un paquete de 2 hoteles y/o 2 boletos: "
                + locHotelBoleto.getPrecioTotal());
        Localizador locBasico = new Localizador(
                c,
                List.of(
                        new Reserva(Paquete.HOTEL, 20)
                ));
        System.out.println("Precio de un paquete básico: " + locBasico.getPrecioTotal());

    }
}
