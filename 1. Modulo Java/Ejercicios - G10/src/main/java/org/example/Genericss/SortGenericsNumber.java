package org.example.generics;

public class SortGenericsNumber<T extends Number> {
    public void bubble(T[] obj) {
        T temp;
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj.length - 1; j++) {
                if (obj[j].doubleValue() > obj[j + 1].doubleValue()) {
                    temp = obj[j];
                    obj[j] = obj[j + 1];
                    obj[j + 1] = temp;
                }
            }
        }
    }
}
