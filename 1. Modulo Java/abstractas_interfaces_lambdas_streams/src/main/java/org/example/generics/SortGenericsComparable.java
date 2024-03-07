package org.example.generics;

public class SortGenericsComparable<T extends Comparable> {
    public void bubble(T[] obj) {
        T temp;
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj.length - 1; j++) {
                if (obj[j].compareTo(obj[j + 1]) == 1) {
                    temp = obj[j];
                    obj[j] = obj[j + 1];
                    obj[j + 1] = temp;
                }
            }
        }
    }
}
