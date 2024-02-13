import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Ejercicio grupal - Intro a Java");

        String[] ciudades = new String[10];
        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asunción";
        ciudades[5]="São Paulo";
        ciudades[6]="Lima";
        ciudades[7]="Santiago de Chile";
        ciudades[8]="Lisboa";
        ciudades[9]="Tokio";

        int matrisTemp[][] = new int[10][2];

        matrisTemp[0][0]=-2;
        matrisTemp[0][1]=33;
        matrisTemp[1][0]=-3;
        matrisTemp[1][1]=32;
        matrisTemp[2][0]=-8;
        matrisTemp[2][1]=27;
        matrisTemp[3][0]=4;
        matrisTemp[3][1]=37;
        matrisTemp[4][0]=6;
        matrisTemp[4][1]=42;
        matrisTemp[5][0]=5;
        matrisTemp[5][1]=43;
        matrisTemp[6][0]=0;
        matrisTemp[6][1]=39;
        matrisTemp[7][0]=-7;
        matrisTemp[7][1]=26;
        matrisTemp[8][0]=-1;
        matrisTemp[8][1]=31;
        matrisTemp[9][0]=-10;
        matrisTemp[9][1]=35;

        int min = matrisTemp[0][0];
        int max = matrisTemp[0][1];
        int indiceMin = 0;
        int indiceMax = 0;

        for (int i = 0; i < matrisTemp.length; i++) {

            for (int j = 0; j < matrisTemp[i].length; j++) {

                if (j == 0) {
                    if (matrisTemp[i][j] < min) {
                        min = matrisTemp[i][j];
                        indiceMin = i;
                    }
                } else {
                    if (matrisTemp[i][j] > max) {
                        max = matrisTemp[i][j];
                        indiceMax = i;
                    }
                }
            }
        }
        System.out.println(
                "La menor temperatura la tuvo " + ciudades[indiceMin] + " con " + min);
        System.out.println(
                "La mayor temperatura la tuvo " + ciudades[indiceMax] + " con " + max);
        System.out.println("Que buen equipo!! Gracias Team!!");
    }
}