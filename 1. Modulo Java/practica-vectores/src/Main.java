//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokyo"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int temperatureMin = Integer.MAX_VALUE;
        int temperatureMax = Integer.MIN_VALUE;
        String cityTemperatureMax = "";
        String cityTemperatureMin = "";

        for(int i = 0; i < cities.length; i++){

            if(temperatures[i][1] > temperatureMax){
                temperatureMax = temperatures[i][1];
                cityTemperatureMax = cities[i];
            }

            if(temperatures[i][0] < temperatureMin){
                temperatureMin = temperatures[i][0];
                cityTemperatureMin = cities[i];
            }

        }
        System.out.println("Ciudad de maxima temperatura: " + cityTemperatureMax + " " + temperatureMax);
        System.out.println("Ciudad de minima temperatura: " + cityTemperatureMin + " " + temperatureMin);
    }
}