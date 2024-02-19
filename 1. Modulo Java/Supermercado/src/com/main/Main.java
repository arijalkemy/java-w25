package com.main;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Cliente cliente1 = new Cliente("123", "Daniela", "Restrepo");
        Cliente cliente2 = new Cliente("456", "Jonathan", "Pinilla");
        Cliente cliente3 = new Cliente("789", "Diana", "Bautista");
        Cliente cliente4 = new Cliente("098", "Manuel", "Valencia");

        /*Crear lista con clientes
        List<Cliente> clientes = List.of(cliente1,cliente2,cliente3,cliente4);
        List<Cliente> clientes1 = Arrays.asList(cliente1,cliente2,cliente3,cliente4);*/
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);


        Item leche = new Item("1","Leche",1,2500f);
        Item huevos = new Item("2","Huevos",1,10000f);
        Item avena = new Item("3","Avena",1,1000f);
        Item tomate = new Item("4","Tomate",1,500f);
        Item lechuga = new Item("5","Lechuga",1,1500f);
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(leche);
        items.add(huevos);
        items.add(avena);
        items.add(tomate);
        items.add(lechuga);

        ArrayList<Factura> facturas = new ArrayList<Factura>();

        String opcion = "";

        while (!opcion.equals("salir")){
            System.out.println("""
                    --- MENÚ ---

                    1. Mostrar los clientes.
                    2. Eliminar el último cliente.
                    3. Buscar por DNI.
                    4. Crear factura.
                    5. Crear cliente.
                    6. Ver facturas.

                    Escribe salir para terminar.
                    """);
            opcion = input.next().toLowerCase();

            switch (opcion){
                case "1" -> {
                    for (Cliente person : clientes){
                    System.out.println(person.toString());
                    }
                }
                case "2" -> {
                    if (!clientes.isEmpty()) {
                        clientes.remove(clientes.size() - 1);
                        System.out.println("Último cliente eliminado.");
                    } else {
                        System.out.println("No hay clientes para eliminar.");
                    }
                }
                case "3" -> {
                    System.out.println("Escriba el DNI a buscar: ");
                    String dni = input.next().toLowerCase();
                    Cliente foundClient = clientes.stream()
                            .filter(cliente -> cliente.getDni().equals(dni))
                            .findFirst()
                            .orElse(null);
                    if (foundClient != null) {
                        System.out.println(foundClient);
                    } else {
                        System.out.println("Cliente no encontrado.Registrelo");
                    }
                }
                case "4" -> {
                    System.out.println("Se necesita vincular el cliente.");
                    System.out.println("Escriba el DNI: ");
                    String dni = input.next().toLowerCase();
                    Cliente foundClient = clientes.stream()
                            .filter(cliente -> cliente.getDni().equals(dni))
                            .findFirst()
                            .orElse(null);
                    if (foundClient != null) {
                        System.out.println(foundClient);

                        ArrayList<Item> listCompras = new ArrayList<Item>();
                        ArrayList<Double> listPrecios = new ArrayList<Double>();
                        String itemsOpt = "";
                        while (!itemsOpt.equals("listo")) {
                            System.out.println("""
                                    --- Seleccione los Items ---
                                                
                                    1. Leche
                                    2. Huevos
                                    3. Avena
                                    4. Tomate
                                    5. Lechuga
                                                
                                    Escribe listo para terminar.
                                    """);
                            itemsOpt = input.next().toLowerCase();

                            switch (itemsOpt) {
                                case "1" ->  {
                                    Item itemFound = items.stream()
                                        .filter(item -> item.getCodigo().equals("1"))
                                        .findFirst()
                                        .orElse(null);
                                        listCompras.add(itemFound);
                                        listPrecios.add(itemFound.getPrecioUnitario());
                                }
                                case "2" ->  {
                                    Item itemFound = items.stream()
                                        .filter(item -> item.getCodigo().equals("2"))
                                        .findFirst()
                                        .orElse(null);
                                    listCompras.add(itemFound);
                                    listPrecios.add(itemFound.getPrecioUnitario());
                                }
                                case "3" ->  {
                                    Item itemFound = items.stream()
                                        .filter(item -> item.getCodigo().equals("3"))
                                        .findFirst()
                                        .orElse(null);
                                    listCompras.add(itemFound);
                                    listPrecios.add(itemFound.getPrecioUnitario());
                                }
                                case "4" ->  {
                                    Item itemFound = items.stream()
                                        .filter(item -> item.getCodigo().equals("4"))
                                        .findFirst()
                                        .orElse(null);
                                    listCompras.add(itemFound);
                                    listPrecios.add(itemFound.getPrecioUnitario());
                                }
                                case "5" ->  {
                                    Item itemFound = items.stream()
                                        .filter(item -> item.getCodigo().equals("5"))
                                        .findFirst()
                                        .orElse(null);
                                    listCompras.add(itemFound);
                                    listPrecios.add(itemFound.getPrecioUnitario());
                                }
                                case "listo" -> itemsOpt = "listo";
                                default -> System.out.println("Opcion invalida");
                            }
                        }

                        double totalPagar=0f;
                        for (Double precio : listPrecios){
                            totalPagar=totalPagar+precio;
                        }
                        Factura fact= new Factura(foundClient,listCompras,totalPagar);
                        facturas.add(fact);
                        System.out.println("Factura registrada");
                    } else {
                        System.out.println("Cliente no encontrado. Registrelo");
                    }
                }
                case "5" -> {
                    System.out.println("DNI: ");
                    String dni = input.next().toLowerCase();
                    System.out.println("Nombre: ");
                    String nombre = input.next().toLowerCase();
                    System.out.println("Apellido: ");
                    String apellido = input.next().toLowerCase();

                    Cliente foundClient = clientes.stream()
                            .filter(cliente -> cliente.getDni().equals(dni))
                            .findFirst()
                            .orElse(null);
                    if (foundClient != null) {
                        System.out.println("Cliente existente");
                    } else {
                        Cliente clt = new Cliente(dni, nombre, apellido);
                        clientes.add(clt);

                    }
                }
                case "6" -> {for (Factura factura : facturas){
                    System.out.println(factura.toString());
                }}

                case "salir" -> System.exit(0);
                default -> System.out.println("Opcion invalida");
             }
        }
    }
}
