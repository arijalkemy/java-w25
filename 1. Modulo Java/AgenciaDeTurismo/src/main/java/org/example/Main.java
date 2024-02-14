package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Mario", "123456789");

        Localizador localizador1 = new Localizador(
                cliente1,
                List.of(new Reserva(1000.0, TipoReserva.BOLETO))
        );
    }
}