package org.example;

public class Main {

    public static void main(String[] args) {
        String[] vectorCiudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Pablo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
        int[][] matrizTemperatura = {
                {-2, 33},
                {-3, 32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}
        };

        //minimo
        int minIndice = 0;
        int maxIndice = 0;
        int minTemp = matrizTemperatura[0][0];
        int maxTemp = matrizTemperatura[0][1];
        for (int i = 1; i < matrizTemperatura.length; i++) {
            if (matrizTemperatura[i][0] < minTemp) {
                minTemp = matrizTemperatura[i][0];
                minIndice = i;
            }
            if (matrizTemperatura[i][1] > maxTemp) {
                maxTemp = matrizTemperatura[i][1];
                maxIndice = i;
            }
        }

        System.out.println("La ciudad con menor temperatura fue " + vectorCiudades[minIndice]);
        System.out.println("La ciudad con mayor temperatura fue " + vectorCiudades[maxIndice]);

    }
}
