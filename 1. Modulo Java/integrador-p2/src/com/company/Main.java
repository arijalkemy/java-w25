package com.company;

import com.company.model.Cliente;
import com.company.model.Factura;
import com.company.model.Item;
import com.company.repository.ClienteRepository;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    private static ClienteRepository<Cliente> clienteRepository;
    private static List<Item> items;
    public static void main(String[] args) {

        /////    PARTE 2   /////////
        inicializarDatos();

        Cliente cliente = new Cliente("123", "Cristiano", "Ronaldo");
        validarCliente(cliente);

        Factura factura = new Factura(cliente, items);

        System.out.println("Total factura: "+factura.getTotalVenta());

    }

    public static void inicializarDatos(){
        clienteRepository =  new ClienteRepository<>();

        items = new ArrayList<>(Arrays.asList(
                new Item("ABC", "PAPEL", 1, new BigDecimal("2.0")),
                new Item("DEF", "JUGO", 2, new BigDecimal("2.0"))
        ));
    }

    public static void validarCliente(Cliente cliente){
        if(clienteRepository.findById(cliente.getDni()).isEmpty()){
            clienteRepository.add(cliente);
        }
    }

}
