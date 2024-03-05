package org.example;

public class Main {
    public static void main(String[] args) {
        String ciudad[] = new String[10];
        ciudad[0] = "Londres";
        ciudad[1] = "Madrid";
        ciudad[2] = "Nueva York";
        ciudad[3] = "Buenos Aires";
        ciudad[4] = "Asunción";
        ciudad[5] = "San Pablo";
        ciudad[6] = "Lima";
        ciudad[7] = "Santiago de Chile";
        ciudad[8] = "Lisboa";
        ciudad[9] = "Tokio";

        int temperaturas[][] = new int[10][2];
        temperaturas[0][0]=-2;
        temperaturas[0][1]=-33;
        temperaturas[1][0]=-3;
        temperaturas[1][1]=32;
        temperaturas[2][0]=-8;
        temperaturas[2][1]=27;
        temperaturas[3][0]=4;
        temperaturas[3][1]=37;
        temperaturas[4][0]=6;
        temperaturas[4][1]=42;
        temperaturas[5][0]=5;
        temperaturas[5][1]=43;
        temperaturas[6][0]=0;
        temperaturas[6][1]=39;
        temperaturas[7][0]=-7;
        temperaturas[7][1]=26;
        temperaturas[8][0]=-1;
        temperaturas[8][1]=31;
        temperaturas[9][0]=-10;
        temperaturas[9][1]=35;

        int temperaturaMinima = Integer.MAX_VALUE;
        int temperaturaMaxima = Integer.MIN_VALUE;
        String ciudadCalurosa = null;
        String ciudadFria = null;

        for (int columna = 0; columna < 2; columna++) {
            for (int fila = 0; fila < 10; fila++) {
                if (temperaturas[fila][1]>temperaturaMaxima){
                    temperaturaMaxima = temperaturas[fila][1];
                    ciudadCalurosa = ciudad[fila];
                }
                if (temperaturas[fila][0]<temperaturaMinima){
                    temperaturaMinima = temperaturas[fila][0];
                    ciudadFria = ciudad[fila];
                }
            }
        }
        System.out.println("La menor tempratura la tuvo "+ciudadFria+", con "+temperaturaMinima+" °C.");
        System.out.println("La mayor tempratura la tuvo "+ciudadCalurosa+", con "+temperaturaMaxima+" °C.");
    }
}