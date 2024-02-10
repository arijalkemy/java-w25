package org.example;

import org.example.repositorios.RepositorioCliente;
import org.example.repositorios.RepositorioLocalizador;
import org.example.modelo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Juancito");
        RepositorioCliente repoCliente = new RepositorioCliente();
        RepositorioLocalizador repoLocalizador = new RepositorioLocalizador();
        // boleto comida hotel transporte
        ReservaHotel hotel = new ReservaHotel("hilton", 345.6, 2);
        ReservaBoleto boleto = new ReservaBoleto("fast tren", 25.6, 2);
        ReservaComida comida = new ReservaComida("all inclusive", 453, 2);
        ReservaTransporte transporte = new ReservaTransporte("auto", 23.4, 2);

        List<Reserva> reservas = new ArrayList<>(Arrays.asList(hotel, boleto, comida, transporte));

        Localizador localizador1 = new Localizador(cliente1, reservas);
        cliente1.agregarLocalizador(localizador1);
        repoCliente.agregarCliente(cliente1);
        repoLocalizador.agregarLocalizador(localizador1);
        //mostrar resultado
        System.out.println("Mostrar paquete creado");
        System.out.println(repoLocalizador.getLocalizadores());


        ReservaHotel hotel1 = new ReservaHotel("decameron", 500, 6);
        ReservaBoleto boleto1 = new ReservaBoleto("aerolineas argentinas", 350, 3);

        List<Reserva> reservas1 = new ArrayList<>(Arrays.asList(hotel1, boleto1));

        Localizador localizador2 = new Localizador(cliente1, reservas1);
        cliente1.agregarLocalizador(localizador2);
        repoCliente.agregarCliente(cliente1);
        repoLocalizador.agregarLocalizador(localizador2);
        System.out.println("Mostrar localizadores con 2 hoteles y 2 boletos:");
        System.out.println(repoLocalizador.getLocalizadores());
        System.out.println("-----------");
        System.out.println("Cantidad de localizadores vendidos");
        System.out.println(repoLocalizador.totalLocalizadoresVendidos());

        System.out.println("Total reservas");
        System.out.println(repoLocalizador.totalReservas());

        System.out.println("Total ventas");
        System.out.println(repoLocalizador.totalVentas());

        System.out.println("Promedio de las ventas");
        System.out.println(repoLocalizador.promedioVentas());

    }
}