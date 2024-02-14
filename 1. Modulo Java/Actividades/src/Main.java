//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Ejercicio Temperaturas");

        String[] cuidades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        String cuidadMayor = "";
        String cuidadMenor = "";
        int tempMayor = 0;
        int tempMenor = 0;

        for (int i = 0; i < cuidades.length; i++) {
            if (tempMayor < temperaturas[i][1]) {
                tempMayor = temperaturas[i][1];
                cuidadMayor = cuidades[i];
            }
            if (tempMenor > temperaturas[i][0]) {
                tempMenor = temperaturas[i][0];
                cuidadMenor = cuidades[i];
            }
        }

        System.out.println("La menor temperatura la tuvo: "+ cuidadMenor + " con " + tempMenor + " ºC.");
        System.out.println("La mayor temperatura la tuvo: "+ cuidadMayor + " con " + tempMayor + " ºC.");
        }
    }
