package org.example;

import org.example.repo.RepoClienteImpl;
import org.example.repo.RepoLocalizadorImpl;

public class Main {
    public static double descuento(Localizador localizador, RepoLocalizadorImpl repo) {
        boolean hotel = false;
        boolean comida = false;
        boolean boletos = false;
        boolean transporte = false;
        double total = 0;

        int cantHotel = 0;
        int cantBoletos = 0;
        for (Reserva i : localizador.getReservaList()) {
            if (i.getTipo().equals("hotel")) {
                cantHotel += 1;
                hotel = true;
            } else if (i.getTipo().equals("comida")) {
                comida = true;
            } else if (i.getTipo().equals("boletos de viaje")) {
                cantBoletos += 1;
                boletos = true;
            } else if (i.getTipo().equals("transporte")) {
                transporte = true;
            }

        }
        int cant = 0;
        for (Localizador i : repo.getList()) {
            if (localizador.getCliente().equals(i.getCliente())) {
                cant += 1;
            }
        }
        for (Reserva i : localizador.getReservaList()) {
            if (i.getTipo().equals("hotel")) {
                if (cantHotel >= 2) {
                    total += i.getPrecio() * 0.95;
                } else {
                    total += i.getPrecio();
                }
            } else if (i.getTipo().equals("boletos de viaje")) {
                if (cantBoletos >= 2) {
                    total += i.getPrecio() * 0.95;
                } else {
                    total += i.getPrecio();
                }
            } else{
                total += i.getPrecio();
            }
        }


        if (cant >= 2) {
            total *= 0.95;
        }
        if (hotel && comida && boletos && transporte) {
            total *= 0.9;
        }
        return total;
    }

    public static void main(String[] args) {
        RepoClienteImpl repoCliente = new RepoClienteImpl();
        RepoLocalizadorImpl repoLocalizador = new RepoLocalizadorImpl();

        Cliente cli1 = new Cliente("Juan", "120391903", "zapata");
        repoCliente.add(cli1);

        Localizador local1 = new Localizador(cli1);
        repoLocalizador.add(local1);

        local1.addReserva(new Reserva(1, 1500, "hotel"));
        local1.addReserva(new Reserva(2, 3000, "comida"));
        local1.addReserva(new Reserva(3, 500, "boletos de viaje"));
        local1.addReserva(new Reserva(4, 300, "transporte"));

        System.out.println(Main.descuento(local1,repoLocalizador));

        Localizador local2 = new Localizador(cli1);
        repoLocalizador.add(local2);
        local2.addReserva(new Reserva(5, 1500, "hotel"));
        local2.addReserva(new Reserva(6, 2000, "hotel"));
        local2.addReserva(new Reserva(7, 3000, "boletos de viaje"));
        local2.addReserva(new Reserva(8, 4000, "boletos de viaje"));
        System.out.println(Main.descuento(local2,repoLocalizador));

        Localizador local3 = new Localizador(cli1);
        repoLocalizador.add(local3);
        local3.addReserva(new Reserva(9, 100, "comida"));
        System.out.println(Main.descuento(local3,repoLocalizador));
    }
}