package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // PARTE 1
        // ITEM 1
        Cliente cliente1 = new Cliente("12345678", "Gustavo");
        List<Reserva> listaDeReservas = new ArrayList<>();

        ReservaHotel reservaHotel = new ReservaHotel(123.567);
        ReservaComida reservaComida = new ReservaComida(40.231);
        ReservaBoletoDeViaje reservaBoletoDeViaje = new ReservaBoletoDeViaje(29.876);
        ReservaTransporte reservaTransporte = new ReservaTransporte(20.345);

        listaDeReservas.add(reservaHotel);
        listaDeReservas.add(reservaComida);
        listaDeReservas.add(reservaBoletoDeViaje);
        listaDeReservas.add(reservaTransporte);

        Localizador local = new Localizador(cliente1, listaDeReservas);
        RepositorioLocalizador.addLocalizador(local);

        System.out.println("-----ITEM 1-----");
        System.out.println("El cliente " + cliente1 + " posee las siguientes reservas: ");
        for (Reserva r : local.getListaDeReservas()) {
            System.out.println(r);
        }

        System.out.println("El cliente " + cliente1 + " abonó un monto total de: " + local.getMontoFinal());
        System.out.println("Monto antes del descuento: " + local.getMontoOriginal());

        // ITEM 2
        List<Reserva> listaDeReservas2 = new ArrayList<>();

        ReservaHotel reservaHotel2 = new ReservaHotel(123.567);
        ReservaHotel reservaHotel3 = new ReservaHotel(123.567);
        ReservaBoletoDeViaje reservaBoletoDeViaje2 = new ReservaBoletoDeViaje(29.876);
        ReservaBoletoDeViaje reservaBoletoDeViaje3 = new ReservaBoletoDeViaje(29.876);

        listaDeReservas2.add(reservaHotel2);
        listaDeReservas2.add(reservaHotel3);
        listaDeReservas2.add(reservaBoletoDeViaje2);
        listaDeReservas2.add(reservaBoletoDeViaje3);

        Localizador local2 = new Localizador(cliente1, listaDeReservas2);
        RepositorioLocalizador.addLocalizador(local);

        System.out.println("----------------------------------");
        System.out.println("-----ITEM 2-----");
        System.out.println("El cliente " + cliente1 + " reservó recientemente lo siguiente: ");
        for (Reserva r : listaDeReservas2) {
            System.out.println(r);
        }

        System.out.println("El cliente " + cliente1 + " abonó un monto total de: " + local2.getMontoFinal());

        // ITEM 3
        List<Reserva> listaDeReservas3 = new ArrayList<>();
        ReservaComida reservaComida2 = new ReservaComida(50);
        listaDeReservas3.add(reservaComida2);
        Localizador local3 = new Localizador(cliente1, listaDeReservas3);

        // ITEM 4
        System.out.println("----------------------------------");
        System.out.println("-----ITEM 4-----");
        double precioTotalOriginal = local.getMontoOriginal() + local2.getMontoOriginal() + local3.getMontoOriginal();
        System.out.println("Precio total original: " + precioTotalOriginal);

        double precioTotalFinal = local.getMontoFinal() + local2.getMontoFinal() + local3.getMontoFinal();
        System.out.println("Precio total final: " + precioTotalFinal);

        // PARTE 2
        Informe informe = new Informe();
        System.out.println("Localizadores vendidos: " + informe.getLocalizadoresVendidos());
        System.out.println("Reservas totales: " + informe.getReservasTotales());
        System.out.println("Ventas totales: " + informe.getVentasTotales());
        System.out.println("Promedio: " + informe.getPromedioVentas());
        informe.getTodasLasReservas().forEach((reserva, integer) -> System.out.println("Reserva: " +
                reserva.getNombre() + "\nCantidad: " + integer));

    }
}