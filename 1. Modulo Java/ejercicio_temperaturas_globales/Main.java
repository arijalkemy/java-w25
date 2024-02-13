//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String ciudades[] = {"Londes", "Madrid", "New York", "Buenos Aires", "Asuncion", "Sao Pablo", "Lima", "Santiago de chile", "Lisboa", "Tokio"};
        int matrizTemperaturas[][] = {{-2,33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        System.out.println(ciudades.length);
        System.out.println(matrizTemperaturas.length);
        int minValueTemp = 0;
        int maxValueTemp = 0;
        int posMinTemp = 0;
        int posMaxTemp = 0;

        for (int i = 0; i< matrizTemperaturas.length; i++){
            int temp1 = 0;
            int temp2 = 0;
            temp1 = matrizTemperaturas[i][0];
            temp2 = matrizTemperaturas[i][1];

            if(temp1 < minValueTemp || i == 0) {
                posMinTemp = i;
                minValueTemp = temp1;
            }
            if(temp2 > maxValueTemp || i == 0) {
                posMaxTemp = i;
                maxValueTemp = temp2;
            }


        }
        System.out.println("La ciudad con menos temperatura fue " + ciudades[posMinTemp] + " con " + minValueTemp + " grados");
        System.out.println("La ciudad con mas temperatura fue " + ciudades[posMaxTemp] + " con " + maxValueTemp + " grados");
    }

}