package org.example.src;

import java.util.*;

public class Clases {
    Set<String> aaas = new HashSet<>();

    public static void main(String[] args) {

        String ciudades[]= {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,26},{-10,35}};
        int ciudadTemperaturaMasAlta = 0;
        int ciudadTemperaturaMasBaja = 0;

        for (int i = 0; i < ciudades.length; i++){

            if (temperaturas[ciudadTemperaturaMasAlta][1] < temperaturas[i][1]){
                ciudadTemperaturaMasAlta = i;
            }

            if (temperaturas[ciudadTemperaturaMasBaja][0] > temperaturas[i][0]){
                ciudadTemperaturaMasBaja = i;
            }

        }

        System.out.println(ciudades[ciudadTemperaturaMasBaja]);
        System.out.println(ciudades[ciudadTemperaturaMasAlta]);
    }
}