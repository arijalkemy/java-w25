public class Main {
    public static void main(String[] args) {
    int temperaturas[][] = new int [10][2];
    String ciudades[] = new String [10];

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "Sao paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;
        int min = 0;
        int max = 0;
        String ciudad_max = "";
        String ciudad_min = "";
        for ( int i = 0; i<10; i++) {
            if(min > temperaturas[i][0]) {
                min = temperaturas[i][0];
                ciudad_min = ciudades[i];
            }
            if(max < temperaturas[i][1]) {
                max = temperaturas[i][1];
                ciudad_max = ciudades[i];
            }
           /* for ( int j = 0; j<2; j++) {
                if(temperaturas[i][j] < min) {
                    min = temperaturas[i][j];
                    ciudad_min = ciudades[i];
                }

                if(temperaturas[i][j] > max) {
                    max = temperaturas[i][j];
                    ciudad_max = ciudades[i];
                }
            }*/
        }

        System.out.println("Temp MIN: " + ciudad_min + " " + min);
        System.out.println("Temp MAX: " + ciudad_max + " " + max);

    }
}