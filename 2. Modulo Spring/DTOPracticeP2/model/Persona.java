package com.meli.firstcontroller.sportsDTOPractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private String name;
    private String lastName;
    private LocalDate birthDate;

}
