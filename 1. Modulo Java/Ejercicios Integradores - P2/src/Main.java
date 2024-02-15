/*
Supermercado “El económico”

Un supermercado desea implementar un sistema, que le permita almacenar los datos de sus clientes y distintas facturas
de las compras que los mencionados realicen. Para esto,  necesita poder realizar operaciones de creación,
consulta, eliminación o actualización de datos de  todos los clientes y sus respectivas facturas asociadas.

De cada cliente se registran: dni, nombre y apellido. Por otro lado, las facturas que se generan cuando un cliente
hace una compra contienen a un cliente, una lista de ítems y el total de la compra. De cada item o producto se guarda
el código, nombre, cantidad comprada y costo unitario.

Dada la complejidad que posee el sistema, el Project Manager que dirige el proyecto ha decidido realizarlo en dos
sprints, donde cada uno de ellos tendrá como objetivo una entrega final de una serie de requerimientos.
*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerManagement customerManagement = new CustomerManagement();
        InvoiceManagement invoiceManagement = new InvoiceManagement(customerManagement);

        Customer customer1 = new Customer("12345", "Juan", "Perez");

        customerManagement.add(customer1);
        customerManagement.add(new Customer("123456", "Jhon", "Kennedy"));

        List<Item> items = new ArrayList<>();
        items.add(new Item("1", "Papas", 2, 600));
        items.add(new Item("2", "Gaseosa", 1, 1200));
        Invoice invoice = new Invoice(customer1, items);

        System.out.println("Total de la factura: " + invoice.getTotal());
        invoiceManagement.add(invoice);


    }
}