public class App {
    public static void main(String[] args) throws Exception {
        String ciudades[] = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio" };

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

        int menorTemperatura = temperaturas[0][0];
        int menorTemperaturaIndice = 0;
        for (int f = 0; f < ciudades.length; f++) {
            if (menorTemperatura > temperaturas[f][0]) {
                menorTemperatura = temperaturas[f][0];
                menorTemperaturaIndice = f;
            }
        }
        System.out.println(String.format("La menor temperatura la tuvo %s, con %d C.", ciudades[menorTemperaturaIndice],
                menorTemperatura));

        int mayorTemperatura = temperaturas[0][0];
        int mayorTemperaturaIndice = 0;
        for (int f = 0; f < ciudades.length; f++) {
            if (mayorTemperatura < temperaturas[f][1]) {
                mayorTemperatura = temperaturas[f][1];
                mayorTemperaturaIndice = f;
            }
        }
        System.out.println(String.format("La mayor temperatura la tuvo %s, con %d C.", ciudades[mayorTemperaturaIndice],
                mayorTemperatura));
    }
}
