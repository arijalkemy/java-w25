package com.example.qa_testers.dto.request;

import java.time.LocalDate;

public record TestCaseReqDTO(
        String description,
        Boolean tested,
        Boolean passed,
        Integer number_of_tries,
        LocalDate last_update
) {}
