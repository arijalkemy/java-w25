package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String ciudades[] = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio" };

        int temperaturas[][] = new int[10][2];
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int tempmenor = temperaturas[0][0];
        String ciudadmenor=  ciudades[0];
        int tempmayor = temperaturas[0][0];
        String ciudadmayor = ciudades[0];

        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 2; c++) {
                if (temperaturas[f][c]<tempmenor){
                    tempmenor = temperaturas[f][c];
                    ciudadmenor = ciudades[f];
                }
                if (temperaturas[f][c]>tempmayor){
                    tempmayor = temperaturas[f][c];
                    ciudadmayor = ciudades[f];
                }
            }
        }

        System.out.println("La mayor temperatura la tuvo "+ciudadmayor+" con "+tempmayor+"°C");
        System.out.println("La menor temperatura la tuvo "+ciudadmenor+" con "+tempmenor+"°C");
    }
}
