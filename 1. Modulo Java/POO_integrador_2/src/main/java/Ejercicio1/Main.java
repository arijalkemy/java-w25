package Ejercicio1;

public class Main {
    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        try {
            //int aux = b/a;
            if (a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int aux = b/a;
        } catch (IllegalArgumentException exception) {

            exception.printStackTrace();
            exception.getMessage();
        } finally {
            System.out.println("Programa terminado.");
        }



    }
}