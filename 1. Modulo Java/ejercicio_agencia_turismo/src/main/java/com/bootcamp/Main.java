package main.java.com.bootcamp;

import main.java.com.bootcamp.model.Cliente;
import main.java.com.bootcamp.model.Localizador;
import main.java.com.bootcamp.model.Reserva;
import main.java.com.bootcamp.model.TipoReserva;
import main.java.com.bootcamp.repository.RepositoryCliente;
import main.java.com.bootcamp.repository.RepositoryLocalizador;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositoryCliente repositoryCliente = new RepositoryCliente();
        RepositoryLocalizador repositoryLocalizador = new RepositoryLocalizador();

        Cliente cli1 = new Cliente("Tobias Medina");
        repositoryCliente.add(cli1);
        List<Reserva> reservas = List.of(
                new Reserva(TipoReserva.TRANSPORTE, 500.46),
                new Reserva(TipoReserva.VIAJE, 1300.0),
                new Reserva(TipoReserva.COMIDA, 100.50),
                new Reserva(TipoReserva.HOTEL, 2500.0)
        );

        Localizador local1 = new Localizador(cli1, reservas);

        repositoryLocalizador.add(local1);
        System.out.println("Se agrego un localizador");
        System.out.println("Localizadores");
        repositoryLocalizador.mostrarLocalizadores();

        List<Reserva> reservas2 = List.of(
                new Reserva(TipoReserva.HOTEL, 100.0),
                new Reserva(TipoReserva.VIAJE, 100.0),
                new Reserva(TipoReserva.HOTEL, 100.0),
                new Reserva(TipoReserva.VIAJE, 100.0),
                new Reserva(TipoReserva.COMIDA, 100.0)
        );
        Localizador local2 = new Localizador(cli1, reservas2);
        repositoryLocalizador.add(local2);
        System.out.println("Se agrego un localizador");
        System.out.println("Localizadores");
        repositoryLocalizador.mostrarLocalizadores();
        List<Reserva> reservas3 =List.of(new Reserva(TipoReserva.HOTEL, 100.0));
        Localizador local3= new Localizador(cli1, reservas3);
        repositoryLocalizador.add(local3);
        System.out.println("Se agrego un localizador");
        System.out.println("Localizadores");
        repositoryLocalizador.mostrarLocalizadores();
        System.out.println("localizadores por Tipo de Reserva");
        repositoryLocalizador.mostrarPorTipoReserva();
        System.out.println("Total de ventas:");
        System.out.println(repositoryLocalizador.mostrarTotalVentas());
        System.out.println("Total promedio");
        System.out.println(repositoryLocalizador.mostrarTotalPromedio());
        System.out.println("Cantidad totad de reservas");
        System.out.println(repositoryLocalizador.contarReservas());
    }
}

