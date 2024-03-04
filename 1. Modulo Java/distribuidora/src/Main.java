
public class Main {
    public static void main(String[] args) {
    PracticaExcepciones practica = new PracticaExcepciones(0, 300);
    try {
        System.out.println(practica.dividir());
    } catch (ArithmeticException e) {
        throw new IllegalArgumentException("No se puede dividir por Cero ", e);
    } finally {
        System.out.println("Progrma finalizado");
    }

    }
}