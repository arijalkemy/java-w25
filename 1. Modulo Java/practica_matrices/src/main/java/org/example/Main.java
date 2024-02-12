package org.example;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio" };

        int [][] temperaturas = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35},
        };

        int indiceMenor = 0;
        int indiceMayor = 0;
        for (int i= 1 ; i < ciudades.length; i++){
            if( temperaturas[i][0]  < temperaturas[indiceMenor][0]) indiceMenor = i;
            if( temperaturas[i][1]  > temperaturas[indiceMayor][1]) indiceMayor = i;

        }

        System.out.println("Ciudad con menor temperatura "+ ciudades[indiceMenor] + " fue de " + temperaturas[indiceMenor][0]);
        System.out.println("Ciudad con mayor temperatura "+ ciudades[indiceMayor]  + " fue de " + temperaturas[indiceMayor][1]);
    }
}