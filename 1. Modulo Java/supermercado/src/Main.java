import model.Cliente;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("ssas");
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente1 = new Cliente("111", "sergio", "mancilla");
        Cliente cliente2 = new Cliente("222", "gabriel", "lolo");
        Cliente cliente3 = new Cliente("333", "juan", "luul");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        for (Cliente cliente : clientes) {
            System.out.println("DNI: " + cliente.getDni() +
                    ", Nombre: " + cliente.getNombre() +
                    ", Apellido: " + cliente.getApellido());
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("\nIngrese dni a borrar: ");
        String dniEliminar = teclado.nextLine();
        //clientes.remove(0);

        boolean bandera = false;

        // clientes.removeIf(cliente -> cliente.getDni().equals(dniEliminar));
        for (Cliente cliente : clientes) {
            if(cliente.getDni().equals(dniEliminar)) {
                clientes.remove(cliente);
                bandera = true;
                break;
            }
        }

        if (bandera) {
            System.out.println("Cliente borrado con DNI: "+dniEliminar);
        } else {
            System.out.println("No se encontrò el cliente!");
        }

        System.out.println("Lista actualizada");
        for (Cliente cliente : clientes) {
            System.out.println("DNI: " + cliente.getDni() +
                    ", Nombre: " + cliente.getNombre() +
                    ", Apellido: " + cliente.getApellido());
        }

        System.out.println("\nIngrese dni a buscar: ");
        String dni = teclado.nextLine();
        System.out.println("buscó: " + dni);

        /*clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni) )
                .collect(Collectors.toList());
        */
        /*Cliente a = null;

        for (Cliente cliente : clientes) {
            if(cliente.getDni().equals(dni)) {
                a = cliente;
            }
        }
        if(a != null) {
            System.out.println("model.Cliente encontrado:" + a.toString());
        }else {
            System.out.println("model.Cliente NO encontrado:");
        }
*/

        Cliente encontrado = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst() // encuentra el primero y sale
                .orElse(null);


        if(encontrado != null) {
            System.out.println("Cliente encontrado:" + encontrado);
        }else {
            System.out.println("Cliente NO encontrado:");
        }

    }
}
