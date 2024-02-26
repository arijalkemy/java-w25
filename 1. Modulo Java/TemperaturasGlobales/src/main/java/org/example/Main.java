package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int[][] maxMin = new int[2][10];
        maxMin[0][0] = -2;
        maxMin[0][1] = -3;
        maxMin[0][2] = -8;
        maxMin[0][3] = 4;
        maxMin[0][4] = 6;
        maxMin[0][5] = 5;
        maxMin[0][6] = 0;
        maxMin[0][7] = -7;
        maxMin[0][8] = -1;
        maxMin[0][9] = -10;

        maxMin[1][0] = 33;
        maxMin[1][1] = 32;
        maxMin[1][2] = 27;
        maxMin[1][3] = 37;
        maxMin[1][4] = 42;
        maxMin[1][5] = 43;
        maxMin[1][6] = 39;
        maxMin[1][7] = 26;
        maxMin[1][8] = 31;
        maxMin[1][9] = 35;

        int indMax = 0;
        int indMin = 0;
        for (int i = 0; i < 10; i++) {
            if (maxMin[0][indMin] > maxMin[0][i]){
                indMin = i;
            }
            if (maxMin[1][indMax] < maxMin[1][i]){
                indMax = i;
            }
        }
        System.out.println("La ciudad mas fria es " + ciudades[indMin] +
                " con una temperatura de " + maxMin[0][indMin] + " grados" +
                "\nLa ciudad mas caliente es " + ciudades[indMax]+
                " con una temperatura de " + maxMin[1][indMax] + " grados");
    }
}