package com.example.athlete.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonSportsDTO {
    private String personName;
    private String personLastName;
    private String sportName;
}
