package supermercado;

import supermercado.model.Cliente;
import supermercado.model.Factura;
import supermercado.model.Item;

import java.util.*;

public class Supermercado {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("45244598", "Nahuel", "Quilpatay"));
        clientes.add(new Cliente("45244699", "Nachuchi", "Quilpo"));
        clientes.add(new Cliente("45244765", "Inasio", "Katapai"));
        clientes.add(new Cliente("17923190", "Vicor", "Ugo"));
        clientes.add(new Cliente("24692435", "Lawa", "Acmpos"));

        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Item 1", 1, 100));
        items.add(new Item(2, "Item 2", 2, 200));
        items.add(new Item(3, "Item 3", 3, 300));

        List<Factura> facturas = new ArrayList<>();

        /*for (Cliente c : clientes) {
            System.out.println(c.toString());
        }

        clientes.remove(1);

        System.out.println("\nRecorrido LUEGO de eliminación:");
        for (Cliente c : clientes) {
            System.out.println("------------");
            System.out.println(c.toString());
        }*/

        Scanner sc = new Scanner(System.in);
        String buscarDni;
        boolean encontrado = true;
        System.out.println("\nIngresar DNI a buscar");
        buscarDni = sc.next();

        Optional<Cliente> clienteBuscado = clientes.stream()
                .filter(c -> c.getDni().equals(buscarDni))
                .findFirst();

        if (clienteBuscado.isPresent()) {
            System.out.println("Cliente encontrado correctamente.");
            System.out.println(clienteBuscado.get().toString());

            Factura f = new Factura(clienteBuscado.get(), items);
        } else {
            System.out.println("Cliente no encontrado. Crear cliente:");

            System.out.println("Ingresar DNI:");
            String dniCrearCliente = sc.next();
            System.out.println("Ingresar nombre:");
            String nombreCrearCliente = sc.next();
            System.out.println("Ingresar apellido:");
            String apellidoCrearCliente = sc.next();

            Cliente nuevoCliente = new Cliente(dniCrearCliente, nombreCrearCliente, apellidoCrearCliente);
            clientes.add(nuevoCliente);
            Factura f = new Factura(nuevoCliente, items);
            facturas.add(f);

            System.out.println("Cliente y factura añadidos exitosamente");
        }
        sc.close();
    }
}
