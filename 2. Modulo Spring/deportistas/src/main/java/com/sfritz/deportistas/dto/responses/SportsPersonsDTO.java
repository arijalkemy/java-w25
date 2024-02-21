package com.sfritz.deportistas.dto.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportsPersonsDTO {
    private String name;
    private String lastname;
    private List<String> sportsName;
}
