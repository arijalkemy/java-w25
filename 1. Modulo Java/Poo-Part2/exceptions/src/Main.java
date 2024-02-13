public class Main {
    public static void main(String[] args) {

        PracticaExcepciones excepciones = new PracticaExcepciones();

        try {
            System.out.println(excepciones.b/ excepciones.a);
        } catch (ArithmeticException exception){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}