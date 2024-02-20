public class Main {
    public static void main(String[] args) {

        String[] ciudades = {
              "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int [][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7,26},
                {-1, 31},
                {-10, 35}
        };

        int tempMin = 0;
        int indexTempMin = 0;
        int tempMax = 0;
        int indexTempMax = 0;

        for (int i = 0; i < temperaturas.length; i++){
            if (temperaturas[i][0] < tempMin) {
                tempMin = temperaturas[i][0];
                indexTempMin = i;
            }
            if (temperaturas[i][1] > tempMax) {
                tempMax = temperaturas[i][1];
                indexTempMax = i;
            }
        }
        System.out.println("La ciudad con la temperatura mas baja es: "+ciudades[indexTempMin]+" con "+tempMin+"C");
        System.out.println("La ciudad con la temperatura mas alta es: "+ciudades[indexTempMax]+" con "+tempMax+"C");
    }
}