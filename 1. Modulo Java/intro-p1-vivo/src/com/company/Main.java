package com.company;

public class Main {

    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39},
                {-7,26},{-1,31},{-10,35}};

        int minimo = Integer.MAX_VALUE;
        int maximo = Integer.MIN_VALUE;
        int minIndex=0, maxIndex = 0;

        for (int i = 1; i < temperaturas.length; i++) {
            if (minimo > temperaturas[i][0]) {
                minIndex = i;
                minimo = temperaturas[i][0];

            }

            if (maximo < temperaturas[i][1]){
                maxIndex = i;
                maximo = temperaturas[i][1];
            }
        }

        System.out.println("La temperatura minima es: " + minimo + " en " + ciudades[minIndex]);
        System.out.println("La temperatura maxima es: " + maximo + " en " + ciudades[maxIndex]);
    }
}
