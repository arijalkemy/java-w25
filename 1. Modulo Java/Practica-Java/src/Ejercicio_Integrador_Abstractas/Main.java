package Ejercicio_Integrador_Abstractas;

public class Main {
    public static void main(String[] args) {
        Prototipo serie = new Prototipo(2, 1);
        for(int i = 0; i < 5; i++) {
            System.out.println("Siguiente valor de la serie: " + serie.nextValue());
        }
    }
}
