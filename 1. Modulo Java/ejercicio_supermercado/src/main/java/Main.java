import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente1 = new Cliente("1212341234", "Juan");
        Cliente cliente2 = new Cliente("1212341235", "Pedro");
        Cliente cliente3 = new Cliente("1212341236", "Lucas");

        ArrayList<Cliente> clienteCollection = new ArrayList<>();

        clienteCollection.add(cliente1);
        clienteCollection.add(cliente2);
        clienteCollection.add(cliente3);

        clienteCollection.forEach(System.out::println);

        System.out.println("Elimino cliente:");

        clienteCollection.remove(cliente3);

        clienteCollection.forEach(System.out::println);

        System.out.println("Ingrese DNI del cliente:");
        String dni = scanner.nextLine();

        List<Cliente> clienteBuscado = clienteCollection.stream().filter(cliente -> cliente.getDni().equals(dni)).toList();

        if (clienteBuscado.isEmpty()){
            System.out.println("No se encontró el cliente");
        } else {
            System.out.println(clienteBuscado);
        }

        ArrayList<Item> itemCollection = new ArrayList<>();

        Item item1 = new Item("ahfo236", "Pure", 1,23.56);
        Item item2 = new Item("al82fg2", "Leche", 3,23.67);
        Item item3 = new Item("l2h928y", "Cafe", 2,32.56);

ArrayList<Factura> facturaCollection = new ArrayList<>();

Factura factura1 = new Factura(cliente1, itemCollection);
    }
}
