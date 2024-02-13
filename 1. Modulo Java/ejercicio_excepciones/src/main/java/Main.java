import model.PracticaExcepciones;

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones calculo = new PracticaExcepciones();

        try {
            calculo.calcular();
        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}
