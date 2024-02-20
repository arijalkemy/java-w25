package com.example.deporte.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaxDeporte {
    private Persona persona;
    private Deporte deporte;
}
