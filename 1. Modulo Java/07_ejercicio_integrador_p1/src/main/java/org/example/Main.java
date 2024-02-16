package org.example;

import org.example.controlador.RepositorioCliente;
import org.example.controlador.RepositorioVentas;
import org.example.modelo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juancito");
        Venta ventaCliente1 = new Venta(cliente1);
        RepositorioCliente repoCliente = new RepositorioCliente();
        RepositorioVentas repoVenta = new RepositorioVentas();

        // PARTE 1

        // Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el
        // resultado.
        ReservaHotel hotel = new ReservaHotel("hilton", 345.6, 2);
        ReservaBoleto boleto = new ReservaBoleto("fast tren", 25.6, 2);
        ReservaComida comida = new ReservaComida("all inclusive", 453, 2);
        ReservaTransporte transporte = new ReservaTransporte("auto", 23.4, 2);

        List<Reserva> reservas = new ArrayList<>(Arrays.asList(hotel, boleto, comida, transporte));

        Localizador localizador1 = new Localizador(cliente1, reservas);
        ventaCliente1.agregarLocalizador(localizador1);
        repoCliente.agregarCliente(cliente1);
        repoVenta.agregarVenta(ventaCliente1);

        System.out.println("************************");
        System.out.println("Mostrar paquete creado:");
        System.out.println(ventaCliente1.getLocalizadores());

        // Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente
        // anterior, almacenar e imprimir el resultado.

        ReservaHotel hotel1 = new ReservaHotel("decameron", 500, 2);
        ReservaBoleto boleto1 = new ReservaBoleto("aerolineas argentinas", 350, 2);

        List<Reserva> reservas1 = new ArrayList<>(Arrays.asList(hotel1, boleto1));

        Localizador localizador2 = new Localizador(cliente1, reservas1);
        ventaCliente1.agregarLocalizador(localizador2);

        System.out.println("\n************************");
        System.out.println("Mostrar localizadores con 2 hoteles y 2 boletos:");
        System.out.println(ventaCliente1.getLocalizadores());

        System.out.println("\n************************");
        System.out.println("Cantidad de localizadores vendidos:");
        System.out.println(repoVenta.totalLocalizadoresVendidos());

        System.out.println("\n************************");
        System.out.println("Total reservas");
        System.out.println(repoVenta.totalReservas());

        System.out.println("\n************************");
        System.out.println("Total ventas");
        System.out.println(repoVenta.totalVentas());

        System.out.println("\n************************");
        System.out.println("Promedio de las ventas");
        System.out.println(repoVenta.promedioVentas());

        System.out.println("\n************************");
        System.out.println(" Unica venta pendiente:");
        System.out.println(ventaCliente1);

        System.out.println("\n************************");
        System.out.println("Venta aprobada:");

        Cliente cliente2 = new Cliente("Alejandro Lozada");
        Venta ventaCliente2 = new Venta(cliente2);
        ReservaHotel reservaHotel2 = new ReservaHotel("Gallery hotel", 600, 2);
        Localizador localizador3 = new Localizador(cliente2, List.of(reservaHotel2));
        ventaCliente2.agregarLocalizador(localizador3);
        ventaCliente2.aprobarCompra();
        System.out.println(ventaCliente2);
    }
}