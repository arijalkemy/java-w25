public class Ejercicio2 {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        try {
            int aux = b/a;
        } catch (RuntimeException exception){
            throw new IllegalArgumentException("No se puede dividir por zero.");
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}
