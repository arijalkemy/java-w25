package org.example;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[]{
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int[] min = new int[2];
        int[] max = new int[2];
        for(int i = 0; i<10;i++){
            if(temperaturas[i][0] < min[1]){
                min[1] = temperaturas[i][0];
                min[0] = i;
            }
            if(temperaturas[i][1] > max[1]){
                max[1] = temperaturas[i][1];
                max[0] = i;
            }
        }

        System.out.println("La ciudad con menor temperatura es " + ciudades[min[0]] + ", con " + min[1] + "°C");
        System.out.println("La ciudad con mayor temperatura es " + ciudades[max[0]] + ", con " + max[1] + "°C");
    }
}