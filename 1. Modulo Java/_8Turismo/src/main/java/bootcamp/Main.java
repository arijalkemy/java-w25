package bootcamp;

import bootcamp.Models.Cliente;
import bootcamp.Models.Localizador;
import bootcamp.Models.Reserva;
import bootcamp.Models.TipoReservasEnum;
import bootcamp.Repositorios.RepositorioCliente;
import bootcamp.Repositorios.RespositorioLocalizador;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    RepositorioCliente repositorioCliente = new RepositorioCliente();
    RespositorioLocalizador repositorioLocalizador = new RespositorioLocalizador();

    Cliente cli1 = new Cliente("Ramiro Perez");
    repositorioCliente.add(cli1);
    List<Reserva> reservas = List.of(
            new Reserva(TipoReservasEnum.TRANSPORTE, 500.46),
            new Reserva(TipoReservasEnum.VIAJE, 1300.0),
            new Reserva(TipoReservasEnum.COMIDA, 100.50),
            new Reserva(TipoReservasEnum.HOTEL, 2500.0)
    );

    Localizador local1 = new Localizador(cli1, reservas);

    repositorioLocalizador.add(local1);
        System.out.println("Se agrego un localizador");
        System.out.println("Localizadores");
    repositorioLocalizador.mostrarLocalizadores();

    List<Reserva> reservas2 = List.of(
            new Reserva(TipoReservasEnum.HOTEL, 100.0),
            new Reserva(TipoReservasEnum.VIAJE, 100.0),
            new Reserva(TipoReservasEnum.HOTEL, 100.0),
            new Reserva(TipoReservasEnum.VIAJE, 100.0),
            new Reserva(TipoReservasEnum.COMIDA, 100.0)
    );
    Localizador local2 = new Localizador(cli1, reservas2);
    repositorioLocalizador.add(local2);
        System.out.println("Se agrego un localizador");
        System.out.println("Localizadores");
    repositorioLocalizador.mostrarLocalizadores();
    List<Reserva> reservas3 =List.of(new Reserva(TipoReservasEnum.HOTEL, 100.0));
    Localizador local3= new Localizador(cli1, reservas3);
    repositorioLocalizador.add(local3);
        System.out.println("Se agrego un localizador");
        System.out.println("Localizadores");
    repositorioLocalizador.mostrarLocalizadores();
        System.out.println("localizadores por Tipo de Reserva");
        repositorioLocalizador.mostrarPorTipoReserva();
        System.out.println("Total de ventas:");
        System.out.println(repositorioLocalizador.mostrarTotalVentas());
        System.out.println("Total promedio");
        System.out.println(repositorioLocalizador.mostrarTotalPromedio());
        System.out.println("Cantidad totad de reservas");
        System.out.println(repositorioLocalizador.contarReservas());
    }


    
}