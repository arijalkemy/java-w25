package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Basic basico = new Basic("Juan Alberto Castaño", "234678", 180400, "123-321232-98");
        Ejecutivo ejecutivo = new Ejecutivo("Mariana Delgado", "947932", 950100, "009-480126-01");
        Cobrador cobrador = new Cobrador("Natasha Romanov", "682017", 12520300, "894-167980-45");
        ArrayList<Cliente> clienteList = new ArrayList<>(Arrays.asList(basico, cobrador, ejecutivo ));


        System.out.println("Escoja por favor que tipo de cliente es: ");
        System.out.println("1. Basic\n2. Cobrador\n3. Ejecutivo");
        Cliente cliente = clienteList.get(keyboard.nextInt() - 1);
        System.out.println("Que acción quiere realizar:");
        System.out.println("1. Retirar efectivo\n2. Pagar servicios\n3. Depositar\n4. Tranferencia\n5. Consultar saldo");
        int accion = keyboard.nextInt();

        switch (accion){
            case 1:{
                cliente.retirarEfectivo();
                break;
            }
            case 2:{
                cliente.pagarServicios();
                break;
            }
            case 3:{
                cliente.depositar();
                break;
            }
            case 4:{
                cliente.transferir();
                break;
            }
            case 5:{
                cliente.consultarSaldo();
                break;
            }
        }

    }
}