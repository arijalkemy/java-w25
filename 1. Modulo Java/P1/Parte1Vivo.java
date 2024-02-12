package IntroduccionJava;

import java.util.HashMap;
import java.util.Map;

public class Parte1Vivo {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokyo"};

        int[][] temperatures = {
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

        int[] results = determineHigherAndLower(temperatures);
        System.out.printf(
                "\nLa temperatura más alta fue en %s con %d grados celcius%n",
                cities[results[0]],
                temperatures[results[0]][1]
        );
        System.out.printf(
                "La temperatura más baja fue en %s con %d grados celcius",
                cities[results[1]],
                temperatures[results[1]][0]
        );

    }

    public static int[] determineHigherAndLower(int[][] temperatures){
        int higher = 0, lower = 0, indexLow = 0, indexHigh = 0;

        for(int i = 0; i < temperatures.length; i++){
            if(temperatures[i][1] > higher){
                higher = temperatures[i][1];
                indexHigh = i;
            }
            if(temperatures[i][0] < lower ){
                lower = temperatures[i][0];
                indexLow = i;
            }
        }

        return new int[]{indexHigh, indexLow};
    }
}