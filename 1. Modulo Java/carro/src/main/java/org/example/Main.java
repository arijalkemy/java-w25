package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Automovil automovil = new Automovil();
//        Automovil automovil1 = new Automovil("ferrari", "rojo", 24000.0);
//        System.out.println(autoMovil1);


        List<Automovil> automoviles = new ArrayList<>();

        automoviles.add(new Automovil("lamborgini", "azul", 42000.0));
        automoviles.add(new Automovil("ferrari", "rojo", 24000.0));


        for (Automovil Automovil:automoviles) {
            System.out.println((Automovil)Automovil );
        }
    }
}