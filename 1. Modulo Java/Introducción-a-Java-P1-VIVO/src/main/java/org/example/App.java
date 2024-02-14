package org.example;

public class App 
{
    public static void main( String[] args )
    {
        String[] ciudades = {
                "Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo",
                "Lima","Santiago de Chile","Lisboa","Tokio"
        };
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int tempMinima = Integer.MAX_VALUE;
        int ciudadMinimaIndice = 0;
        int tempMaxima = Integer.MIN_VALUE;
        int ciudadMaximaIndice = 0;

        for (int f = 0; f < ciudades.length; f++) {
            int tempMinimaActual = temperaturas[f][0];
            if (tempMinimaActual < tempMinima) {
                tempMinima = tempMinimaActual;
                ciudadMinimaIndice = f;
            }
            int tempMaximaActual = temperaturas[f][1];
            if (tempMaximaActual > tempMaxima) {
                tempMaxima = tempMaximaActual;
                ciudadMaximaIndice = f;
            }
        }

        System.out.println("La ciudad " + ciudades[ciudadMinimaIndice] + " registra la menor temperatura (" + tempMinima + "°).");
        System.out.println("La ciudad " + ciudades[ciudadMaximaIndice] + " registra la mayor temperatura (" + tempMaxima + "°).");
    }
}
