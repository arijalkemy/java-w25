public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int temperaturaMin = temperaturas[0][0];
        int temperaturaMax = temperaturas[0][1];
        String ciudadMin = ciudades[0];
        String ciudadMax = ciudades[0];
        for (int i = 1; i < ciudades.length; i++) {
            int temperaturaMinActual = temperaturas[i][0];
            int temperaturaMaxActual = temperaturas[i][1];
            if (temperaturaMinActual < temperaturaMin) {
                temperaturaMin = temperaturaMinActual;
                ciudadMin = ciudades[i];
            }
            if (temperaturaMaxActual > temperaturaMax) {
                temperaturaMax = temperaturaMaxActual;
                ciudadMax = ciudades[i];
            }
        }
        System.out.println("La ciudad con temperatura maxima es "+ciudadMax+" con una temperatura de "+temperaturaMax);
        System.out.println("La ciudad con temperatura minima es "+ciudadMin+" con una temperatura de "+temperaturaMin);

    }
}
