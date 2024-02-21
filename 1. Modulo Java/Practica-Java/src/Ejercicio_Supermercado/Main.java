package Ejercicio_Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente_Super> clientes = agregarClientes();

        mostrarClientes(clientes);
        borrarCliente(clientes);
        mostrarClientes(clientes);
        //buscarCliente(clientes);
    }

    public static List<Cliente_Super> agregarClientes() {
        List<Cliente_Super> clientes = new ArrayList<>();

        Cliente_Super clien1 = new Cliente_Super(12345678, "Juan Manuel", "Pergola");
        Cliente_Super clien2 = new Cliente_Super(12345678, "Matias", "Lopez");
        Cliente_Super clien3 = new Cliente_Super(39515920, "Nicolas", "Venis");

        clientes.add(clien1);
        clientes.add(clien2);
        clientes.add(clien3);

        return clientes;
    }

    public static void mostrarClientes(List<Cliente_Super> clientes) {
        for(Cliente_Super cli : clientes) {
            System.out.println("Cliente " + cli);
        }
    }

    public static void buscarCliente(List<Cliente_Super> clientes) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Ingrese dni de cliente a buscar: ");
        int dniABuscar = tec.nextInt();

        Optional<Cliente_Super> cliente = clientes.stream()
                                                    .filter(cli -> cli.getDni() == dniABuscar)
                                                    .findFirst();

        if (!cliente.isEmpty()) {
            System.out.println("Cliente encontrado!");
            System.out.println(cliente.get());
        } else {
            System.out.println("Cliente NO encontrado.");
        }
    }

    public static void borrarCliente(List<Cliente_Super> clientes) {
        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese dni de cliente a borrar: ");
        int dniABorrar = in.nextInt();

        Optional<Cliente_Super> cliente = clientes.stream()
                                                    .filter(cli -> cli.getDni() == dniABorrar)
                                                    .findFirst();

        if (!cliente.isEmpty()) {
            System.out.println("Cliente encontrado, se procede a ser borrado...");
            clientes.remove(cliente.get());
        } else {
            System.out.println("Cliente NO encontrado.");
        }
    }
}
