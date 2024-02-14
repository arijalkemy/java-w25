public class Main {
    public static void main(String[] args) {
        String[] cityArray = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao pablo","Lima", "Santiago de Chile","Lisboa", "Tokyo"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}, {-10, 35}};

        int indexCityMin = 0;
        int indexCityMax = 0;

        for (int c = 0; c < cityArray.length; c++) {
            if (temperaturas[c][0] < temperaturas[indexCityMin][0]){
                indexCityMin = c;
           }

            if (temperaturas[c][0] > temperaturas[indexCityMax][0]){
                indexCityMax = c;
            }
        }

        System.out.println("Ciudad Min " + cityArray[indexCityMin] +
                " con: " + temperaturas[indexCityMin][0] + " grados");

        System.out.println("Ciudad Max " + cityArray[indexCityMax] +
         " con: " + temperaturas[indexCityMax][1] + " grados");
    }
}
