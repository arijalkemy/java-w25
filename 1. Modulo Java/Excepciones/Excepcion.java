package Excepciones;

public class Excepcion {
    

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            double cociente = b/a;
            System.out.println("El cociente es: "+cociente);

        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
