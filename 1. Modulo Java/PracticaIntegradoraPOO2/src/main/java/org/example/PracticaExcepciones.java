package src.main.java.org.example;

public class PracticaExcepciones {
    public PracticaExcepciones() {
    }

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    static int a = 0;
    static int b = 300;

    public static void main(String[] args) {
        cociente();
    }

    private static void cociente() {
        try{
            if(a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
        }
        catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
    }

}
