package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        int[] arreglo = {34, 98, 10, 23, 987, 12, 15, 26};
        burbuja(arreglo);
        immprimirArreglo(arreglo);

    }
    public static void burbuja(int[] arr){

        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[ j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void immprimirArreglo(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

}