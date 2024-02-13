package org.example;

public class Main {
    public static void main(String[] args) {

        /* Se desea crear al menos 2 clases que extiendan de una clase prototipo, que genera un valor en función,
        a una serie progresiva. La clase prototipo contendrá tres métodos. El primero de los métodos es el encargado
        de devolver un número que corresponderá al valor siguiente a la serie progresiva. Otro método para reiniciar
        la serie, y un último que recibirá un valor que servirá para establecer el valor inicial de la serie. Las
        clases deben estar preparadas para recibir cualquier tipo de dato numérico no primitivo.

        Escenarios:
        Si se crea una serie de 2 cada vez que se llame el método valor siguiente devolverá:
        Primera vez 2
        Segunda vez 4
        Tercera vez 6
        Cuarta vez 8
        Así sucesivamente cada vez que se llama al método.

        Si por ejemplo se emplea el método para establecer un valor inicial 1, cada vez que se llame al método el valor
        siguiente devolverá:
        Primera vez 3
        Segunda vez 5
        Tercera vez 7
        Cuarta vez 9
        Así sucesivamente cada vez que se llama al método.

        De igual forma si es una serie de 3, cada vez que se llame al método el valor siguiente devolverá:
        Primera vez 3
        Segunda vez 6
        Tercera vez 9
        Cuarta vez 12
        Así sucesivamente cada vez que se llama al método.*/

        Prototype serieDos = new Prototype2();
        System.out.println(serieDos.getNextNumber()); // Imprime "2"
        System.out.println(serieDos.getNextNumber()); // Imprime "4"
        serieDos.setInitialValue(1);
        System.out.println(serieDos.getNextNumber()); // Imprime "3"
        System.out.println(serieDos.getNextNumber()); // Imprime "5"

        serieDos.resetSeries();

        // Prueba SerieTres
        Prototype serieTres = new Prototype3();
        System.out.println(serieTres.getNextNumber()); // Imprime 3
        System.out.println(serieTres.getNextNumber()); //  Imprime 6
        serieTres.setInitialValue(1);
        System.out.println(serieTres.getNextNumber()); // Imprime 4
        System.out.println(serieTres.getNextNumber()); // Imprime 7
    }

    /*Se plantea crear una clase con un método static llamado burbuja, que recibe un arreglo de enteros primitivos int[]
    y devuelve el arreglo, ordenado de forma ascendente.*/
    public static int[] burbuja(int[] array) {

        for (int i = 0; i < array.length; i++) { // 1 0 3 2 5
            for (int j = 0; j < array.length - 1; j++) { // 0 1 3 2
                if (array[j] > array[j + 1]) { // 1 > 0 //  2 > 5
                    int temp = array[j]; // 1 // 2
                    array[j] = array[j + 1]; // 1 = 0 // 2 = 5
                    array[j + 1] = temp; // 0 = 1 -> 0, 1 // 5 = 2 -> 2, 5
                }
            }
        }

        return array;
    }
}