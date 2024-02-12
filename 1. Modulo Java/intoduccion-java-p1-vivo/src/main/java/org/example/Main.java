package org.example;

public class Main {
    public static void main(String[] args) {
        //---------------------------------------------------------------------------------|VARS|
        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción", "Säo Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = {
                {-2,-3,-8,4,6,5,0,-7,-1,-10},
                {33,32,27,37,42,43,39,26,31,35}
        };
        int tMaxResult = 0, tMinResult = 0, tMaxCount = temperaturas[1][0], tMinCount = temperaturas[0][0];
        //---------------------------------------------------------------------------------|PROCESS|
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                //temperatura mínima
                if(i == 0){
                    if (temperaturas[i][j] < tMinCount) {
                        tMinCount = temperaturas[i][j];
                        tMinResult = j;
                    }
                }
                //temperatura máxima
                else{
                    if (temperaturas[i][j] > tMaxCount) {
                        tMaxCount = temperaturas[i][j];
                        tMaxResult = j;
                    }
                }
            }
        }
        //---------------------------------------------------------------------------------|OUT|
        System.out.println("Noticia: la ciudad con la temperatura máxima es: "+ciudades[tMaxResult]+", y la que registra la temperatura más baja es: "+ciudades[tMinResult]);
    }
}