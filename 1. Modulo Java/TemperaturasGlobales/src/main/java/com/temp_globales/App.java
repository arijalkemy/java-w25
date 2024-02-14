package com.temp_globales;

public class App 
{
    public static void main( String[] args )
    {
        String ciudades[] = new String[]{
            "Londres",
            "Madrid",
            "New York",
            "Buenos Aires",
            "Asunción",
            "São Paulo",
            "Lima",
            "Santiago de Chile",
            "Lisboa",
            "Tokio"
        };

        int temperaturas[][] = new int[][]{
            {-2,33},
            {-3,32},
            {-8,27},
            {4,37},
            {6,42},
            {5,43},
            {0,39},
            {-7,26},
            {-1,31},
            {-10,35}
        };

        int minValue = 0;
        int minIndex = 0;
        int maxValue = 0;
        int maxIndex = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < minValue) {
                minValue = temperaturas[i][0];
                minIndex = i;
            }
            if (temperaturas[i][1] > maxValue) {
                maxValue = temperaturas[i][1];
                maxIndex = i;
            }
        }
        System.out.println("El mínimo global y máximo global son, respectivamente: (" + minValue + ", " + maxValue + ")");
        System.out.println("La temperatura mínima es " + minValue + " y la ciudad es " + ciudades[minIndex]);
        System.out.println("La temperatura máxima es " + maxValue + " y la ciudad es " + ciudades[maxIndex]);
    }
}
