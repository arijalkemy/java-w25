package com.sfritz.deportistas.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String name;
    private String lastname;
    private Integer age;
    private List<Sport> sports;
}
