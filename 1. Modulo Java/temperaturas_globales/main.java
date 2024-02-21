

public class Main {

    public static void main(String[] args) {
        String[] ciudades = new String[]{"Londres", 
        "Madrid", 
        "Nueva York",
        "Buenos Aires",
        "Asuncion",
        "Sao Paulo",
        "Lima",
        "Santiago de Chile",
        "Lisboa",
        "Tokio"
    };

        Double temperaturas[][] = new Double[][]{
            {-2,33},
            {-3,32},
            {-8,27},
            {4,37},
            {6,42},
            {5,43},
            {0,39},
            {-7,26},
            {-1,31},
            {-10,35}
        };

        int indexMenor = 0;
        int indexMayor = 0;

        for (int i=1 ; i < temperaturas.length ; i++) {

            if (temperaturas[i][1] > temperaturas[indexMayor][1]) {
                indexMayor = i;
            } else if (temperaturas[i][1] < temperaturas[i][indexMenor]) {
                indexMenor = i;
            }

        }

        System.out.println("La menor temperatura la tuvo " + ciudades[indexMenor] + " con " + temperaturas[indexMenor][1]);
        System.out.println("La mayor temperatura la tuvo " + ciudades[indexMayor] + " con " + temperaturas[indexMayor][1]);
    }

}