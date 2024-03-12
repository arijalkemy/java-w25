package com.bootcamp.QATesters.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class TestCaseDTO {
        @JsonAlias({"id_case"})
        private Long idCase;
        private String description;
        private Boolean tested;
        private Boolean passed;
        @JsonAlias({"number_of_tries"})
        private Integer numberOfTries;
        @JsonAlias({"last_update"})
        @JsonFormat(pattern="yyyy-MM-dd")
        private LocalDate lastUpdate;}

