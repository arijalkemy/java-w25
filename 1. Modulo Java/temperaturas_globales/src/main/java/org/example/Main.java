package org.example;

public class Main {
    public static void main(String[] args) {

        String[] cityArray = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao pablo","Lima", "Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int max= temperaturas[0][0], min = temperaturas[0][1];
        String ciudadMax = cityArray[0], ciudadMin = cityArray[0];

        for (int t = 1; t< cityArray.length; t++){

            if( temperaturas[t][1] > max){
                max = temperaturas[t][1];
                ciudadMax = cityArray[t];
            }

            if( temperaturas[t][0] < min ){
                min = temperaturas[t][0];
                ciudadMin = cityArray[t];
            }

        }

        System.out.println("La tempreratura maxima es: " + max + ", ciudad: "+ ciudadMax);
        System.out.println("La temperatura minima es: " + min + ", ciudad: " + ciudadMin);
    }
}