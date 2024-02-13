package org.example.lambdas_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdasStreams {
    public static void main(String[] args) {

        //--------------------------------------LAMBDAS--------------------------------------

        // CONSUMIDORES p -> System.out.println(p)
        // BICONSUMIDORES (p,q) -> System.out.println(p+q)
        // PROVEEDORES () -> 10
        // FUNCIONES p -> p+10
        // BIFUNCIONES (p,q) -> p+q
        // PREDICADO p -> p==10
        // BIPREDICADO (p,q) -> p==q

        //--------------------------------------REFERENCIAS A MÉTODOS--------------------------------------

        //var -> System.out.println(var);
        //System.out::println;

        //var -> Math.sqrt(var);
        //Math::sqrt;

        //--------------------------------------STREAMS--------------------------------------

        //EJEMPLO 0
        List<String> names = new ArrayList<>();
        names.add("Nachuchi");
        names.add("Skay");
        names.add("Indio");

        names.stream().forEach(System.out::println);

        //EJEMPLO 1
        Stream.of("Argentina", "Colombia", "Uruguay", "Chile", "Brasil")
                .map(country -> country.toUpperCase())
                .forEach(System.out::println);

        //EJEMPLO 2
        List<String> countries =
                Stream.of("Argentina", "Colombia", "Uruguay", "Chile", "Brasil")
                        .map(country -> country.toUpperCase())
                        .collect(Collectors.toList());

        countries.forEach(System.out::println);

        //EJEMPLO 3
        Integer[] numberArray = {4, 2, 6, 9, 5};
        List<Integer> numbers = Arrays.asList(numberArray);

        numbers.stream()
                .filter(number -> number >= 5)
                .forEach(System.out::println);

        //EJEMPLO 4
        Integer[] numberArray2 = {4, 2, 6, 9, 5};
        List<Integer> numbers2 = Arrays.asList(numberArray2);

        Integer result = numbers2.stream().mapToInt(number -> number * number).sum();
        System.out.println(result);

        //EJEMPLO 5
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Mauro", "Accountant"),
                new Employee(2, "Gonzalo", "Systems"),
                new Employee(3, "Mariana", "Systems"),
                new Employee(4, "Amelia", "Administration"),
                new Employee(5, "Carlos", "Administration"),
                new Employee(6, "Elisa", "Systems"),
                new Employee(7, "Gerardo", "Accountant"),
                new Employee(8, "Manuel", "Administration"),
                new Employee(9, "Juan", "Systems"),
                new Employee(10, "Oriana", "Accountant")
                );

        employees.stream()
                .filter(x -> x.getDepartment().equals("Systems"))
                .sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName()))
                .forEach(System.out::println);
    }
}
