package org.example.generics;

import java.util.Comparator;

public class ComparaEnteros implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
