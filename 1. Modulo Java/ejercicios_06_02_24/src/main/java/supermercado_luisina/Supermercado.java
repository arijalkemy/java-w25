package supermercado_luisina;

import supermercado_luisina.model.Item;
import supermercado_luisina.model.Cliente;
import supermercado_luisina.model.Factura;
import supermercado_luisina.repository.ClienteImp;
import supermercado_luisina.repository.FacturaImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {

        ClienteImp clienteImp = new ClienteImp();

        //-------------------------------------crear collection clientes-------------------------------------

        Cliente cli1 = new Cliente(45244598L, "Nahuel", "Quilpatay");
        Cliente cli2 = new Cliente(45244699L, "Nachuchi", "Quilpo");
        Cliente cli3 = new Cliente(45244765L, "Inasio", "Katapai");
        Cliente cli4 = new Cliente(17923190L, "Vicor", "Ugo");
        Cliente cli5 = new Cliente(24692435L, "Lawa", "Acmpos");

        /*List<Cliente> clientes = new ArrayList<>();

        clientes.add(cli1);
        clientes.add(cli2);
        clientes.add(cli3);
        clientes.add(cli4);
        clientes.add(cli5);*/

        clienteImp.save(cli1);
        clienteImp.save(cli2);
        clienteImp.save(cli3);
        clienteImp.save(cli4);
        clienteImp.save(cli5);

        //-------------------------------------mostrar clientes-------------------------------------

        /*for (Cliente c : clientes) {
            System.out.println("-----Cliente-----");
            System.out.println("DNI: " + c.getDni()
                    + "\nNOMBRE: " + c.getNombre()
                    + "\nAPELLIDO: " + c.getApellido());
        }*/

        clienteImp.mostrar();

        //-------------------------------------eliminar cliente-------------------------------------

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar DNI de la persona a eliminar.");
        Long dniEliminar = sc.nextLong();

        /*boolean clienteEncontrado = false;

        for (Cliente c : clientes) {
            if (c.getDni().equals(dniEliminar)) {
                clientes.remove(c);
                clienteEncontrado = true;
                break;
            }
        }
        if (!clienteEncontrado) {
            System.out.println("No se encontró el cliente a eliminar.");
        } else {
            System.out.println("Cliente eliminado correctamente.");
        }*/

        clienteImp.eliminar(dniEliminar);

        //-------------------------------------buscar cliente-------------------------------------

        System.out.println("Ingresar DNI a buscar.");
        Long dniBuscar = sc.nextLong();

        /*clienteEncontrado = false;

        for (Cliente c : clientes) {
            if (c.getDni().equals(dniBuscar)) {
                System.out.println("-----Cliente encontrado:-----");
                System.out.println("DNI: " + c.getDni()
                        + "\nNOMBRE: " + c.getNombre()
                        + "\nAPELLIDO: " + c.getApellido());
                break;
            }
        }
        if (!clienteEncontrado) {
            System.out.println("No se encontró el cliente.");
        }*/

        clienteImp.buscar(dniBuscar);

        //-------------------------------------crear factura-------------------------------------

        List<Item> items = new ArrayList<>();
        items.add(new Item(1L, "Item 1", 1, 100));
        items.add(new Item(2L, "Item 2", 2, 200));
        items.add(new Item(3L, "Item 3", 3, 300));

        FacturaImp facturaImp = new FacturaImp();

        clienteImp.mostrar();
        Factura factura1 = new Factura(1L, cli5, items);

        facturaImp.save(factura1);
    }
}
