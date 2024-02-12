package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String ciudades[] = new String[10];
        int temperaturas [][] = new int[10][2];

        ciudades [0] = "Londres";
        ciudades [1] = "Madrid";
        ciudades [2] = "Nueva York";
        ciudades [3] = "Buenos Aires";
        ciudades [4] = "Asuncion";
        ciudades [5] = "Sao Paulo";
        ciudades [6] = "Lima";
        ciudades [7] = "Santiago de Chile";
        ciudades [8] = "Lisboa";
        ciudades [9] = "Tokio";

        temperaturas [0][0] = -2;
        temperaturas [0][1] = 33;
        temperaturas [1][0] = -3;
        temperaturas [1][1] = 32;
        temperaturas [2][0] = -8;
        temperaturas [2][1] = 27;
        temperaturas [3][0] = 4;
        temperaturas [3][1] = 37;
        temperaturas [4][0] = 6;
        temperaturas [4][1] = 42;
        temperaturas [5][0] = 5;
        temperaturas [5][1] = 43;
        temperaturas [6][0] = 0;
        temperaturas [6][1] = 39;
        temperaturas [7][0] = -7;
        temperaturas [7][1] = 26;
        temperaturas [8][0] = -1;
        temperaturas [8][1] = 31;
        temperaturas [9][0] = -10;
        temperaturas [9][1] = 35;

        System.out.println("temperaturas.length = ");

        int max = 0;
        int min = 0;
        int flagVectorMax = 0;
        int flagVectorMin = 0;

        for (int i = 0; i < temperaturas.length; i++){
            for (int x = 0; x < 2; x++){
                if (temperaturas[i][x] > max){
                    max = temperaturas [i][x];
                    flagVectorMax = i;
                } else if (temperaturas[i][x] < min) {
                    min = temperaturas [i][x];
                    flagVectorMin = i;
                }
            }
        }

        System.out.println("Ciudad con temp mas alta: " + ciudades[flagVectorMax]);
        System.out.println("Ciudad con temp mas alta: " + ciudades[flagVectorMin]);



    }
}