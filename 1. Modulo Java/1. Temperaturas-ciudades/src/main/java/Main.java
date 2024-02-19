
public class Main{

    public static void main(String[] args) {

        String ciudades[] = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int temperaturas[][] = new int[10][2];
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

        int temperatura_max = -100;
        int indice_temperatura_max = 0;

        int temperatura_min = 100;
        int indice_temperatura_min = 0;

        for (int i=0; i<10; i++){
            if(temperaturas[i][0] < temperatura_min){
                temperatura_min = temperaturas[i][0];
                indice_temperatura_min = i;
            }
            if(temperaturas[i][1] > temperatura_max){
                temperatura_max = temperaturas[i][1];
                indice_temperatura_max = i;
            }
        }

        System.out.println("La ciudad con la temperatura más baja es: " + ciudades[indice_temperatura_min] + " con " + temperatura_min + " grados");
        System.out.println("La ciudad con la temperatura más alta es: " + ciudades[indice_temperatura_max] + " con " + temperatura_max + " grados");

    }
}

