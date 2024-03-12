package com.bootcamp.QA_testers.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;


public record TestCaseReqDTO(
        String description,
        Boolean tested,
        Boolean passed,
        Integer number_of_tries,
        LocalDate last_update
) {}
