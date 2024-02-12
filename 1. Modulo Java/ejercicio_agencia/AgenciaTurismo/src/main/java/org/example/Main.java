package org.example;

import org.example.caracteristicas.BoletoViaje;
import org.example.caracteristicas.Comida;
import org.example.caracteristicas.Hotel;
import org.example.caracteristicas.Transporte;
import org.example.model.Cliente;
import org.example.model.IReserva;
import org.example.model.ReservaBase;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente(12345678, "Juan Perez");
        IReserva reservaCompleta = new Hotel(
                new BoletoViaje(
                        new Comida(
                                new Transporte(
                                        new ReservaBase()
                                )
                        )
                )
        );
        ArrayList<IReserva> reservas = new ArrayList<>();
        reservas.add(reservaCompleta);

        Localizador localizadorReservaCompleta = new Localizador(cliente, reservas);

        reservas = new ArrayList<>();
        IReserva reserva1 = new Hotel(
                new BoletoViaje(
                    new ReservaBase()
                )
        );

        reservas.add(reserva1);

        IReserva reserva2 = new Hotel(
                new BoletoViaje(
                        new ReservaBase()
                )
        );
        reservas.add(reserva2);

        Localizador localizador2 = new Localizador(cliente, reservas);

        reservas = new ArrayList<>();
        IReserva reserva3 = new Hotel(
                new BoletoViaje(
                        new Transporte(
                                new ReservaBase()
                        )
                )
        );

        Localizador localizador3 = new Localizador(cliente, reservas);

    }
}