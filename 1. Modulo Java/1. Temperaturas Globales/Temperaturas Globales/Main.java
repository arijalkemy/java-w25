public class Main {
    public static void main(String[] args) {
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

        int maxTemperature = Integer.MIN_VALUE;
        int minTemperature = Integer.MAX_VALUE;
        String ciudadMax = "";
        String ciudadMin = "";
        for(int i = 0; i < cities.length; i++){
            if(temperatures[i][0] < minTemperature){
                minTemperature = temperatures[i][0];
                ciudadMin = cities[i];
            }
            if(temperatures[i][1] > maxTemperature){
                maxTemperature = temperatures[i][1];
                ciudadMax = cities[i];
            }
        }

        System.out.println("La ciudad con mayor temperatura es "+ ciudadMax + " con " + maxTemperature + " grados");
        System.out.println("La ciudad con menor temperatura es "+ ciudadMin + " con " + minTemperature + " grados");
    }
}
