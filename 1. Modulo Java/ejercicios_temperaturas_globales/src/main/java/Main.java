public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid","Nueva York","Buenos Aires","Asuncion","Sao paulo","Lima", "Santiago de chile", "Lisboa", "Tokio"};

        int[][] temperaturas = new int[10][2];
        temperaturas[0][0] = -2;
        temperaturas[1][0] = -3;
        temperaturas[2][0] = -8;
        temperaturas[3][0] = 4;
        temperaturas[4][0] = 6;
        temperaturas[5][0] = 5;
        temperaturas[6][0] = 0;
        temperaturas[7][0] = -7;
        temperaturas[8][0] = -1;
        temperaturas[9][0] = -10;

        temperaturas[0][1] = 33;
        temperaturas[1][1] = 32;
        temperaturas[2][1] = 27;
        temperaturas[3][1] = 37;
        temperaturas[4][1] = 42;
        temperaturas[5][1] = 43;
        temperaturas[6][1] = 39;
        temperaturas[7][1] = 26;
        temperaturas[8][1] = 31;
        temperaturas[9][1] = 35;

        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        int ciudadMax = 0;
        int ciudadMin = 0;

        for (int i = 0; i < 10; i++) {
            if (maximo < temperaturas[i][1]) {
                maximo = temperaturas[i][1];
                ciudadMax = i;
            }
            if (minimo > temperaturas[i][0]) {
                minimo = temperaturas[i][0];
                ciudadMin = i;
            }
        }

        System.out.println("La ciudad con temperatura máxima es: " + ciudades[ciudadMax]);
        System.out.println("La ciudad con temperatura mínima es: " + ciudades[ciudadMin]);
    }
}
