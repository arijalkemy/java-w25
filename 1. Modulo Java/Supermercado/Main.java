package Supermercado;

import Supermercado.Controller.ClienteController;
import Supermercado.Models.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("1000066567", "Andrés Madera");
        ClienteController clienteController = new ClienteController();

        clienteController.create(cliente);
        
    }
}
