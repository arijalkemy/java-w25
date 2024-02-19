package com.main;

public class Main {

    public static void main(String[] args) {
        //Vector
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        //Matriz
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int minTemp=0;
        int maxTemp=0;
        String ciudadMin="";
        String ciudadMax="";

        for(int f=0; f<ciudades.length;f++){
            for (int c=0; c<2;c++){
                if (temperaturas[f][c]<minTemp){
                    minTemp=temperaturas[f][c];
                    ciudadMin=ciudades[f];
                }
                if (temperaturas[f][c]>maxTemp){
                    maxTemp=temperaturas[f][c];
                    ciudadMax=ciudades[f];
                }
            }
        }
        System.out.println("Ciudad con mayor temperatura: "+ciudadMax+" "+maxTemp);
        System.out.println("Ciudad con menor temperatura: "+ciudadMin+" "+minTemp);
    }
}
