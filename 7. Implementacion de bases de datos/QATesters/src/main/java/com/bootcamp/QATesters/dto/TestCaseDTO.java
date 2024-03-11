package com.bootcamp.QATesters.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TestCaseDTO {
        private Long id_case;
        private String description;
        private Boolean tested;
        private Boolean passed;
        private Integer number_of_tries;
        private LocalDate last_update;}

