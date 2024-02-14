package org.clase06_02_24.ejercicio_supermercado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clienteList = new ArrayList<>(
                Arrays.asList(
                        new Cliente(2222222,"Jorge","Chavez"),
                        new Cliente(44321234,"Romina", "Castro"),
                        new Cliente(54645643, "Paolo", "Silvio")
                )
        );

        clienteList.forEach(System.out::println);

        System.out.println("-------------");

        clienteList.remove(2);

        clienteList.forEach(System.out::println);

        System.out.println("-------------");

        System.out.println("Ingrese el dni del cliente requerido");
        Scanner scanner = new Scanner(System.in);
        long dniBuscado = scanner.nextLong();
        Cliente clienteBuscado;
        try{
            clienteBuscado = clienteList.stream().filter(cliente -> cliente.dni == dniBuscado).findFirst().get();
        } catch (Exception e){
            throw new RuntimeException("No se encontro al cliente con el dni: " + dniBuscado);
        }
        System.out.println(clienteBuscado);
    }
}
