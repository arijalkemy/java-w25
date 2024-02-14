package entity;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public int divide() {
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return b / a;

    }
}
