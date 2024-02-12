package org.example;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.model.Item;
import org.example.repository.CustomerRepository;
import org.example.repository.ICrudRepository;
import org.example.service.InvoiceService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ICrudRepository<Customer> customerRepository = new CustomerRepository(
                new ArrayList<>(List.of(
                    new Customer("12345678", "John", "Doe"),
                    new Customer("87654321", "Jane", "Doe"),
                    new Customer("91474389", "Santi", "Jara")
                    ))
        );
        InvoiceService invoiceService = new InvoiceService(customerRepository);

        customerRepository.add(new Customer("12345677", "Juan", "Doe"));
        customerRepository.deleteById("12345677");
        customerRepository.update(new Customer("12345678", "Juanchito", "Dou"), "12345678");
        printList(customerRepository.findAll());

        invoiceService.add(
                new Invoice("1", new Customer("777","Santi","Jara"), new ArrayList<>(
                    List.of(new Item("1", "Item 1", 100.0),
                            new Item("2", "Item 2", 200.0))
                ))
        );

        printList(invoiceService.getInvoiceList());
        System.out.println("Total invoice cost: " + invoiceService.getInvoiceList().get(0).getTotalPrice());
        printList(customerRepository.findAll());

    }
    public static void printList(List<?> list) {
        System.out.println("List of " + list.get(0).getClass().getSimpleName()
                + "s with " + list.size() + " elements.");
        list.forEach(System.out::println);
    }
}