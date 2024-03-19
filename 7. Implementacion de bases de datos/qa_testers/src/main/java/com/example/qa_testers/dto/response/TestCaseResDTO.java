package com.example.qa_testers.dto.response;

import java.time.LocalDate;

public record TestCaseResDTO(
        Long id_case,
        String description,
        Boolean tested,
        Boolean passed,
        Integer number_of_tries,
        LocalDate last_update
) {
}
