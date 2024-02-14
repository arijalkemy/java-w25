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

    }
}
