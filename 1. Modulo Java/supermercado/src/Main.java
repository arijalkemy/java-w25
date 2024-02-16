import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("1", "Laura", "Zapata");
        Cliente cliente2 = new Cliente("2", "Luis", "Zapata");
        Cliente cliente3 = new Cliente("3", "Romario", "Isco");

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getDni() + " " + cliente.getNombre() + " " + cliente.getApellido() + "\n");
        }

        clientes.remove(cliente1);

        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getDni() + " " + cliente.getNombre() + " " + cliente.getApellido() + "\n");
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese dni:");
        String dni = scanner.nextLine();

        Optional<Cliente> clienteSearched = clientes.stream().filter(c -> dni.equals(c.getDni())).findFirst();

        System.out.println(clienteSearched.isPresent() ? clienteSearched.get().getNombre() + " " + clienteSearched.get().getApellido() : "Cliente no existe");

        //Parte 2
        List<Product> products = new ArrayList<>();

        products.add(new Product("45", "Desodorante", 1, 20000.0));
        Factura factura2 = new Factura(2, cliente2, products);
    }
}