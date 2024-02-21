package com.sfritz.deportistas.dto.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {
    private String name;
    private String lastname;
    private Integer age;
    private List<SportDTO> sports;
}
