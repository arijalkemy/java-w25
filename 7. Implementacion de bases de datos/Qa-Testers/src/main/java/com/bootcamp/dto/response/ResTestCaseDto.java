package com.bootcamp.dto.response;

import com.bootcamp.dto.request.ReqTestCaseDto;
import com.bootcamp.service.ITestCaseService;
import com.bootcamp.service.impl.TestCaseServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ResTestCaseDto {

    @JsonProperty("id_case")
    Long idCase;
    @JsonProperty("description")
    String description;
    @JsonProperty("tested")
    Boolean tested;
    @JsonProperty("passed")
    Boolean passed;
    @JsonProperty("number_of_tries")
    Integer numberOfTries;
    @JsonProperty("last_update")
    LocalDate lastUpdate;


}
