package ejerciciosIntegradores.agenciaDeTurismo;

import ejerciciosIntegradores.agenciaDeTurismo.modelo.*;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.descuento.Descuento;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.descuento.DescuentoPaqueteCompleto;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.descuento.DescuentoXCantidadLocalizadores;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.descuento.DescuentoXCantidadReserva;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva.Boleto;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva.Comida;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva.Hotel;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva.Transporte;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.repositorios.RepositorioLocalizadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {

        Cliente luciano = new Cliente("Luciano", "Rodriguez", "44208598");
        Paquete paqueteCompleto = new Paquete();
        paqueteCompleto.setDni("44208598");
        paqueteCompleto.setReservaBoleto(new Boleto("lisboa", "argentina", 500.4, "44208598"));
        paqueteCompleto.setReservaComida(new Comida("Premium", 24.6, 2));
        paqueteCompleto.setReservaHotel(new Hotel("Four Seasons", "lituania 2139", 400.5, 2, "44208598"));
        paqueteCompleto.setReservaTransporte(new Transporte("Taxi", "cabildo 1340", "Ezeiza", 40.1));

        Localizador localizador1 = RepositorioLocalizadores.getInstance().generarLocalizador(new ArrayList<>(Arrays.asList(paqueteCompleto)), luciano);

        List<Descuento> descuentos = new ArrayList<>(Arrays.asList(new DescuentoPaqueteCompleto(0.10),
                new DescuentoXCantidadLocalizadores(2, 0.05), new DescuentoXCantidadReserva<Hotel>(2, 0.05)));
        RepositorioLocalizadores.getInstance().setDescuentosAplicables(descuentos);
        RepositorioLocalizadores.getInstance().calcularTotalConDescuentos(localizador1);

        System.out.println("\n ---- Agrego nuevo paquete ---- \n");

        Paquete paqueteA = new Paquete();
        paqueteA.setReservaHotel(new Hotel("Four Seasons", "lituania 2139", 400.5, 2, "509687900"));
        paqueteA.setReservaBoleto(new Boleto("lisboa", "argentina", 500.4, "44208598"));

        Localizador localizador2 = RepositorioLocalizadores.getInstance().generarLocalizador(new ArrayList<>(Arrays.asList(paqueteCompleto, paqueteA)), luciano);

        System.out.println("\n ---- Agrego nuevo paquete ---- \n");

        Paquete paqueteB = new Paquete();
        paqueteB.setReservaHotel(new Hotel("Four Seasons", "lituania 2139", 400.5, 2, "509687900"));
        Localizador localizador3 = RepositorioLocalizadores.getInstance().generarLocalizador(new ArrayList<>(Arrays.asList(paqueteB)), luciano);








    }
}
