package com.example.testerapi.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestRequestdto {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private LocalDate last_update;

}