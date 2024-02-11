package bootcamp;

import bootcamp.Model.Cliente;
import bootcamp.Model.Factura;
import bootcamp.Model.Item;
import bootcamp.Model.Producto;
import bootcamp.Repositories.ClienteRepositoryImp;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ClienteRepositoryImp clienteRepository = new ClienteRepositoryImp(new ArrayList<>(Arrays.asList(
                new Cliente("123414141", "Pepito", "Sanchez"),
                new Cliente("82314414", "Pedro", "Pascal"),
                new Cliente("92314414", "Pedrito", "Pascal")

        )));
        System.out.println("Clientes");
        clienteRepository.MostrarClientes();
        clienteRepository.removeByDni("82314414");
        System.out.println("Clientes luego de eliminar 1");
        clienteRepository.MostrarClientes();
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        do {
            System.out.println("Ingrese un DNI para buscarlo o -1 para salir: ");
            respuesta = scanner.next();
            Optional<Cliente> clienteBuscado = clienteRepository.getByDNI(respuesta);
            clienteBuscado.ifPresent(value -> System.out.println("Cliente encontrado: " + value));
        }while (!respuesta.equals("-1"));
        Producto manzana = new Producto(1, "Manzana");
        List<Item> items1 = List.of(new Item(manzana, 2, 1500));
        List<Factura> facturas = new ArrayList<>();
        /*
        Factura fac1 = new Factura(clientes.get(0), items1);
        if(clientes.stream().anyMatch(cliente -> cliente.equals(fac1.getCliente()))){
            System.out.println("Cliente encontrado");
            facturas.add(fac1);
        }else {
            System.out.println("Cliente no Encontrado");
            clientes.add(fac1.getCliente());
            facturas.add(fac1);
        }
        Factura fac2 = new Factura(new Cliente("124541235", "Juan", "Perez"), items1);
        if(clientes.stream().anyMatch(cliente -> cliente.equals(fac2.getCliente()))){
            System.out.println("Cliente encontrado");
            facturas.add(fac2);
        }else {
            System.out.println("Cliente no Encontrado");
            clientes.add(fac2.getCliente());
            facturas.add(fac2);
        }*/

    }
}