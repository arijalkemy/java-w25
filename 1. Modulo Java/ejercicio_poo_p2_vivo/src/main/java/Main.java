import entity.PracticaExcepciones;

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try {
            practicaExcepciones.divide();
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}
