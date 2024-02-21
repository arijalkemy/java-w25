package Ejercicio_Ordenamiento;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 2, 9, 1};

        array = burbuja(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println("Posicion: " + i + ": " + array[i]);
        }
    }

    public static int[] burbuja(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int j = i;
            while(j != 0 && array[j] < array[j-1]) {
                int aux = array[j];
                array[j] = array[j-1];
                array[j-1] = aux;
                j--;
            }
        }
        return array;
    }
}
