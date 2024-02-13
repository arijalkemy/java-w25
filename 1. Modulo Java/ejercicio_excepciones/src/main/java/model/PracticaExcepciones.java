package model;

public class PracticaExcepciones {
    private int a, b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public double calcular() {
        if (this.a == 0)
            throw new IllegalArgumentException("No se puede dividir por cero");
        return (double) this.b / this.a;
    }
}
