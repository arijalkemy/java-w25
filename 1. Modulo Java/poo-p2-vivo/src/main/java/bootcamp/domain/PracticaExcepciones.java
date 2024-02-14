package bootcamp.domain;

public class PracticaExcepciones {

    private Integer a;
    private Integer b;

    public PracticaExcepciones(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }

    public double calcularCociente() {
        return b / a;
    }

}
