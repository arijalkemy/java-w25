package org.example;

import org.example.exercise1.Basic;
import org.example.exercise1.Collector;
import org.example.exercise1.Executive;
import org.example.exercise2.Document;
import org.example.exercise2.IPrintable;
import org.example.exercise2.impl.Curriculum;
import org.example.exercise2.impl.PDFBook;
import org.example.exercise2.impl.Person;
import org.example.exercise3.Animal;
import org.example.exercise3.ICarnivorous;
import org.example.exercise3.IHerbivorous;
import org.example.exercise3.impl.Cat;
import org.example.exercise3.impl.Cow;
import org.example.exercise3.impl.Dog;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Exercise 1:
        System.out.println("TRANSACCIONES DE EJECUTIVO:");
        Executive executive = new Executive();
        executive.getTransactionList().forEach(transaction -> {
            transaction.transaccionOk();
            transaction.transaccionNoOk();
        });
        System.out.println("TRANSACCIONES DE BASIC:");
        Basic basic = new Basic();
        basic.getTransactionList().forEach(transaction -> {
            transaction.transaccionOk();
            transaction.transaccionNoOk();
        });
        System.out.println("TRANSACCIONES DE COBRADOR:");
        Collector collector = new Collector();
        collector.getTransactionList().forEach(transaction -> {
            transaction.transaccionOk();
            transaction.transaccionNoOk();
        });

        //Exercise 2:
        Document curriculum = new Curriculum(new Person("123", "Perez", "333443", 32),
                List.of("Java", "Python", "C#"));
        Document pdfBook = new PDFBook("Juan Perez", 100, "Java para todos");

        IPrintable.printContent(curriculum);
        IPrintable.printContent(pdfBook);

        //Exercise 3:
        Animal cat = new Cat();
        Animal cow = new Cow();
        Animal dog = new Dog();
        cat.makeSound();
        cow.makeSound();
        dog.makeSound();
        animalEat(dog);
    }
    private static void animalEat(Animal animal){
        if (animal instanceof ICarnivorous carnivorous) {
            carnivorous.eatMeat();
        } else if (animal instanceof IHerbivorous herbivorous) {
            herbivorous.eatGrass();
        } else {
            System.out.println("No es un animal carnívoro ni herbívoro");
        }
    }
}