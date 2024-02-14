import Repository.ClienteImp;
import model.Cliente;
import model.Factura;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Crear 3 clientes y guardarlos en una collection.
        Cliente cliente1 = new Cliente(111111, "Juan", "Perez");
        Cliente cliente2 = new Cliente(222222,"Maria", "Fernandez");
        Cliente cliente3 = new Cliente(333333, "Damian", "Mendoza");

        ClienteImp cliImp = new ClienteImp();
        cliImp.save(cliente1);
        cliImp.save(cliente2);
        cliImp.save(cliente3);

        //Recorrer la collection de clientes y mostrar por pantalla l
        cliImp.mostrarPantalla();

        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restante
        Scanner teclado = new Scanner(System.in);
        System.out.println("Eliminar por DNI: ");
        long dniBorrar = teclado.nextInt();
        cliImp.eliminar(dniBorrar);
        cliImp.mostrarPantalla();

        //Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
        System.out.println("Buscar por DNI: ");
        long dniBuscar = teclado.nextInt();
        cliImp.buscar(dniBuscar);

        //-- PARTE 2
        Item item1 = new Item("AB212", "Lentejas", 2,500);
        Item item2 = new Item("ALDN2", "Coca Cola", 1, 2560);
        Item item3 = new Item("21MDS", "Papel", 4, 1202);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        Factura factura = new Factura(12342, cliente1, items);
        System.out.println(factura);
    }

    public static void imprimirLista(List<Cliente> array){
        for(Cliente obj:array) System.out.println(obj.toString());
    }

//    public static void buscarCliente(List<Cliente> array){
//        Scanner teclado = new Scanner(System.in);
//        System.out.println("Bienvenido al buscador de clientes");
//        System.out.println("Buscar por DNI: ");
//        int dni = teclado.nextInt();
//
//        for(Cliente cli: array){
//            if(cli.getDni()==dni){
//                System.out.println("model.Cliente encontrado:");
//                System.out.println(cli.toString());
//                return;
//            }
//        }
//        System.out.println("Ups, no existe un cliente con dicho DNI...");
//    }
}
