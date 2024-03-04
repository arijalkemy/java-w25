package com.company;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GuardaRopa guardaRopa = new GuardaRopa();

        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Guardar prendas");
            System.out.println("2. Mostrar prendas guardadas");
            System.out.println("3. Consultar prendas por número identificador");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la marca de la prenda:");
                    String marca = scanner.nextLine();
                    System.out.println("Ingrese el modelo de la prenda:");
                    String modelo = scanner.nextLine();
                    Prenda prenda = new Prenda(marca, modelo);
//                    esto de aquí se puede modificar por una lista normal
                    int numeroIdentificador = guardaRopa.guardarPrendas(Collections.singletonList(prenda));
                    System.out.println("Prenda guardada bajo el número identificador: " + numeroIdentificador);
                    break;
                case 2:
                    System.out.println("Prendas guardadas en el guardaropa:");
                    guardaRopa.mostrarPrendas();
                    break;
                case 3:
                    System.out.println("Ingrese el número identificador:");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
//                    devuelve las prendas asociadas por número de identificador
                    List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(numero);
                    if (prendasRecuperadas != null) {
                        System.out.println("Prendas recuperadas:");
                        for (Prenda p : prendasRecuperadas) {
                            System.out.println("Marca: " + p.getMarca() + ", Modelo: " + p.getModelo());
                        }
                    } else {
                        System.out.println("No se encontraron prendas para el número identificador proporcionado.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
