package com.COVID19.COVID19.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RiskPersonDto {
    private String firstName;
    private String lastName;
    private List<String> syntoms;

    public RiskPersonDto(String firstName, String lastName, List<String> syntoms) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.syntoms = syntoms;
    }
}
