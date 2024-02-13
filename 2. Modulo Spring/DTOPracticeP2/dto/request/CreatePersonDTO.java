package com.meli.firstcontroller.sportsDTOPractice.dto.request;

import java.time.LocalDate;

public record CreatePersonDTO(
        String name,
        String lastName,
        LocalDate birthDate,
        String sportName
) {}
