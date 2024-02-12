package org.example;

import org.example.entity.Cliente;
import org.example.entity.DetalleReserva;
import org.example.entity.Localizador;
import org.example.entity.Reservas;
import org.example.repository.ClienteRepository;
import org.example.service.LocalizadorService;

public class Main {
    public static void main(String[] args) {
        LocalizadorService localizadorService = new LocalizadorService();
        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.addCliente(new Cliente(35234234,"Facu","Salvia"));

        Localizador localizador1 = new Localizador(1, clienteRepository.getClienteList().get(0));
        localizador1.addReserva(new Reservas(1, DetalleReserva.HOTEL));
        //localizadorRepository.addLocalizador(localizador1);
    }
}