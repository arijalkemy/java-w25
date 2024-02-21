package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(11222333, "Pedro", "Cabezas");
        Cliente cliente2 = new Cliente(22333444, "Diego", "Lopez");
        Cliente cliente3 = new Cliente(33444555, "Jony", "Kass");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        for (Cliente cliente: clientes){
            System.out.println(cliente.toString());
        }

        int lastInex = clientes.size()-1;
        clientes.remove(lastInex);

        System.out.println("-");
        for (Cliente cliente: clientes){
            System.out.println(cliente.toString());
        }

        // Solicitar número de DNI por teclado
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de DNI del cliente: ");
        int dniBuscar = scanner.nextInt();

        // Buscar el cliente en la lista
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDNI() == dniBuscar) {
                clienteEncontrado = cliente;
                break;
            }
        }

        // Mostrar resultados
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado. Datos del cliente:");
            System.out.println(clienteEncontrado.toString());
        } else {
            System.out.println("Cliente no encontrado. Verifique el número de DNI.");
        }

        // Cerrar el scanner
        scanner.close();
        /*
        Un supermercado desea implementar un sistema, que le permita almacenar los datos de sus clientes y
        distintas facturas de las compras que los mencionados realicen. Para esto,
        necesita poder realizar operaciones de creación, consulta, eliminación o
        actualización de datos de  todos los clientes y sus respectivas facturas asociadas.

De cada cliente se registran:
dni,
nombre y apellido.

Por otro lado, las facturas que se generan cuando un cliente hace una compra contienen a un
cliente,
una lista de ítems
y el total de la compra.

De cada item o producto se guarda el
código,
nombre,
cantidad comprada
y costo unitario.

Dada la complejidad que posee el sistema, el Project Manager que dirige el proyecto ha decidido realizarlo en dos sprints,
donde cada uno de ellos tendrá como objetivo una entrega final de una serie de requerimientos.

Parte I

Se necesita:

1- Crear el modelo de clases clases que conforman, una factura, los cuales son: Cliente, Item, Factura.
2- Crear 3 clientes y guardarlos en una collection.
3- Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
4- Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
5- Solicitar por teclado un número de dni de un cliente para buscarlo.
En caso de que el cliente se encuentre en la lista, mostrar sus datos,
caso contrario, mostrar un mensaje que informe dicha situación.

         */
    }
}