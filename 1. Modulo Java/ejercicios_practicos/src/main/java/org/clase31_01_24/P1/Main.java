package org.clase31_01_24.P1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        Integer temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        String ciudadConTemperaturaMasAlta = null;
        Integer temperaturaAlta = 0;

        String ciudadConTemperaturaMasBaja = null;
        Integer temperaturaBaja = 0;

        for (int i = 0; i < ciudades.length; i++) {
            if(temperaturas[i][1]>temperaturaAlta){
                temperaturaAlta = temperaturas[i][1];
                ciudadConTemperaturaMasAlta = ciudades[i];
            }
        }

        for (int i = 0; i < ciudades.length; i++) {
            if(temperaturas[i][0]<temperaturaBaja){
                temperaturaBaja = temperaturas[i][0];
                ciudadConTemperaturaMasBaja = ciudades[i];
            }
        }

        System.out.println("La ciudad con la temperatura mas alta es: " + ciudadConTemperaturaMasAlta + " con " + temperaturaAlta);
        System.out.println("La ciudad con la temperatura mas baja es: " + ciudadConTemperaturaMasBaja + " con " + temperaturaBaja);

    }


}
