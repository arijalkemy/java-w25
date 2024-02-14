package org.example;

import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Cliente cli1 = new Cliente(39937158L,"Ignacio","Pedrosa");
        Cliente cli2 = new Cliente(40123456L,"Nicolas","Garcia");
        Cliente cli3 = new Cliente(93123456L,"Lucia","Kellerman");

        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3);

        for(Cliente c : listaClientes) {

            System.out.println("DNI: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());


        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese DNI de la persona a borrar:");
        Long dniBorrado = teclado.nextLong();
        System.out.println(dniBorrado);
        boolean bandera = false;



        for (Cliente c : listaClientes){
            if(c.getDni().equals(dniBorrado)){
                listaClientes.remove(c);
                bandera = true;
                break;
            }
        }

        if(!bandera) {
            System.out.println("No se encontro el cliente a borrar");
        }else{
            System.out.println("Cliente borrado");
        }




    }
}