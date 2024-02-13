package com.meli.firstcontroller.sportsDTOPractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Deportista extends Persona {

    private Deporte deporte;

    public Deportista(String name, String lastName, LocalDate birthDate, Deporte deporte) {
        super(name, lastName, birthDate);
        this.deporte = deporte;
    }
}
