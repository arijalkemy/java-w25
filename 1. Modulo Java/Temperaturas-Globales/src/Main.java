public class Main {
    public static void main(String[] args) {
        String ciudades[] = new String[]{
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"
        };

        int temperaturas[][] = new int[][]{
                {-2, 33}, {-3, 32}, {-8, 27},
                {4, 37}, {6, 42}, {5, 43},
                {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}
        };

        int temperaturaMinima = 100, temperaturaMaxima = -100;
        int indexMinino = -1, indexMaximo = -1;
        for (int i = 0; i<10; i++) {
            if (temperaturas[i][0] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i][0];
                indexMinino = i;
            }

            if (temperaturas[i][1] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i][1];
                indexMaximo = i;
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudades[indexMinino] + " con " + temperaturaMinima);
        System.out.println("La mayor temperatura la tuvo " + ciudades[indexMaximo] + " con " + temperaturaMaxima);
    }
}