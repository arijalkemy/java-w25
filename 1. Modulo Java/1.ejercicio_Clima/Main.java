package org.example;

public class Main {
    public static void main(String[] args) {
        String [] ciudades = { "Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio" };

        double[][] temperaturas = {
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

        String ciudadMayorTemperatura = "";
        String ciudadMenorTemperatura = "";
        double mayorTemp = Double.MIN_VALUE;
        double menorTemp = Double.MAX_VALUE;

        for(int i = 0;i < ciudades.length;i++ ){
            double tempMin = temperaturas[i][0];
            double tempMax = temperaturas[i][1];

            if(tempMax > mayorTemp){
                mayorTemp = tempMax;
                ciudadMayorTemperatura = ciudades[i];
            }

            if(tempMin < menorTemp){
                menorTemp = tempMin;
                ciudadMenorTemperatura = ciudades[i];
            }
        }

        System.out.println("Ciudad con la mayor temperatura: " + ciudadMayorTemperatura + " - Temperatura: " + mayorTemp + "°C");
        System.out.println("Ciudad con la menor temperatura: " + ciudadMenorTemperatura + " - Temperatura: " + menorTemp + "°C");
    }
}