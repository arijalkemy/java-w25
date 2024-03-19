package main;

import main.Model.Cliente;
import main.repository.ClienteRepository;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Cliente cliente1 = new Cliente(1,"Ricardo","Montaner");
        Cliente cliente2 = new Cliente(2,"Jaime","Garzón");
        Cliente cliente3 = new Cliente(3,"Jorge","Ramirez");
        ClienteRepository clienteRepository = new ClienteRepository();

        clienteRepository.crearCliente(cliente1);
        clienteRepository.crearCliente(cliente2);
        clienteRepository.crearCliente(cliente3);

        clienteRepository.mostrarClientes();

        System.out.println("Se eliminarán el cliente con dni: 1" );
        clienteRepository.eliminarCliente(1);
        clienteRepository.mostrarClientes();

        System.out.println("Indique el dni del cliente que se desea buscar: ");
        clienteRepository.buscarCliente(keyboard.nextInt());

    }
}