package Temperaturas;

public class Temperaturas {
    public static void main(String[] args) {
        String ciudades[] = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio" };
        int[][] temperaturas = { { -2, 33 }, { -3, 32 }, { -8, 27 }, { 4, 37 }, { 6, 42 }, { 5, 43 }, { 0, 39 },
                { -7, 26 }, { -1, 31 }, { -10, 35 } };

        int temperaturaMin = temperaturas[0][0];
        int temperaturaMax = temperaturas[0][1];
        String ciudadMax = ciudades[0];
        String ciudadMin = ciudades[0];

        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < temperaturaMin) {
                temperaturaMin = temperaturas[i][0];
                ciudadMin = ciudades[i];
            }
            if (temperaturas[i][1] > temperaturaMax) {
                temperaturaMax = temperaturas[i][1];
                ciudadMax = ciudades[i];
            }
        }

        System.out.println("La ciudad mas caliente fué: " + ciudadMax + " con " + temperaturaMax + " grados");
        System.out.println("La ciudad mas fria fué: " + ciudadMin + " con " + temperaturaMin + " grados");
    }
}
