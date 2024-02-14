import java.util.Arrays;

public class Ejercicio1 {

    public static void main(String[] args) {
        int[] numeros = {1,8,2,4,76,32,12,87,4,23,23,8,32,54,21};

        int[] ordenados = burbuja(numeros);

        System.out.println(Arrays.toString(ordenados));

    }

    public static int[] burbuja(int[] array) {
        return Arrays.stream(array)
                .sorted()
                .toArray();
    }
}
