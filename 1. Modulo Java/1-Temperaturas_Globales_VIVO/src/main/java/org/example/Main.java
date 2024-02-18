package org.example;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int indiceMaxima = 0;
        int indiceMinima = 0;

        for (int i = 1; i < ciudades.length; i++) {
            if (temperaturas[i][1] > temperaturas[indiceMaxima][1]) {
                indiceMaxima = i;
                System.out.println("Max" + indiceMaxima);
            }

            if (temperaturas[i][0] < temperaturas[indiceMinima][0]) {
                indiceMinima = i;
                System.out.println("Min" + indiceMinima);
            }
        }

        System.out.println("La ciudad con la temperatura más alta es " + ciudades[indiceMaxima] + " con " + temperaturas[indiceMaxima][1] + "°C");
        System.out.println("La ciudad con la temperatura más baja es " + ciudades[indiceMinima] + " con " + temperaturas[indiceMinima][0] + "°C");
    }
}