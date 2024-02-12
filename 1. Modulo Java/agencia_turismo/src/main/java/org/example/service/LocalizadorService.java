package org.example.service;

import org.example.entity.Cliente;
import org.example.entity.DetalleReserva;
import org.example.entity.Localizador;
import org.example.entity.Reservas;
import org.example.repository.ClienteRepository;
import org.example.repository.LocalizadorRepository;

import java.util.List;


public class LocalizadorService {
    private ClienteRepository clienteRepository = new ClienteRepository();
    private LocalizadorRepository localizadorRepository = new LocalizadorRepository();


    public void crearLocalizadorConDescuentos(long clienteDni, List<Reservas> reservasList){
        Cliente clienteExistente = clienteRepository.getClienteList().stream().filter(cliente -> cliente.getDni()==clienteDni).findFirst().orElseThrow();
        int newId = localizadorRepository.getLocalizadorList().size()+1;
        if(obtenerNumeroLocalizadoresPorClienteDni(clienteExistente.getDni())>=2){
            reservasList.forEach(reservas -> reservas.setPrecio(reservas.getPrecio()*0.95));
        }
        Localizador localizador = new Localizador(newId, clienteExistente);
        localizadorRepository.addLocalizador(localizador);
    }

    private long obtenerNumeroLocalizadoresPorClienteDni(long dni){
        return localizadorRepository.getLocalizadorList().stream().filter(localizador -> localizador.getCliente().getDni()==dni).count();
    }

    public void test(){
        System.out.println(localizadorRepository.getLocalizadorList());

    }
}
