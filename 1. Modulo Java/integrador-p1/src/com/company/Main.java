package com.company;

import java.util.*;

public class Main {
    private static List<Cliente> clientes;
    public static void main(String[] args) {
        ///
        clientes = new ArrayList<Cliente>(Arrays.asList(
           new Cliente("123","Cristiano","Ronaldo"),
           new Cliente("456","Lionel","Messi"),
           new Cliente("789","Erling","Haaland")
        ));

        ///
        clientes.forEach(System.out::println);

        ///
        clientes.remove(0);

        ///
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese un numero de DNI:");

        String dni = scanner.next();

        buscarCliente(dni);
    }

    public static void buscarCliente(String dni){
        Optional<Cliente> cliente =  clientes.stream().filter(x -> x.getDni().equalsIgnoreCase(dni)).findFirst();

        if(cliente.isPresent()){
            System.out.println(cliente.get());
        }else {
            System.out.println("Cliente no se encuentra en el sistema");
        }
    }
}
