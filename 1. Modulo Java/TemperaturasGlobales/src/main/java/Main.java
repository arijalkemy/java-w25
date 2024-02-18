public class Main {
    public static void main(String[] args) {
        String minTempCity = "";
        String maxTempCity = "";
        int minTemp = 100;
        int maxTemp = -100;
        String[] cities = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio",
        };
        int[][] temperatures = {
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

        for (int r = 0; r < temperatures.length; r++) {
            for (int c = 0; c < temperatures[0].length; c++) {
                if (temperatures[r][c] < minTemp) {
                    minTemp = temperatures[r][c];
                    minTempCity = cities[r];
                }
                if (temperatures[r][c] > maxTemp) {
                    maxTemp = temperatures[r][c];
                    maxTempCity = cities[r];
                }
            }
        }

        System.out.println("\n----------------------------");
        System.out.printf("La ciudad con Menor temperatura es %s con %d °C\n", minTempCity, minTemp);

        System.out.println("\n----------------------------");
        System.out.printf("La ciudad con Mayor temperatura es %s con %d °C\n", maxTempCity, maxTemp);
    }
}
