import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static String[] getCities() {
        System.out.println("Enter #ro of cities (>0)");
        int number_cities = sc.nextInt();
        if (number_cities < 1)
            return null;
        String[] cities = new String[number_cities];
        for (int i = 0; i < number_cities; i++) {
            System.out.println("Enter city #ro: " + i);
            cities[i] = sc.next();
        }
        return cities;
    }

    public static int[][] getTemperatures(String[] cities) {
        int[][] temperatures = new int[cities.length][2];
        for (int i = 0; i < cities.length; i++) {
            System.out.println("Enter min temperature of " + cities[i]);
            temperatures[i][0] = sc.nextInt();
            System.out.println("Enter max temperature of " + cities[i]);
            temperatures[i][1] = sc.nextInt();
            if (temperatures[i][0] > temperatures[i][1])
                return null;
        }
        return temperatures;
    }

    public static void searchMaxMin(String[] cities, int[][] temperatures) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        int max = Integer.MIN_VALUE;
        int max_index = -1;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][0] < min) {
                min = temperatures[i][0];
                min_index = i;
            }
            if (temperatures[i][1] > max) {
                max = temperatures[i][1];
                max_index = i;
            }
        }
        System.out.println("Mínimo");
        printMessage(cities, temperatures, min_index);
        System.out.println("Máximo");
        printMessage(cities, temperatures, max_index);
    }

    public static void printMessage(String[] cities, int[][] temperatures, int index_city) {
        System.out.println("City: " + cities[index_city] + " Min: " + temperatures[index_city][0] + " Max: " + temperatures[index_city][1]);
    }


    public static void main(String[] args) {
        String[] cities = getCities();
        if (cities == null) {
            System.out.println("Error getting cities");
            return;
        }
        int[][] temperatures = getTemperatures(cities);
        if (temperatures == null) {
            System.out.println("Error getting temperatures");
            return;
        }
        searchMaxMin(cities, temperatures);
    }
}