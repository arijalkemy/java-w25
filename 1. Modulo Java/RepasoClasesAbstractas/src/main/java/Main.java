public class Main {
    public static void main(String[] args) {
        Serie serie1 = new Serie1();
        Serie serie2 = new Serie2();
        Serie serie3 = new Serie3();

        ejecutarSerie(serie1);
        ejecutarSerie(serie2);
        ejecutarSerie(serie3);

    }

    public static void ejecutarSerie(Serie serie){
        System.out.println("-----------------------------");
        for (int i = 0; i < 4; i++) {
            serie.siguiente();
            System.out.println(serie.getSerie());
        }
        serie.reiniciar();
        System.out.println("Reniniciando: "+ serie.getSerie());
    }
}
