// Ejercicio 1

public class Main {
    public static void main(String[] args) {
        /* Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
        Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje
         “Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje “Programa finalizado” */

        PracticaExcepiones practicaExcepiones = new PracticaExcepiones();
        practicaExcepiones.calcular();
        /*
        Se ha producido un error
        Programa finalizado
        */

        /*Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el
         mensaje “Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el
         mensaje “No se puede dividir por cero”
         */
        practicaExcepiones.calcular2();
        /*
        java.lang.IllegalArgumentException: No se puede dividir por cero
        Programa finalizado
        */
    }
}