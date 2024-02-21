package Ejercicios_Java;

public class Main3 {
    public static void main(String[] args) {
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        try {
            //Código que arroja excepción
            int[] numeros = new int[5];
            numeros[5] = 10;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(mensajeFinal);
        }

    }
}
