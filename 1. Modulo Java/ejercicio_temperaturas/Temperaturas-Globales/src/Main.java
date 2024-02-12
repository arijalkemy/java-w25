public class Main {
    public static void main(String[] args) {
        String[] vectorCiudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] matrizTemperatura = {
                {-2, 33}, {-3, 32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39},
                {-7,26},{-1,31},{-10,35}
        };

        int temperaturaMenor = matrizTemperatura[0][0];
        int temperaturaMayor= matrizTemperatura[0][0];
        String ciudadMenor="";
        String ciudadMayor="";

        for(int i = 0; i < vectorCiudades.length; i++) {
            for(int j = 0; j < 2; j++) {
                if(matrizTemperatura[i][j]<temperaturaMenor){
                   temperaturaMenor =  matrizTemperatura[i][j];
                   ciudadMenor = vectorCiudades[i];
                }
                if(matrizTemperatura[i][j]>temperaturaMayor){
                    temperaturaMayor=matrizTemperatura[i][j];
                    ciudadMayor=vectorCiudades[i];
                }
            }
        }

        System.out.println("La ciudad con menor temperatura es "+ciudadMenor+" con una temperatura de "+temperaturaMenor);
        System.out.println("La ciudad con mayor temperatura es "+ciudadMayor+" con una temperatura de "+temperaturaMayor);

    }

}