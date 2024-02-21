package org.example.generics;

import java.util.ArrayList;

public class Generics {
    public static void main(String[] args) {

        //GENERICS-------------------------------

        //COLECCIONES
        ArrayList<String> aS = new ArrayList<>();
        aS.add("Juan");
        aS.add("Pablo");
        for(String s:aS) System.out.println(s);

        ArrayList<Integer> aI = new ArrayList<>();
        aI.add(1);
        aI.add(2);
        for(int i:aI) System.out.println(i);



    }
}
