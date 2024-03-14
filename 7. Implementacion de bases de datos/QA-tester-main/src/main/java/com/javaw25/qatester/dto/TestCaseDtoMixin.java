package com.javaw25.qatester.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public abstract class TestCaseDtoMixin {
    Long id_case;
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate last_update;
}
