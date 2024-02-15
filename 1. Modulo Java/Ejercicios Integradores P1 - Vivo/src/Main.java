/*
Agencia de turismo
Una agencia de viajes premia a sus viajeros con descuentos cuando desean adquirir algún paquete turístico, el cual
consiste en reservas de hotel, comida, boletos de viajes y transporte. Las reservas son almacenadas en localizadores,
los cuales contienen los datos del cliente, el total y la reserva o varias reservas dependiendo del producto
adquirido. Por tanto los descuentos se aplicarán cuando:

- Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total para futuras compras.
- Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte,
 recibirá un descuento del 10% del total de la factura.
- Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.

Al momento de generar el localizador se debe almacenar en una clase repositorio y se imprimirá el mismo con los
detalles de la compra.

Se requiere crear un repositorio cliente, para así poder buscar las reservas anteriores del cliente y aplicar
descuentos; en caso de no existir el cliente poder agregarlo al repositorio cliente.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientRepository repository = new ClientRepository();
        Client client = repository.getOrRegisterClient("Juan Perez");

        /*
        Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior,
        almacenar e imprimir el resultado.
        */
        Locator locator = new Locator(client);
        locator.addReservation(new HotelReservation(100));
        locator.addReservation(new TicketReservation(50));
        client.locators.add(locator);

        Locator locator1 = new Locator(client);
        locator1.addReservation(new HotelReservation(120));
        locator1.addReservation(new TicketReservation(20));
        client.locators.add(locator1);

        System.out.println(locator);
        System.out.println(locator1);

        Locator singleReservationLocator = new Locator(client);
        singleReservationLocator.addReservation(new HotelReservation(300));
        client.locators.add(singleReservationLocator);

        List<Locator> allLocators = new ArrayList<>(Arrays.asList(locator, locator1, singleReservationLocator));
        LocatorQueries queries = new LocatorQueries(allLocators);

        //Crear un localizador con una sola reserva para el mismo cliente.
        System.out.println("Locaciones después de agregar una sola reserva:");
        client.locators.forEach(System.out::println);

        //Verificar que los descuentos fueron aplicados.
        System.out.println("\nDescuentos aplicados:");
        client.locators.forEach(l -> {
            System.out.printf("Locacion para el cliente %s: Total sin descuento: %.2f, Total con descuento: %.2f%n",
                    l.client.name,
                    l.totalWithoutDiscount,
                    l.totalWithDiscount);
        });

        System.out.println("Número de locaciones: " + queries.soldLocatorsCount());
        System.out.println("Total numero de reservas: " + queries.totalReservationsCount());
        System.out.println("Reservas por tipo: " + queries.reservationsByType());
        System.out.println("Total de ventas: " + queries.totalSales());
        System.out.println("Promedio de ventas: " + queries.averageSales());

    }
}