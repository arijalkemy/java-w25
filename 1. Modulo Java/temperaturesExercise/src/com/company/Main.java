package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] vectorCiudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] matrizTemperatura = {{-2, 33}, {-3, 32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39},
                {-7,26},{-1,31},{-10,35}};

        int[] minimo = { 0, matrizTemperatura[0][0]};
        int[] maximo = { 0, matrizTemperatura[0][1]};

        for (int i = 1; i < matrizTemperatura.length; i++) {
            if (minimo[1] > matrizTemperatura[i][0]) {
                minimo[0] = i;
                minimo[1] = matrizTemperatura[i][0];
            }

            if (maximo[1] < matrizTemperatura[i][1]){
                maximo[0] = i;
                maximo[1] = matrizTemperatura[i][1];
            }
        }

        System.out.println("temperatura minima" + matrizTemperatura[minimo[0]][0] + " en " + vectorCiudades[minimo[0]]);
        System.out.println("temperatura maxima" + matrizTemperatura[maximo[0]][1] + " en " + vectorCiudades[maximo[0]]);
    }
}
