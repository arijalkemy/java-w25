package org.example;

public class ExerciseException {
    public static void main(String[] args) {
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";
        int[] numeros = new int[5];
        //Código que arroja excepción
        try {
            numeros[5] = 10;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            mensajeFinal = ex.getMessage();
        }
        finally {
            System.out.println("mensajeFinal = " + mensajeFinal);
        }


    }
}
