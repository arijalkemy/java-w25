public class Main {
    public static void main(String[] args) {
        // Cities array
        String[] cities = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        // Temperatures matriz
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

        int tempMax = Integer.MAX_VALUE;
        int tempMin = Integer.MIN_VALUE;
        int indexMax = 0;
        int indexMin = 0;

        for (int i = 0; i < cities.length; i++) {
            int currentTempMin = temperatures[i][0];
            int currentTempMax = temperatures[i][1];

            if (currentTempMin < tempMin) {
                tempMin = currentTempMin;
                indexMin = i;
            }

            if (currentTempMax > tempMax) {
                tempMax = currentTempMax;
                indexMax = i;
            }
        }

        System.out.println("CITY WITH MAX TEMPERATURE: " + cities[indexMax] + " " + tempMax + "C°.");
        System.out.println("CITY WITH MIN TEMPERATURE: " + cities[indexMin] + " " + tempMin + "C°.");
    }
}
