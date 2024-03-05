package com.example.athlete.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private String name;
    private String lastName;
    private int age;
    Sport sport;
}
