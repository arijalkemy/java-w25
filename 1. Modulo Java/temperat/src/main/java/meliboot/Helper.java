package meliboot;

import java.util.List;

public class Helper {
    /**
     * Obtiene el indice del elemento con menor valor en un array
     *
     * @param array arreglo con números
     * @return int
     */
    public static int GetIndexWithLessValue(int[] array) {
        int less = Integer.MAX_VALUE;
        int indexValueWithLessValue = 0;

        for (int index = 0; index < array.length; index++) {
            if (array[index] < less) {
                less = array[index];
                indexValueWithLessValue = index;
            }
        }
        return indexValueWithLessValue;
    }

    /**
     * Obtiene el indice del elemento con mayor valor en un array
     *
     * @param array arreglo con números
     * @return int
     */
    public static int GetIndexWithHighestValue(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        int indexValiuWithHightValue = 0;

        for (int index = 0; index < array.length; index++) {
            if (array[index] > maxValue) {
                maxValue = array[index];
                indexValiuWithHightValue = index;
            }
        }
        return indexValiuWithHightValue;
    }

    /**
     * Convierte la columna de una matriz a un array
     *
     * @param matriz matriz
     * @param column columna a transponer
     * @return int[]
     */
    public static int[] TransposeMatrix(int[][] matriz, int column) {
        int row = matriz.length;
        int[] result = new int[row];
        List<Integer> test;

        for (int index = 0; index < row; index++) {
            result[index] = matriz[index][column];
        }
        return result;
    }
}
