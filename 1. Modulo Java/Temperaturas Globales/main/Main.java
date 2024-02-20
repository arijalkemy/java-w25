package main;

public class Main {
    public static void main(String[] args) {

        String ciudades[] = new String[10];

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int menorTemperatura = temperaturas[0][0];
        int mayorTemperatura = temperaturas[0][1];
        String ciudad = "";
        for (int f = 0; f < temperaturas.length; f++) {
            if (temperaturas[f][0] <= menorTemperatura){
                menorTemperatura = temperaturas[f][0];
                ciudad = ciudades[f];
            }
        }
        System.out.println("La menor temperatura es:" + menorTemperatura + " en la ciudad de " + ciudad);

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][1] >= mayorTemperatura){
                mayorTemperatura = temperaturas[i][1];
                ciudad = ciudades[i];
            }
        }
        System.out.println("La mayor temperatura es:" + mayorTemperatura + " en la ciudad de " + ciudad);
    }

}
