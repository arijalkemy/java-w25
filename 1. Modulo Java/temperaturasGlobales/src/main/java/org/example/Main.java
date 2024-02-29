package org.example;

public class Main {
    public static void main(String[] args) {
        String[] vectorCiudades = new String[10];
        vectorCiudades[0] = "Londres";
        vectorCiudades[1] = "Madrid";
        vectorCiudades[2] = "Nueva York";
        vectorCiudades[3] = "Buenos Aires";
        vectorCiudades[4] = "Asunción";
        vectorCiudades[5] = "São Paulo";
        vectorCiudades[6] = "Lima";
        vectorCiudades[7] = "Santiago de Chile";
        vectorCiudades[8] = "Lisboa";
        vectorCiudades[9] = "Tokio";

        double[][] temperaturas = new double [10][2];
        temperaturas[0][0] = -2 ;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        String ciudadMin = vectorCiudades[0];
        String ciudadMax = vectorCiudades[0];
        double tempMin = temperaturas[0][0];
        double tempMax = temperaturas[0][0];

        for (int f=0; f < 10; f++){
            for (int c = 0; c <= 1; c++) {
                if (temperaturas[f][c] < tempMin) {
                    tempMin = temperaturas[f][c];
                    ciudadMin = vectorCiudades[f];
                }
                if (temperaturas[f][c] > tempMax){
                    tempMax = temperaturas[f][c];
                    ciudadMax = vectorCiudades[f];
                }
            }
        }

        System.out.println("La ciudad de " + ciudadMin + " es la ciudad con la temperatura mínima de: " + tempMin);
        System.out.println("La ciudad de " + ciudadMax + " es la ciudad con la temperatura máxima de: " + tempMax);
    }
}