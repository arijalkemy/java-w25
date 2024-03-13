package com.example.testerapi.dtos;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResponsedto {
    private  String description;
    private  Boolean tested;
    private  Boolean passed;
    private  int number_of_tries;
    private  LocalDate last_update;

}