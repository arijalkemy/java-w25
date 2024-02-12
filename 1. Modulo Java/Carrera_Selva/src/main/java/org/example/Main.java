package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Runner> runnerList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean s = true;
        while(s){
            Runner newRunner = new Runner();
            System.out.println(" Add runner number" );
            newRunner.runnerNumber = scanner.nextInt();
            System.out.println(" Add runner dne" );
            newRunner.dni = scanner.nextInt();
            System.out.println(" Add runner name" );
            newRunner.name = scanner.next();
            System.out.println(" Add runner lastname" );
            newRunner.name = scanner.next();
            System.out.println(" Add runner age" );
            newRunner.age = scanner.nextInt();
            System.out.println(" Add runner phone" );
            newRunner.name = scanner.next();
            System.out.println(" Add runner emergency phone" );
            newRunner.name = scanner.next();
            System.out.println(" Add runner blode type" );
            newRunner.name = scanner.next();

            System.out.println(" Add runner blode type" );
            int category = scanner.nextInt();

        }
    }
}