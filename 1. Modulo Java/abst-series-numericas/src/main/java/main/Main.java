package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Prototipo serie = null;

        System.out.println("Desea una serie numerica de :\n1. Dos numeros.\n2. Tres numeros");
        int elegirSerie = keyboard.nextInt();
        if (elegirSerie == 1) {
            serie = new SerieNumericaUno();
        } else if (elegirSerie == 2) {
            serie = new SerieNumericaDos();
        } else {
            System.out.println("Opción no válida");
            System.exit(0);
        }

        int flag;
        do {
            System.out.println("Elija una opción: \n1. Agregar el numero siguiente a la serie." +
                    " \n2. Reiniciar serie." +
                    " \n3. Ingresar un valor inicial.");
            int opc = keyboard.nextInt();
            switch (opc){
                case 1:{
                    System.out.println("El numero siguiente es: " + serie.numeroSiguiente());
                    break;
                }
                case 2:{
                    serie.reiniciarSerie();
                    break;
                }
                case 3:{
                    System.out.println("Escriba el numero inicial del que desea la serie:");
                    serie.establecerValorInicial(keyboard.nextInt());
                    break;
                }
                default:
                    System.out.println("Esta opción no es válida");
            }
            System.out.println("Desea continuar?: Marque 1 para SI. Marque 2 para NO");
            flag = keyboard.nextInt();
        } while (flag == 1);

    }
}