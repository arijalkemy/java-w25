public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo",
                "Lima","Santiago de Chile","Lisboa","Tokio"};

        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int temperaturaMin = 100;
        String ciudadMinima = "";
        int temperaturaMax = 0;
        String ciudadMaxima = "";
        for (int i = 0; i < temperaturas.length; i++) {
            if(temperaturas[i][0]< temperaturaMin){
                temperaturaMin = temperaturas[i][0];
                ciudadMinima = ciudades[i];
            }
            if(temperaturas[i][1] > temperaturaMax){
                temperaturaMax = temperaturas[i][1];
                ciudadMaxima = ciudades[i];
            }
        }

        System.out.println("La temperatura mas baja fue en la ciudad de "+ciudadMinima+" y fue de: "+temperaturaMin+" grados.");
        System.out.println("La temperatura mas alta fue en la ciudad de "+ciudadMaxima+" y fue de "+temperaturaMax+" grados.");
    }
}
