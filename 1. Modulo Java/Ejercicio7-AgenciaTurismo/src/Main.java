import models.Client;
import models.Localizador;
import models.Reserva;
import models.TipoReserva;
import repository.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client cliente = new Client("1", "Juan Felipe");
        List<Reserva> reservas = new ArrayList<>();

        reservas.add(new Reserva(1, TipoReserva.ALIMENTACION, 75000.0));
        reservas.add(new Reserva(2, TipoReserva.HOTEL, 300000.0));
        reservas.add(new Reserva(3, TipoReserva.TIQUETES, 560000.0));
        reservas.add(new Reserva(4, TipoReserva.TRANSPORTE, 30000.0));

        Localizador localizador = new Localizador(1, cliente, reservas);

        Repositorio.getLocalizadores().add(localizador);


        System.out.println(TipoReserva.HOTEL);
    }
}