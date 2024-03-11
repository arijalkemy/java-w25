package com.bootcamp.ejercicio_qatester.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class TestCaseDTO {
        private String description;
        private Boolean tested;
        private Boolean passed;
        private Integer number_of_tries;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate last_update;

}