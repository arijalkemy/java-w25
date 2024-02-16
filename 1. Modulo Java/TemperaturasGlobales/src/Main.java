//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39},
                {-7,26},{-1,31},{-10,35}};

        int minimo = temperaturas[0][0];
        int maximo = temperaturas[0][1];
        int indexMax = 0;
        int indexMin = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < minimo){
                minimo = temperaturas[i][0];
                indexMin = i;
            }
            if (temperaturas[i][1] > maximo){
                maximo = temperaturas[i][1];
                indexMax = i;
            }
        }

        System.out.println("La mayor temperatura la tuvo " + ciudades[indexMax] + ", con " + maximo + "ºC");
        System.out.println("La menor temperatura la tuvo " + ciudades[indexMin] + ", con " + minimo + "ºC");

    }
}