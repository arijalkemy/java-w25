import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class TemGlobal {

    public static void main(String[] args) {


        int tempMaximo=0;
        int tempMinimo=0;
        String ciudadMaxima ="";
        String ciudadMinima = "";


        String [] ciudades =  {"Londres", "Madrid","Nueva York","Buenos Aires","Asunción","São Paulo", "Lima","Santiago de Chile",
        "Lisboa","Tokio"};

        int[][] temperatura = {{-2,33},{-3,32}, {-8, 27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        for (int i = 0; i < temperatura.length; i++) {


            tempMaximo = Math.max(tempMaximo,temperatura[i][1]);
            tempMinimo = Math.min(tempMinimo,temperatura[i][0] );


            if (tempMaximo > temperatura[i][1] ){

                ciudadMinima = ciudades[i];

            } else if (tempMinimo < temperatura[i][0]) {

                ciudadMaxima = ciudades[i];
            }

        }

        System.out.println("Ciudad maxima " + ciudadMaxima + "  Temperatura Maxima " + tempMaximo + " Ciudad minima " + ciudadMinima + "  Temperatura Minima " + tempMinimo);
    }
}
