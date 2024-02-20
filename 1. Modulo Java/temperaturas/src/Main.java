import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        String[] ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = new int[10][];

        temperaturas[0] = new int[]{-2, 33};
        temperaturas[1] = new int[]{-3, 32};
        temperaturas[2] = new int[]{-8, 27};
        temperaturas[3] = new int[]{4, 37};
        temperaturas[4] = new int[]{6, 42};
        temperaturas[5] = new int[]{5, 43};
        temperaturas[6] = new int[]{0, 39};
        temperaturas[7] = new int[]{-7, 26};
        temperaturas[8] = new int[]{-1, 31};
        temperaturas[9] = new int[]{-10, 35};

        LinkedList<Integer> a = new LinkedList<>();

        a.get(1);

        int min_temp = temperaturas[0][0];
        int max_temp = temperaturas[0][1];

        String min_ciudad = ciudades[0];
        String max_ciudad = min_ciudad;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < min_temp) {
                min_temp = temperaturas[i][0];
                min_ciudad = ciudades[i];
            }
            if (temperaturas[i][1] > max_temp) {
                max_temp = temperaturas[i][1];
                max_ciudad = ciudades[i];
            }
        }

        System.out.println("La minima temperatura es: " + min_temp + " en la ciudad de " + min_ciudad);

        System.out.println("La máxima temperatura es: " + max_temp + " en la ciudad de " + max_ciudad);
    }
}