import java.util.ArrayList;
//Ejercicio grupal Introducción a Java 1
public class Main {
    public static void main(String[] args) {

        String[] cities = new String[10];
        cities[0]="Londres";
        cities[1]="Madrid";
        cities[2]="Nueva York";
        cities[3]="Buenos Aires";
        cities[4]="Asunción";
        cities[5]="São Paulo";
        cities[6]="Lima";
        cities[7]="Santiago de Chile";
        cities[8]="Lisboa";
        cities[9]="Tokio";

        int[][] matrixTemp = new int[10][2];

        matrixTemp[0][0]=-2;
        matrixTemp[0][1]=33;
        matrixTemp[1][0]=-3;
        matrixTemp[1][1]=32;
        matrixTemp[2][0]=-8;
        matrixTemp[2][1]=27;
        matrixTemp[3][0]=4;
        matrixTemp[3][1]=37;
        matrixTemp[4][0]=6;
        matrixTemp[4][1]=42;
        matrixTemp[5][0]=5;
        matrixTemp[5][1]=43;
        matrixTemp[6][0]=0;
        matrixTemp[6][1]=39;
        matrixTemp[7][0]=-7;
        matrixTemp[7][1]=26;
        matrixTemp[8][0]=-1;
        matrixTemp[8][1]=31;
        matrixTemp[9][0]=-10;
        matrixTemp[9][1]=35;

        int min = matrixTemp[0][0];
        int max = matrixTemp[0][1];
        int indexMin = 0;
        int indexMax = 0;

        for (int i = 0; i < matrixTemp.length; i++) {
            for (int j = 0; j < matrixTemp[i].length; j++) {
                if (matrixTemp[i][j] < min) {
                    min = matrixTemp[i][j];
                    indexMin = i;
                }
                else if (matrixTemp[i][j] > max) {
                        max = matrixTemp[i][j];
                        indexMax = i;
                }
            }
        }
        System.out.println(
                "La menor temperatura la tuvo " + cities[indexMin] + " con " + min + "ºC");
        System.out.println(
                "La mayor temperatura la tuvo " + cities[indexMax] + " con " + max + "ºC");
    }
}