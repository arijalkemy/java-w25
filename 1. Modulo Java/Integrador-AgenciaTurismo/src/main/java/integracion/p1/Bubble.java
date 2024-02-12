package integracion.p1;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int [] intArray= {2,53,23,534,3,2,87,5};
        System.out.println("intArray = " + Arrays.toString(intArray));
        bubble(intArray);
        System.out.println("intArray = " + Arrays.toString(intArray));

    }

    public static int[] bubble(int[] intArray){
        for(int i=0; i<intArray.length; i++){
            for(int j=0; j<intArray.length-i-1; j++){
                if (intArray[j]<intArray[j+1]){
                    int aux = intArray[j];
                    intArray[j]=intArray[j+1];
                    intArray[j+1]=aux;
                }
            }
        }
        return  intArray;
    }
}
