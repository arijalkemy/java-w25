package org.example;

public class Main {
    public static void main(String[] args) {
        String[] vectorCiudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] matrizTemperatura = {{-2, 33}, {-3, 32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39},
                {-7,26},{-1,31},{-10,35}};

        int minTemp = matrizTemperatura[0][0], maxTemp = matrizTemperatura[0][1]; //Valores inicio de temperatura
        String minCiudad = vectorCiudades[0], maxCiudad = vectorCiudades[0]; // Valores inicio de Ciudad

        for (int i = 0; i < matrizTemperatura.length; i++) {
            for (int j = 0; j < matrizTemperatura[0].length; j++) {
                if (matrizTemperatura[i][j] < minTemp){
                    minTemp = matrizTemperatura[i][j];
                    minCiudad = vectorCiudades[i];
                }
                if (matrizTemperatura[i][j] > maxTemp){
                    maxTemp = matrizTemperatura[i][j];
                    maxCiudad = vectorCiudades[i];
                }
            }
        }

        System.out.println("La menor temperatura fue de: " + minTemp + " en " + minCiudad);
        System.out.println("La mayor temperatura fue de: " + maxTemp + " en " + maxCiudad);
    }
}