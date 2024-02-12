//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        String[] city = new String[10];
        int[][] temperatures =new int [10][2];

        city[0] = "Londres";
        city[1] = "Madrid";
        city[2] = "NY";
        city[3] = "Buenos Aires";
        city[4] = "Asuncion";
        city[5] = "Sao paolo";
        city[6] = "Lima";
        city[7] = "Chile";
        city[8] = "Lisboa";
        city[9] = "Tokio";

        temperatures[0][0] = -2 ;
        temperatures[0][1] = 33;
        temperatures[1][0] = -3;
        temperatures[1][1] = 32;
        temperatures[2][0] = -8;
        temperatures[2][1] = 27;
        temperatures[3][0] = 4;
        temperatures[3][1] = 37;
        temperatures[4][0] = 6;
        temperatures[4][1] = 42;
        temperatures[5][0] = 5;
        temperatures[5][1] = 43;
        temperatures[6][0] = 0;
        temperatures[6][1] = 39;
        temperatures[7][0] = -7;
        temperatures[7][1] = 26;
        temperatures[8][0] = -1;
        temperatures[8][1] = 31;
        temperatures[9][0] = -10;
        temperatures[9][1] = 35;

        getMaxAndMin(city,temperatures);
    }

    public  static  void getMaxAndMin(String[] cities, int[][]temperatures){
        int minTemperature, maxTemperature;
        String minCity="", maxCity ="";

        minTemperature=99;
        maxTemperature=0;

        for(int index=0; index< cities.length; index++){
            if (temperatures[index][0]<minTemperature) {
                minTemperature = temperatures[index][0];
                minCity = cities[index];
            }
            if (temperatures[index][1]>maxTemperature) {
                maxTemperature = temperatures[index][1];
                maxCity = cities[index];
            }
        }
        System.out.println("Min temperature "+minTemperature+" in city "+ minCity);
        System.out.println("Max temperature "+maxTemperature+" in city "+ maxCity);
    }
}