package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid","Nueva York","Buenos Aires","Asunción","Sao Paulo","Lima",
       "Santiago de Chile","Lisboa","Tokyo"};

        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int temperaturaMenor = temperaturas[0][0];
        int temperaturaMayor = temperaturas[0][1];
        int tempMenorIndice = 0;
        int tempMayorIndice = 0;

        for(int i =0; i<temperaturas.length; i++){

            if(temperaturas[i][0]<temperaturaMenor){
                temperaturaMenor= temperaturas[i][0];
                tempMenorIndice = i;
            }
            if(temperaturas[i][1]>temperaturaMayor){
                temperaturaMayor= temperaturas[i][1];
                tempMayorIndice = i;
            }
        }

        System.out.println("La ciudad con menor temperatura es : "+ciudades[tempMenorIndice]+" "+temperaturaMenor);
        System.out.println("La ciudad con mayor temperatura es : "+ciudades[tempMayorIndice]+" "+temperaturaMayor);
    }
}
