package Ejercicios_Java;

public class Temperaturas_Globales {

    public static void main (String[] argv) {
        String[] ciudades = cargarCiudades();
        int[][] tempMinMax = cargarTemperaturas();
        int tamArrTemp = tempMinMax.length;

        int tempMin = tempMinMax[0][0], tempMax = tempMinMax[0][1];
        String ciudadTempMin = ciudades[0], ciudadTempMax = ciudades[0];

        for (int f = 0; f < tamArrTemp; f++) {
            for (int c = 0; c < 2; c++) {
                if(tempMinMax[f][c] < tempMin) {
                    tempMin = tempMinMax[f][c];
                    ciudadTempMin = ciudades[f];
                }

                if(tempMinMax[f][c] > tempMax) {
                    tempMax = tempMinMax[f][c];
                    ciudadTempMax = ciudades[f];
                }
            }
        }

        System.out.println("Ciudad con la temperatura minima " + ciudadTempMin + ": " + tempMin);
        System.out.println("Ciudad con la temperatura maxima " + ciudadTempMax + ": " + tempMax);
    }

    public static String[] cargarCiudades() {
        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        return ciudades;
    }

    public static int[][] cargarTemperaturas() {
        int[][] tempMinMax = {
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

        return tempMinMax;
    }
}
