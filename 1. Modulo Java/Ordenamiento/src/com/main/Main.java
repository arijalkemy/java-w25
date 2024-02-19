package com.main;

public class Main {
    public static int[] burbuja(int[] arreglo){
        boolean estaOrdenado;
        int  temp,tamano =arreglo.length;

        do{
            estaOrdenado=false;
            for (int i=0; i<tamano-1; i++){
                if(arreglo[i] > arreglo[i+1]){
                    temp = arreglo[i];
                    arreglo[i]= arreglo[i+1];
                    arreglo[i+1]=temp;
                    estaOrdenado=true;
                }
            }
            tamano --;

        }while (estaOrdenado);
        return arreglo;
    }

    public static void main(String[] args) {
        int[] arreglo= {2,6,30,8,-3,65,21,54,-21};
        int[] ordenado = burbuja(arreglo);
        for (int i=0; i<ordenado.length; i++){
            System.out.println(ordenado[i]);
        }
    }
}
