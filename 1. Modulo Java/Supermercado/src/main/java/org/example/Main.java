package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        Cliente c1 = new Cliente(34123445L, "Agustin", "Espeche");
        Cliente c2 = new Cliente(34657123L, "Carla", "Olocco");
        Cliente c3 = new Cliente(31098927L, "Marina", "Berdu");

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        clientes.forEach(cliente -> System.out.println(cliente.getDni()));
        System.out.println();
        System.out.println("Ingrese el dni a eliminar:");
        Long dni = sc.nextLong();
        if (dni != null){
            clientes.remove(dni);
            clientes.forEach(cliente -> System.out.println(cliente.getDni()));
        }


        System.out.println("Ingrese dni a buscar:");
        Long dniCliente = sc.nextLong();
        for (Cliente c : clientes){
            if (c.getDni().equals(dniCliente)){
                System.out.println(c.getNombre() +" "+ c.getDni());
            }else {
                System.out.println("No se encuentra el cliente con el dni " + dniCliente);
            }
        }
    }
}