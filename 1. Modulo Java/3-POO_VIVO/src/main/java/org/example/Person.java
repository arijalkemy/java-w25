package org.example;

public class Person {
    String name;
    int age;
    String dni;
    int weight;
    double height;

    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, int weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int cacularIMC(double weight, double height) {
        double calculo = weight/Math.pow(height, 2);

        if (calculo < 20) {
            return -1;
        } else if(calculo >= 20 && calculo <= 25 ) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(int age) {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Person { \n" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
