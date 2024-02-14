package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ejercicio01();
        ejercicio02();
        ejercicio03();
        ejercicio04();
    }

    public static void ejercicio01() {
        Cliente cliente1 = new Cliente("12345678", "Juan Manuel");
        List<Reserva> listaDeReservas = new ArrayList<>();

        ReservaHotel reservaHotel = new ReservaHotel(123.567);
        ReservaComida reservaComida = new ReservaComida(40.231);
        ReservaBoletoDeViaje reservaBoletoDeViaje = new ReservaBoletoDeViaje(29.876);
        ReservaTransporte reservaTransporte = new ReservaTransporte(20.345);

        listaDeReservas.add(reservaTransporte);
        listaDeReservas.add(reservaComida);
        listaDeReservas.add(reservaBoletoDeViaje);
        listaDeReservas.add(reservaTransporte);

        Localizador local = new Localizador(cliente1, listaDeReservas);
        RepositorioLocalizador.addLocalizador(local);

        System.out.println("El cliente " + cliente1 + " posee las siguientes reservas: ");
        for(Reserva r : local.getListaDeReservas()) {
            System.out.println(r);
        }
    }

    public static void ejercicio02() {
        //TO-DO
    }

    public static void ejercicio03() {
        //TO-DO
    }

    public static void ejercicio04() {
        //TO-DO
    }
}