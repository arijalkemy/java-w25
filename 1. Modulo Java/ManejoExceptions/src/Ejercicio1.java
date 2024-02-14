public class Ejercicio1 {
    public static void main(String[] args) {
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        //Código que arroja excepción
        try {
            int[] numeros = new int[5];
            numeros[5] = 10;
        } catch(RuntimeException exception) {
            System.out.println("ha habido un error: "+exception.getMessage());
        } finally {
            System.out.println(mensajeFinal);
        }
    }
}
